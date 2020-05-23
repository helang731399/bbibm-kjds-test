package com.bbibm.log.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-22 09:28:22
 **/
@Data
@TableName("manage_mentality")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class ManageMentality extends Model<ManageMentality> {
private static final long serialVersionUID = 1L;

    /**
     * 日志ID
     */
    @TableId(type = IdType.INPUT)
    @ApiModelProperty(value="日志ID")
    private String logId;
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
