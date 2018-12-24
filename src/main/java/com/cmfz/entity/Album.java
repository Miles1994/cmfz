package com.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
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
@ExcelTarget("Album")
public class Album implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Excel(name = "编号", width = 10, needMerge = true)
    private Integer id;
    @Excel(name = "名称", width = 10, needMerge = true)
    private String title;
    @Excel(name = "集数", width = 10, needMerge = true)
    private Integer count;
    @Excel(name = "图片", width = 10, type = 2, needMerge = true)
    private String cover_img;
    @Excel(name = "评分", width = 10, needMerge = true)
    private Double score;
    @Excel(name = "作者", width = 10, needMerge = true)
    private String author;
    @Excel(name = "播音", width = 10, needMerge = true)
    private String voicer;
    @Excel(name = "简介", width = 10, needMerge = true)
    private String introduction;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 10, format = "yyyy-MM-dd", needMerge = true)
    private Date pub_date;
    @Transient
    @ExcelCollection(name = "音频")
    private List<Chapter> children;
}
