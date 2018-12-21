package com.cmfz.service;

import com.cmfz.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Administrator
 * @Title: AlbumService
 * @ProjectName demo
 * @Date 2018-12-21--15:57
 */
public interface AlbumService {
    //查所有

    List<Album> queryAlbum();

    //根据专辑id查询

    Album queryOne(Integer id);

    //添加专辑

    void insertAlbum(Album album, MultipartFile file) throws Exception;
}
