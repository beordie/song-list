package com.beordie.user.model.repository;

import com.alibaba.fastjson2.JSON;
import com.beordie.common.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 10:02
 * @describe user entity
 */
@Component
@Slf4j
public class UserRepository {
    /**
     * users list in system
     */
    private List<User> users;

    private Cache<Integer, User> userCache = null;

    /**
     * get user from cache
     * @param userId
     * @return
     */
    public User getUser(int userId) {
        User user = userCache.get(userId, new Function<Integer, User>() {
            @Override
            public User apply(Integer s) {
                return selectUserFromRepository(userId);
            }
        });
        return user;
    }

    /**
     * select user by user id
     * @param userId
     * @return
     */
    private User selectUserFromRepository(int userId) {
        log.info("select user infomation by user id {}", userId);
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    @PostConstruct
    public void init() throws IOException {
        log.info("start fill users infomation......");
        File file = ResourceUtils.getFile("classpath:user.json");
        String json = FileUtils.readFileToString(file, "UTF-8");
        users = JSON.parseArray(json, User.class);
    }

    public UserRepository() {
        users = new ArrayList<>();

        userCache = Caffeine.newBuilder()
                .initialCapacity(1000)
                .maximumSize(10000)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build();
    }
}
