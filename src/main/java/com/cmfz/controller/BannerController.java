package com.cmfz.controller;

import com.cmfz.entity.Banner;
import com.cmfz.entity.PageDto;
import com.cmfz.service.BannerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

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


    //修改

    @RequestMapping("update")
    public String update(Banner banner) {
        bannerService.update(banner);
        return "";
    }

    //删除

    @RequestMapping("delete")
    public String delete(Banner banner) {
        bannerService.delete(banner);
        return "";
    }

    //添加

    @RequestMapping("add")
    public String add(Banner banner, MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        banner.setImg_path(fileName);
        banner.setStatus("N");
        bannerService.add(banner);
        // 文件上传后的路径
        String filePath = "E:\\MyIdeaProject\\ssmcmfz\\src\\main\\webapp\\image";
        File dest = new File(filePath + "/" + fileName);
        file.transferTo(dest);
        return "";
    }
}
