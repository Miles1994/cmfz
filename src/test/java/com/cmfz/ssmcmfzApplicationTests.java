package com.cmfz;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.cmfz.entity.Album;
import com.cmfz.mapper.AlbumMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ssmcmfzApplicationTests {
    @Resource
    private AlbumMapper albumMapper;

    @Test
    public void testPoi() {
        List<Album> albums = albumMapper.queryAlbum();

        for (Album album : albums) {
            String cover_img = album.getCover_img();
            String npath = "E:\\MyIdeaProject\\ssmcmfz\\src\\main\\webapp\\image\\" + cover_img;
            album.setCover_img(npath);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑详情", "专辑"),
                Album.class, albums);
        try {
            workbook.write(new FileOutputStream(new File("E:/aaaaaa.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

