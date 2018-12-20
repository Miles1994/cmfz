package com.cmfz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Administrator
 * @Title: Admin
 * @ProjectName demo
 * @Date 2018-12-19--21:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private String password;
}
