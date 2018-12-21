package com.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @Title: Album
 * @ProjectName demo
 * @Date 2018-12-21--14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String title;
    private Integer count;
    private String cover_img;
    private Double score;
    private String author;
    private String voicer;
    private String introduction;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pub_date;
    @Transient
    private List<Chapter> children;
}
