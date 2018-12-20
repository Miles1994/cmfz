package com.cmfz.mapper;

import com.cmfz.entity.Banner;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Administrator
 * @Title: BannerMapper
 * @ProjectName demo
 * @Date 2018-12-20--14:17
 */
public interface BannerMapper extends Mapper<Banner> {
    List<Banner> queryByPage(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

    // 查询所有页
    Integer totalCount();
}
