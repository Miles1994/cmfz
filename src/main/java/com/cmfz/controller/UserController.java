package com.cmfz.controller;

import com.cmfz.entity.User;
import com.cmfz.entity.UserMap;
import com.cmfz.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    //地区查询

    @RequestMapping("province")
    @ResponseBody
    public List<UserMap> province(String sex){
        List<UserMap> userMaps = userService.queryByProvince(sex);
        return userMaps;
    }

    //按注册时间，性别查询

    @RequestMapping("date")
    @ResponseBody
    public List<Integer> date(Integer date , String sex){
        List<Integer> list = new ArrayList<Integer>();
        list.add(userService.queryByDate(7, sex));
        list.add(userService.queryByDate(15, sex));
        list.add(userService.queryByDate(30, sex));
        list.add(userService.queryByDate(60, sex));
        return list;
    }

}
