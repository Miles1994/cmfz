package com.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.cmfz.entity.Album;
import com.cmfz.service.AlbumService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author Administrator
 * @Title: AlbumController
 * @ProjectName demo
 * @Date 2018-12-21--15:59
 */
@RestController
@RequestMapping("/alu")
public class AlbumController {
    @Resource
    private AlbumService albumService;

    //    查所有专辑

    @RequestMapping("queryAlbum")
    @ResponseBody
    public List<Album> queryAlbum() {
        List<Album> albums = albumService.queryAlbum();
        return albums;
    }

    //根据专辑id查询

    @RequestMapping("queryOne")
    @ResponseBody
    public Album queryOne(Integer id) {
        Album album = albumService.queryOne(id);
        return album;
    }

    //添加专辑

    @RequestMapping("add")
    @ResponseBody
    public String addAlbum(Album album, MultipartFile file) throws Exception {
        albumService.insertAlbum(album, file);
        return "";
    }

    //数据导出

    @RequestMapping("export")
    public void export(HttpSession session, HttpServletResponse response) {
        List<Album> albums = albumService.queryAlbum();
        //获取下载目录
        String realPath = session.getServletContext().getRealPath("/image");
        for (Album album : albums) {
            //设置下载路径为绝对路径
            String cover_img = album.getCover_img();
            album.setCover_img(realPath + "/" + cover_img);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑详情", "专辑"),
                Album.class, albums);
        try {
            String name = URLEncoder.encode("专辑详情.xls", "UTF-8");
            //设置响应头
            response.setHeader("content-disposition", "attachment;filename=" + name);
            //响应类型
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
