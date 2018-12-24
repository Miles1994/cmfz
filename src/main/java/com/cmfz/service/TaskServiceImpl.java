package com.cmfz.service;

import com.cmfz.entity.Task;
import com.cmfz.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @Title: TaskServiceImpl
 * @ProjectName demo
 * @Date 2018-12-19--22:11
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskMapper taskMapper;

    @Override
    public List<Task> queryParent() {
        Task task = new Task();
        task.setParent_id(0);
        List<Task> tasks = taskMapper.select(task);
        return tasks;
    }

    @Override
    public List<Task> querySecond(Integer p_id) {
        Task task = new Task();
        task.setParent_id(p_id);
        List<Task> tasks = taskMapper.select(task);
        return tasks;
    }

}
