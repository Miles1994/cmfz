package com.cmfz;

import com.cmfz.entity.Album;
import com.cmfz.mapper.AlbumMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ssmcmfzApplicationTests {
    @Resource
    AlbumMapper albumMapper;
    @Test
    public void contextLoads() {
        List<Album> albums = albumMapper.queryAlbum();
        System.out.println(albums);
        for (Album album : albums) {
            System.out.println(album);
        }
    }

}

