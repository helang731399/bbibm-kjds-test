package com.bbibm.log.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bbibm.log.entity.ManageMentality;
import com.bbibm.log.repvo.ManageMentalityVo;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-22 09:28:22
 **/
public interface ManageMentalityService extends IService<ManageMentality> {

    ManageMentalityVo selectNoID(String log_ID);
}
