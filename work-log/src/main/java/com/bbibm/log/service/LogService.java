package com.bbibm.log.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.bbibm.log.entity.Log;
import com.bbibm.log.entity.ManageMentality;
import com.bbibm.log.repvo.LogVo;

/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-22 09:28:21
 **/
public interface LogService extends IService<Log> {

    /**
     * 提交日志
     * @param log 日志
     * @param manageMentality 今日心态管理
     * @return 无
     */
    Object commitLog(Log log, ManageMentality manageMentality);

    /**
     * 保存
     * @param log
     * @param manageMentality
     * @return
     */
    Object saveLog(Log log, ManageMentality manageMentality);

    /**
     * 根据id获取日志信息
     * @param logId
     * @return
     */
    LogVo getById(String logId);
}
