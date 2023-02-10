package com.beordie.song.service;

import com.beordie.common.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 13:49
 * @describe user service
 */
@FeignClient("user-module")
public interface IUserService {
    @GetMapping("/user")
    User getUserByUserId(@RequestParam("userId") int userId);
}
