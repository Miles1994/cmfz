package com.cmfz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 * @Title: PageDto
 * @ProjectName demo
 * @Date 2018-12-20--14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto implements Serializable {
    private List<Banner> rows;
    private Integer total;
}
