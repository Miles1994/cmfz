package com.cmfz.service;

import com.cmfz.entity.Task;

import java.util.List;

/**
 * @author Administrator
 * @Title: TaskService
 * @ProjectName demo
 * @Date 2018-12-19--21:36
 */
public interface TaskService {
    List<Task> queryParent();

    List<Task> querySecond(Integer p_id);


}
