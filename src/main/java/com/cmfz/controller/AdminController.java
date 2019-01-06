package com.cmfz.controller;

import com.cmfz.entity.Admin;
import com.cmfz.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @Title: AdminController
 * @ProjectName demo
 * @Date 2018-12-19--21:07
 */
@Controller
@RequestMapping("/ad")
public class AdminController {
    @Resource
    private AdminService adminService;

    //登录

    @RequestMapping("login")
    public String login(String name, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);
            return "/main/main";
        } catch (UnknownAccountException e) {
            System.out.println("账号错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return "login";
        }
    }

    //注册

    @RequestMapping("regist")
    public String regist(Admin admin) {
        adminService.insertAdmin(admin);
        return "login";
    }
}
