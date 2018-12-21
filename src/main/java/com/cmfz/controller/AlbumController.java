package com.cmfz.controller;

import com.cmfz.entity.Album;
import com.cmfz.service.AlbumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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

}
