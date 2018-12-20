package com.cmfz.controller;

import com.cmfz.entity.Admin;
import com.cmfz.service.AdminService;
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
    public String login(String name, String password, Model model) {
        Admin admin = adminService.queryOneByName(name, password);
        model.addAttribute("admin", admin);
        return "main/main";
    }

    //注册

    @RequestMapping("regist")
    public String regist(Admin admin) {
        adminService.insertAdmin(admin);
        return "login";
    }
}
