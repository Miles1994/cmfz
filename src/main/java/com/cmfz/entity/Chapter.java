package com.cmfz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @Title: Chapter
 * @ProjectName demo
 * @Date 2018-12-21--14:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter implements Serializable {
    @Id
    private String id;
    private String title;
    private Double size;
    private Long duration;
    private String url;
    private Date upload_date;
    private Integer aid;
}
