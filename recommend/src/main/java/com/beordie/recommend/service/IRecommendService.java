package com.beordie.recommend.service;

import com.beordie.common.model.SongCommend;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 14:16
 * @describe commend service interface
 */
public interface IRecommendService<K> {
    public SongCommend getUerSongRecommend(K recommend);
}
