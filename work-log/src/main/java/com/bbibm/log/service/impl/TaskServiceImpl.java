package com.bbibm.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbibm.log.entity.Task;
import com.bbibm.log.mapper.TaskMapper;
import com.bbibm.log.repvo.TaskVo;
import com.bbibm.log.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-22 14:56:28
 **/
@Service
@AllArgsConstructor
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    private final TaskMapper taskMapper;

    /**
     * 查询员工今日进度报告
     * @param userId
     * @param workDate
     * @return
     */
    @Override
    public List<TaskVo> selectListTask(Integer userId, Date workDate) {
        return taskMapper.selectListTask(userId,workDate);
    }
}
