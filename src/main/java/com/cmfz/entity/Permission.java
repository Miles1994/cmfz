package com.cmfz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Administrator
 * @Title: Permission
 * @ProjectName cmfz
 * @Date 2019-01-06--10:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permission")
public class Permission implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String role;
    private String permission;
    private Integer r_id;
}
