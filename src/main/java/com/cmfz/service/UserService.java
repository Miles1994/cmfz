package com.cmfz.service;

import com.cmfz.entity.User;
import com.cmfz.entity.UserMap;

import java.util.List;

/**
 * @author Administrator
 * @Title: UserService
 * @ProjectName demo
 * @Date 2018-12-19--19:28
 */
public interface UserService {
    User queryByphone(String phone, String passwrod);

    void insertUser(User user);

    //地区分布查询

    List<UserMap> queryByProvince(String sex);

    //注册时间，性别查询

    Integer queryByDate(Integer date , String sex);
}
