package com.beordie.song.model.repository;

import com.alibaba.fastjson2.JSON;
import com.beordie.common.model.Song;
import com.beordie.common.model.SongCommend;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 11:00
 * @describe song entity
 */
@Component
@Slf4j
public class SongRepository<T> {
    /**
     * song list
     */
    private List<Song> songs;

    private Cache<SongCommend<Integer, T>, List<Song>> songsCache = null;

    private List<Song> defaultSongs;

    /**
     * get default songs
     * @return
     */
    public List<Song> getDefaultSongs() {
        return defaultSongs;
    }

    /**
     * get region songs
     * @param offset
     * @param limit
     * @return
     */
    public List<Song> getSongs(int offset, int limit) {
        log.info("select songs information region ({}, {})", offset, limit);
        if (offset > this.songs.size()) {
            return null;
        }
        return this.songs.subList(offset, limit);
    }

    /**
     * get user from cache
     * @param userId
     * @return
     */
    public List<Song> getSongs(SongCommend<Integer, T> key) {
        List<Song> result = songsCache.get(key, new Function<SongCommend<Integer, T>, List<Song>>() {
            @Override
            public List<Song> apply(SongCommend<Integer, T> key) {
                return selectSongsFromRepository(key.getSongIds());
            }
        });
        return result;
    }

    /**
     * select user by user id
     * @param userId
     * @return
     */
    private List<Song> selectSongsFromRepository(Set<Integer> songsIds) {
        log.info("select songs information by songs id {}", songsIds.toArray());
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (songsIds.contains(song.getSongId())) {
                result.add(song);
            }
        }
        return result;
    }

    @PostConstruct
    public void init() throws IOException {
        log.info("start fill songs information......");
        File file = ResourceUtils.getFile("classpath:songs.json");
        String json = FileUtils.readFileToString(file, "UTF-8");
        songs = JSON.parseArray(json, Song.class);

        log.info("start fill default songs information......");
        for (int i = 0; i < songs.size() && defaultSongs.size() < 4; i++) {
            if (i % 2 == 1) {
                defaultSongs.add(songs.get(i));
            }
        }
    }

    public SongRepository() {
        songs = new ArrayList<>();
        defaultSongs = new ArrayList<>();
        songsCache = Caffeine.newBuilder()
                .initialCapacity(1000)
                .maximumSize(10000)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build();
    }
}
