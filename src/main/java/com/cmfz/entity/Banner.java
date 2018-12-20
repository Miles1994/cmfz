package com.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @Title: Banner
 * @ProjectName demo
 * @Date 2018-12-20--14:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private String img_path;
    private String status;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pub_date;
    private String description;
}
