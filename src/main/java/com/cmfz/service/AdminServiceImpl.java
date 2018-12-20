package com.cmfz.service;

import com.cmfz.entity.Admin;
import com.cmfz.mapper.AdminMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @Title: AdminServiceImpl
 * @ProjectName demo
 * @Date 2018-12-19--21:03
 */

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin queryOneByName(String name, String password) {
        Admin admin1 = new Admin();
        admin1.setName(name);
        Admin admin = adminMapper.selectOne(admin1);
        if (admin == null) {
            throw new RuntimeException("账户不存在");
        } else if (!admin.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        } else {
            return admin;
        }
    }

    @Override
    public void insertAdmin(Admin admin) {
        adminMapper.insert(admin);
    }
}
