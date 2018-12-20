package com.cmfz.controller;

import com.cmfz.entity.Task;
import com.cmfz.service.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @Title: TaskController
 * @ProjectName demo
 * @Date 2018-12-19--22:21
 */
@RestController
@RequestMapping("/ta")
public class TaskController {
    @Resource
    private TaskService taskService;
    //查一级类别

    @RequestMapping("parent")
    @ResponseBody
    public List queryParent() {
        List<Task> tasks = taskService.queryParent();
        return tasks;
    }

    //查子分类

    @RequestMapping("second")
    @ResponseBody
    public List<Task> querySecond(Integer p_id) {
        List<Task> tasks = taskService.querySecond(p_id);
        return tasks;
    }
}
