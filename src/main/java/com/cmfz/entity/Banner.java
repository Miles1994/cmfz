package com.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
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
@ExcelTarget("Banner")
public class Banner implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Excel(name = "编号", width = 20, height = 20, needMerge = true)
    private Integer id;
    @Excel(name = "名称", width = 20, height = 20, needMerge = true)
    private String name;
    @Excel(name = "图片", width = 20, height = 20, needMerge = true, type = 2)
    private String img_path;
    @Excel(name = "状态", width = 20, height = 20, needMerge = true)
    private String status;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 20, height = 20, needMerge = true, format = "yyyy-MM-dd")
    private Date pub_date;
    @Excel(name = "详情", width = 20, height = 20, needMerge = true)
    private String description;
}
