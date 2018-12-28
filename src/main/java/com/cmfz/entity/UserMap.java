package com.cmfz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Administrator
 * @Title: UserMap
 * @ProjectName cmfz
 * @Date 2018-12-28--17:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ch_user")
public class UserMap implements Serializable {
    private Integer value;
    private String name;
}
