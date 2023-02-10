package com.beordie.user.controller;

import com.beordie.common.model.User;
import com.beordie.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 9:53
 * @describe user public interface
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private IUserService userServiceImpl;

    @GetMapping("")
    public User getUser(@RequestParam("userId") Integer userId) {
        if (userId == null) {
            log.warn("request parameter {userId} havn't empty ");
            return new User("游客");
        }
        return userServiceImpl.getUser(userId);
    }
}
