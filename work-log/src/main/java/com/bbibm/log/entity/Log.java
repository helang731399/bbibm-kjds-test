package com.bbibm.log.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-22 09:28:21
 **/
@Data
@TableName("log")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Log extends Model<Log> {
private static final long serialVersionUID = 1L;

    /**
     * 日志ID
     */
    @TableId(type= IdType.INPUT)
    @ApiModelProperty(value="日志ID")
    private String logId;
    /**
     * 用户ID
     */
    @TableId(type= IdType.INPUT)
    @ApiModelProperty(value="用户ID")
    private Integer userId;
    /**
     * 工作日期
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value="工作日期")
    private Date workDate;
    /**
     * 可查看该日志的人员
     */
    @ApiModelProperty(value="可查看该日志的人员")
    private String peopleLooklog;
    /**
     * 点评人
     */
    @ApiModelProperty(value="点评人")
    private String peopleReview;
    /**
     * 工作总结
     */
    @ApiModelProperty(value="工作总结")
    private String workSummary;
    /**
     * 今日学习
     */
    @ApiModelProperty(value="今日学习")
    private String learnToday;
    /**
     * 今日反省
     */
    @ApiModelProperty(value="今日反省")
    private String reflectToday;
    /**
     * 改进方法
     */
    @ApiModelProperty(value="改进方法")
    private String methodImprove;
    /**
     * 附件
     */
    @ApiModelProperty(value="附件")
    private String attachment;
    /**
     * 日志状态
     */
    @ApiModelProperty(value="日志状态")
    private String logStatus;
    }
