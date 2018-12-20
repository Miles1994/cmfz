package com.cmfz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Administrator
 * @Title: Task
 * @ProjectName demo
 * @Date 2018-12-19--21:34
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Task implements Serializable {
    private Integer id;
    private String title;
    private String iconcls;
    private String url;
    private Integer parent_id;
}
