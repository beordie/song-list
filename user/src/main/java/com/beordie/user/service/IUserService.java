package com.beordie.user.service;

import com.beordie.common.model.User;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/3 9:54
 * @describe user interface
 */
public interface IUserService extends BaseService {
    /**
     * get user to select songs
     * @param userId
     * @return
     */
    User getUser(Integer userId);
}
