package com.beordie.common.model;

import lombok.Data;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 10:37
 * @describe song entity
 */
@Data
public class Song {
    /**
     * auto increment
     */
    private Integer songId;
    /**
     * song list name
     */
    private String songName;
    /**
     * song image
     */
    private String image;
    /**
     * 播放量
     */
    private Long playCount;
}
