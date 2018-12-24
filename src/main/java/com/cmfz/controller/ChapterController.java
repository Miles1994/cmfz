package com.cmfz.controller;

import com.cmfz.entity.Chapter;
import com.cmfz.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author Administrator
 * @Title: ChapterController
 * @ProjectName demo
 * @Date 2018-12-21--18:54
 */
@RestController
@RequestMapping("/ch")
public class ChapterController {
    @Resource
    private ChapterService chapterService;

    //添加音频

    @RequestMapping("addChapter")
    @ResponseBody
    public String addChapter(Chapter chapter, MultipartFile file) throws Exception {
        System.out.println(chapter);
        chapterService.insertChapter(chapter, file);
        return "";
    }

    //文件下载

    @RequestMapping("download")
    public void download(String name, HttpSession session, HttpServletResponse response) throws IOException {
        String realPath = session.getServletContext().getRealPath("/image/album");
        byte[] bs = FileUtils.readFileToByteArray(new File(realPath + "/" + name));
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8"));
        ServletOutputStream out = response.getOutputStream();
        out.write(bs);
        if (out != null) {
            out.flush();
        }
        if (out != null) {
            out.close();
        }
    }
}
