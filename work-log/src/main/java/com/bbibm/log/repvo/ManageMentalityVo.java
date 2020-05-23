package com.bbibm.log.repvo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("manage_mentalityVo")
@ApiModel(value = "")
public class ManageMentalityVo {

    /**
     *  认真
     */
    @ApiModelProperty(value="认真")
    private String earnest;
    /**
     *   快
     */
    @ApiModelProperty(value="快")
    private String quick;
    /**
     *   坚守承诺
     */
    @ApiModelProperty(value="坚守承诺")
    private String honest;
    /**
     *   保证完成任务
     */
    @ApiModelProperty(value="保证完成任务")
    private String commitment;
    /**
     *  乐观
     */
    @ApiModelProperty(value="乐观")
    private String optimistic;
    /**
     *  自信
     */
    @ApiModelProperty(value="自信")
    private String confident;
    /**
     *  爱与奉献
     */
    @ApiModelProperty(value="爱与奉献")
    private String love;
    /**
     *  绝不找接口
     */
    @ApiModelProperty(value="绝不找接口")
    private String noReason;
}
