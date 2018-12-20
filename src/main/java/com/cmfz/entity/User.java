package com.cmfz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @Title: User
 * @ProjectName demo
 * @Date 2018-12-19--19:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String phone;
    private String password;
    private String salt;
    private String sign;
    private String head_pic;
    private String name;
    private String dharma;
    private Integer sex;
    private String province;
    private String city;
    private Integer status;
    private Date reg_date;
}
