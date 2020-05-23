package com.bbibm.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbibm.log.entity.Task;
import com.bbibm.log.repvo.TaskVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @描述：
 * @项目：
 * @公司：软江科技
 * @作者：Qu.KePeng code generator
 * @时间：2020-05-22 14:56:28
 **/
@Mapper
public interface TaskMapper extends BaseMapper<Task> {

    /**
     * 查询员工本日任务进度
     *
     * @param userId
     * @param workDate
     * @return
     */
    List<TaskVo> selectListTask(@Param("userId") Integer userId, @Param("workDate") Date workDate);

}
;