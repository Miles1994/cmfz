package com.cmfz.controller;

import com.cmfz.entity.Banner;
import com.cmfz.entity.PageDto;
import com.cmfz.service.BannerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @Title: BannerController
 * @ProjectName demo
 * @Date 2018-12-20--14:41
 */
@RestController
@RequestMapping("/ban")
public class BannerController {
    @Resource
    private BannerService bannerService;

    //分页显示数据

    @RequestMapping("queryByPage")
    @ResponseBody
    public PageDto queryByPage(Integer page, Integer rows) {
        PageDto pageDto = bannerService.queryByPage(page, rows);
        return pageDto;
    }

    //查一个

    @RequestMapping("queryOne")
    @ResponseBody
    public Banner queryOne(Integer id) {
        return bannerService.queryById(id);
    }

    //修改

    @RequestMapping("update")
    public void update(Banner banner) {
        bannerService.update(banner);
    }
}
