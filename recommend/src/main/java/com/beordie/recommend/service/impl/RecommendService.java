package com.beordie.recommend.service.impl;

import com.beordie.common.model.SongCommend;
import com.beordie.recommend.service.IRecommendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 14:18
 * @describe song commend service
 */
@Service
@Slf4j
public class RecommendService implements IRecommendService<String> {
    @Override
    public SongCommend getUerSongRecommend(String recommend) {
        SongCommend songCommend = new SongCommend<Integer, String>();;
        Integer[] commends = Arrays.stream(((String) recommend).split("-")).map(Integer::parseInt).toArray(Integer[]::new);
        songCommend.setSongIds(commends);
        songCommend.setKey(recommend);
        return songCommend;
    }
}
