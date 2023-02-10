package com.beordie.song.controller;

import com.beordie.common.model.Song;
import com.beordie.song.service.ISongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 14:43
 * @describe song public interface
 */
@RestController
@RequestMapping("song")
@Slf4j
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("all")
    public List<Song> getAllSongs(@RequestParam("offset") Integer offset,
                                  @RequestParam("limit") Integer limit) {
        return songService.getAllSongs(offset, limit);
    }

    @GetMapping("user/{userId}")
    public List<Song> getAllSongs(@PathVariable("userId") Integer userId) {
        return songService.getCommendSongs(userId);
    }
}
