package com.bbibm.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbibm.log.entity.ManageMentality;
import com.bbibm.log.mapper.ManageMentalityMapper;
import com.bbibm.log.repvo.ManageMentalityVo;
import com.bbibm.log.service.ManageMentalityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;




/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-22 09:28:22
 **/
@Service
@AllArgsConstructor
public class ManageMentalityServiceImpl extends ServiceImpl<ManageMentalityMapper, ManageMentality> implements ManageMentalityService {

    private final ManageMentalityMapper manageMentalityMapper;

    /**
     *  根据ID查询今日心态管理
     * @param log_ID
     * @return 返回无ID实体类
     */
    @Override
    public ManageMentalityVo selectNoID(String log_ID) {
        return manageMentalityMapper.selectNoID(log_ID);
    }
}
