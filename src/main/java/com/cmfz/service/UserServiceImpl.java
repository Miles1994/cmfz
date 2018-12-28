package com.cmfz.service;

import com.cmfz.entity.User;
import com.cmfz.entity.UserMap;
import com.cmfz.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @Title: UserServiceImpl
 * @ProjectName demo
 * @Date 2018-12-19--19:30
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User queryByphone(String phone, String password) {
        User user1 = new User();
        user1.setPassword(phone);
        User user = (User) userMapper.selectOne(user1);
        if (user == null) {
            throw new RuntimeException("用户名不存在");
        } else if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        } else {
            return user;
        }
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<UserMap> queryByProvince(String sex) {
        List<UserMap> userMaps = userMapper.queryByProvince(sex);
        return userMaps;
    }

    @Override
    public Integer queryByDate(Integer date, String sex) {
        Integer integer = userMapper.queryByDate(date, sex);
        return integer;
    }
}
