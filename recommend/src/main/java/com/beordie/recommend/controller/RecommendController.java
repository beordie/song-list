package com.beordie.recommend.controller;

import com.beordie.common.model.SongCommend;
import com.beordie.recommend.service.IRecommendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 14:34
 * @describe recommend public interface
 */
@RestController
@RequestMapping("recommend")
@Slf4j
public class RecommendController {
    @Autowired
    private IRecommendService recommendService;

    @GetMapping("")
    public SongCommend getRecommend(@RequestParam("recommend") String recommend) {
        return recommendService.getUerSongRecommend(recommend);
    }
}
