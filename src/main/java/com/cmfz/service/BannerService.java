package com.cmfz.service;

import com.cmfz.entity.Banner;
import com.cmfz.entity.PageDto;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * @Title: BannerService
 * @ProjectName demo
 * @Date 2018-12-20--14:38
 */
public interface BannerService {
    PageDto queryByPage(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

    Banner queryById(Integer id);

    void update(Banner banner);
}
