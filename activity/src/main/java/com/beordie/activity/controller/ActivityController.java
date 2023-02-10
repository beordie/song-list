package com.beordie.activity.controller;

import com.beordie.activity.config.ActivityConfig;
import com.beordie.activity.model.Activity;
import com.beordie.activity.model.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/6 13:46
 * @describe TODO
 */
@RestController
public class ActivityController {
    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("activity")
    public List<Activity> getActivities() {
        return activityRepository.getActivities().stream().limit(3).collect(Collectors.toList());
    }
}
