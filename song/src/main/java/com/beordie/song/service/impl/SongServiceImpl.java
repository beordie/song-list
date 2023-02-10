package com.beordie.song.service.impl;

import com.beordie.common.model.Song;
import com.beordie.common.model.SongCommend;
import com.beordie.common.model.User;
import com.beordie.song.model.repository.SongRepository;
import com.beordie.song.service.IRecommendService;
import com.beordie.song.service.ISongService;
import com.beordie.song.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 13:38
 * @describe song service
 */
@Service
@Slf4j
public class SongServiceImpl implements ISongService {
    @Autowired
    private SongRepository<String> songRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRecommendService recommendService;

    @Override
    public List<Song> getAllSongs(int offset, int limit) {
        return songRepository.getSongs(offset, limit);
    }

    @Override
    public List<Song> getCommendSongs(Integer userId) {
        if (userId == null) {
            return songRepository.getDefaultSongs();
        }
        User user = userService.getUserByUserId(userId);
        if (user == null) {
            log.warn("select user by user id {} error, user is empty.", userId);
            return songRepository.getDefaultSongs();
        }
        SongCommend recommend = recommendService.getUerSongRecommend(user.getAccountId());
        return songRepository.getSongs(recommend);
    }
}
