package com.cmfz.mapper;

import com.cmfz.entity.Album;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Administrator
 * @Title: AlbumMapper
 * @ProjectName demo
 * @Date 2018-12-21--14:24
 */
public interface AlbumMapper extends Mapper<Album> {
//    表连接查所有

    List<Album> queryAlbum();
}
