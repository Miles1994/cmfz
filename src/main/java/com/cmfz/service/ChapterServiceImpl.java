package com.cmfz.service;

import com.cmfz.entity.Chapter;
import com.cmfz.mapper.ChapterMapper;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.UUID;

/**
 * @author Administrator
 * @Title: ChapterServiceImpl
 * @ProjectName demo
 * @Date 2018-12-21--18:42
 */
@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Resource
    private ChapterMapper chapterMapper;

    @Override
    public void insertChapter(Chapter chapter, MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        // 文件上传后的路径
        String filePath = "E:\\MyIdeaProject\\ssmcmfz\\src\\main\\webapp\\image\\album";
        File dest = new File(filePath + "/" + fileName);
        file.transferTo(dest);
        //为chapter注入文件大小
        long size = file.getSize();
        long size1 = size / 1024;
        chapter.setSize(size1);
        //为chapter注入文件路径
        chapter.setUrl(fileName);
        //获得chapter的id和aid
        String uid = UUID.randomUUID().toString();
        chapter.setId(uid);
        //获取文件时长,设置入chapter
        Encoder encoder = new Encoder();
        File source = new File("E:\\MyIdeaProject\\ssmcmfz\\src\\main\\webapp\\image\\album\\" + fileName);
        MultimediaInfo m = encoder.getInfo(source);
        long duration = m.getDuration();
        long second = duration / 1000 / 60;
        chapter.setDuration(second);
        chapterMapper.insertSelective(chapter);
    }
}
