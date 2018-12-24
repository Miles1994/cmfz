package com.cmfz.service;

import com.cmfz.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 * @Title: ChapterService
 * @ProjectName demo
 * @Date 2018-12-21--18:42
 */
public interface ChapterService {
    void insertChapter(Chapter chapter, MultipartFile file) throws Exception;
}
