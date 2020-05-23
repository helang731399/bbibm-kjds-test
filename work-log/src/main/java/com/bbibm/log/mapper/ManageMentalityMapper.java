package com.bbibm.log.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbibm.log.entity.ManageMentality;
import com.bbibm.log.repvo.ManageMentalityVo;
import org.apache.ibatis.annotations.Mapper;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-22 09:28:22
 **/
@Mapper
public interface ManageMentalityMapper extends BaseMapper<ManageMentality> {

    ManageMentalityVo selectNoID(String log_ID);

}
