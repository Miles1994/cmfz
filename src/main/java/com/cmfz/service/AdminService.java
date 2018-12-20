package com.cmfz.service;

import com.cmfz.entity.Admin;

/**
 * @author Administrator
 * @Title: AdminService
 * @ProjectName demo
 * @Date 2018-12-19--21:02
 */
public interface AdminService {
    Admin queryOneByName(String name, String password);

    void insertAdmin(Admin admin);
}
