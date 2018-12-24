package com.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
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
@ExcelTarget("Chapter")
public class Chapter implements Serializable {
    @Id
    @Excel(name = "音频编号", width = 10)
    private String id;
    @Excel(name = "音频名称", width = 10)
    private String title;
    @Excel(name = "音频大小", width = 10)
    private Long size;
    @Excel(name = "音频时长", width = 10)
    private Long duration;
    @Excel(name = "音频连接", width = 20)
    private String url;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 10, format = "yyyy-MM-dd")
    private Date upload_date;
    @Excel(name = "专辑编号", width = 10)
    private Integer aid;
}
