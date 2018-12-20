package com.cmfz.service;

import com.cmfz.entity.User;

/**
 * @author Administrator
 * @Title: UserService
 * @ProjectName demo
 * @Date 2018-12-19--19:28
 */
public interface UserService {
    User queryByphone(String phone, String passwrod);

    void insertUser(User user);
}
