package com.bbibm.log.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbibm.log.entity.Log;
import com.bbibm.log.entity.ManageMentality;
import com.bbibm.log.mapper.LogMapper;
import com.bbibm.log.mapper.ManageMentalityMapper;
import com.bbibm.log.mapper.TaskMapper;
import com.bbibm.log.repvo.LogVo;
import com.bbibm.log.repvo.TaskVo;
import com.bbibm.log.service.LogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-22 09:28:21
 **/
@Service
@AllArgsConstructor
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    private final LogMapper logMapper;
    private final ManageMentalityMapper manageMentalityMapper;
    private final TaskMapper taskMapper;

    /**
     *  提交日志
     * @param log
     * @param manageMentality
     * @return
     */
    @Override
    public Object commitLog(Log log, ManageMentality manageMentality) {
        if(logMapper.selectById(log.getLogId())!=null)
        {
            log.setLogStatus("已提交");
            logMapper.updateById(log);
            manageMentality.setLogId(log.getLogId());
            manageMentalityMapper.updateById(manageMentality);
        }
        else
        {
            try {
                log.setLogStatus("未提交");
                logMapper.insert(log);
                manageMentality.setLogId(log.getLogId());
                manageMentalityMapper.insert(manageMentality);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 保存
     * @param log
     * @param manageMentality
     * @return
     */
    @Override
    public Object saveLog(Log log, ManageMentality manageMentality) {
        if(logMapper.selectById(log.getLogId())!=null)
        {
            logMapper.updateById(log);
            manageMentality.setLogId(log.getLogId());
            manageMentalityMapper.updateById(manageMentality);
        }
        else
        {
            try {
                log.setLogStatus("未提交");
                logMapper.insert(log);
                manageMentality.setLogId(log.getLogId());
                manageMentalityMapper.insert(manageMentality);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 根据ID获取日志信息
     * @param logId
     * @return
     */
    @Override
    public LogVo getById(String logId) {
        LogVo logVo=new LogVo();
        logVo.setUserId(logMapper.selectById(logId).getUserId());
        logVo.setWorkDate(logMapper.selectById(logId).getWorkDate());
        logVo.setPeopleLooklog(logMapper.selectById(logId).getPeopleLooklog());
        logVo.setPeopleReview(logMapper.selectById(logId).getPeopleReview());
        logVo.setWorkSummary(logMapper.selectById(logId).getWorkSummary());
        logVo.setLearnToday(logMapper.selectById(logId).getLearnToday());
        logVo.setReflectToday(logMapper.selectById(logId).getReflectToday());
        logVo.setMethodImprove(logMapper.selectById(logId).getMethodImprove());
        logVo.setAttachment(logMapper.selectById(logId).getAttachment());
        logVo.setLogStatus(logMapper.selectById(logId).getLogStatus());
        logVo.setManageMentalityVo(manageMentalityMapper.selectNoID(logId));
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date=f.parse(f.format(logVo.getWorkDate()));
            List<TaskVo> list=taskMapper.selectListTask(logVo.getUserId(),date);
            logVo.setTaskVo(list);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return logVo;
    }
}
