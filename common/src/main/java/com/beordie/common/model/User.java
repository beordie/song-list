package com.beordie.common.model;

import lombok.Data;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 13:54
 * @describe user entity
 */
@Data
public class User {
    /**
     * auto increment
     */
    private Integer userId;
    /**
     * user cn name
     */
    private String username;
    /**
     * user account
     */
    private String accountId;

    public User(String username) {
        this.username = username;
    }

    public User() {
    }
}
