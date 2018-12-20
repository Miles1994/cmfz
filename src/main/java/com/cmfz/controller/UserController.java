package com.cmfz.controller;

import com.cmfz.entity.User;
import com.cmfz.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @Title: UserController
 * @ProjectName ssmcmfz
 * @Date 2018-12-19--19:41
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/us")
public class UserController {
    @Resource
    private UserService userService;


    //登录

    @RequestMapping("login")
    public String login(String phone, String password, Model model) {
        User user = userService.queryByphone(phone, password);
        model.addAttribute("user", user);
        return "main/main";
    }

    //注册

    @RequestMapping("regist")
    public String regist(User user) {
        userService.insertUser(user);
        return "login";
    }
}
