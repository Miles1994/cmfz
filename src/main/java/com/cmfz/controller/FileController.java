package com.cmfz.controller;

import com.cmfz.entity.Banner;
import com.cmfz.service.BannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author Administrator
 * @Title: FileController
 * @ProjectName demo
 * @Date 2018-12-20--18:42
 */
@RestController
@RequestMapping("file")
public class FileController {
    @Resource
    BannerService bannerService;
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    //文件上传相关代码
    @RequestMapping(value = "upload")
    public void upload(MultipartFile file, Banner banner) {
        // 获取文件名
        banner.setImg_path(file.getOriginalFilename());
        banner.setStatus("N");
        bannerService.add(banner);
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "E:\\MyIdeaProject\\ssmcmfz\\src\\main\\webapp\\image";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + "/" + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
