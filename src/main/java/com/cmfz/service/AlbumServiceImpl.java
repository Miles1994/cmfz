package com.cmfz.service;

import com.cmfz.entity.Album;
import com.cmfz.mapper.AlbumMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @author Administrator
 * @Title: AlbumServiceImpl
 * @ProjectName demo
 * @Date 2018-12-21--15:57
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Resource
    private AlbumMapper albumMapper;

    @Override
    public List<Album> queryAlbum() {
        List<Album> albums = albumMapper.queryAlbum();
        return albums;
    }

    @Override
    public Album queryOne(Integer id) {
        Album album = new Album();
        album.setId(id);
        Album album1 = albumMapper.selectByPrimaryKey(album);
        return album1;
    }

    @Override
    public void insertAlbum(Album album, MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        // 文件上传后的路径
        album.setCover_img(fileName);
        String filePath = "E:\\MyIdeaProject\\ssmcmfz\\src\\main\\webapp\\image\\album";
        File dest = new File(filePath + "/" + fileName);
        file.transferTo(dest);
        albumMapper.insertSelective(album);
    }
}
