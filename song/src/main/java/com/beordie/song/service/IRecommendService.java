package com.beordie.song.service;

import com.beordie.common.model.SongCommend;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 14:27
 * @describe commend service
 */
@FeignClient("recommend-module")
public interface IRecommendService {
    @GetMapping("recommend")
    public SongCommend getUerSongRecommend(@RequestParam("recommend") String recommend);
}
