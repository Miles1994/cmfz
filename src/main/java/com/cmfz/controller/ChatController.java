package com.cmfz.controller;

import io.goeasy.GoEasy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @Title: ChatController
 * @ProjectName cmfz
 * @Date 2018-12-28--19:25
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping("we")
    @ResponseBody
    public void wechat(String chat){
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io","BC-e7f30516a3d540fbae7de5a03c654ee4");
        goEasy.publish("myChannel",chat);
    }

}
