package com.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Long size;
    private Long duration;
    private String url;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date upload_date;
    private Integer aid;
}
