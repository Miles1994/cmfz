package com.cmfz.mapper;

import com.cmfz.entity.Admin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Administrator
 * @Title: AdminMapper
 * @ProjectName demo
 * @Date 2018-12-19--20:59
 */
public interface AdminMapper extends Mapper<Admin> {
    Admin queryAllByPermissionOfRole(@Param("name")  String name);
}
