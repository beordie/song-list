package com.beordie.song.service;


import com.beordie.common.model.Song;

import java.util.List;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 11:42
 * @describe song service interface
 */
public interface ISongService extends BaseService {
    /**
     * get all songs
     * @param offset
     * @param limit
     * @return
     */
    List<Song> getAllSongs(int offset, int limit);

    /**
     * get user commend songs
     * @param userId
     * @return
     */
    List<Song> getCommendSongs(Integer userId);
}
