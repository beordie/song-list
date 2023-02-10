package com.beordie.user.service.impl;

import com.beordie.common.model.User;
import com.beordie.user.model.repository.UserRepository;
import com.beordie.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 10:00
 * @describe user service
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Integer userId) {
        User user = userRepository.getUser(userId);
        return user;
    }
}
