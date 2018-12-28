package com.cmfz.mapper;

import com.cmfz.entity.User;
import com.cmfz.entity.UserMap;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Administrator
 * @Title: UserMapper
 * @ProjectName demo
 * @Date 2018-12-19--19:28
 */
public interface UserMapper extends Mapper<User> {
    //地区查询

    List<UserMap> queryByProvince(String sex);

    //注册时间，性别查询

    Integer queryByDate(@Param("date") Integer date , @Param("sex") String sex);
}
