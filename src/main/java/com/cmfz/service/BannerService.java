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
    //分页查询

    PageDto queryByPage(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

    //修改状态

    void update(Banner banner);

    //删除一行

    void delete(Banner banner);

    //添加

    void add(Banner banner);
}
