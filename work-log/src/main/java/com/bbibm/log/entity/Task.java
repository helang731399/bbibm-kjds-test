package com.bbibm.log.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-22 14:56:28
 **/
@Data
@TableName("task")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Task extends Model<Task> {
private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value="ID")
    private Integer id;
    /**
     * 用户ID
     */
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
     * 汇报类别
     */
    @ApiModelProperty(value="汇报类别")
    private String reportType;
    /**
     * 主题
     */
    @ApiModelProperty(value="主题")
    private String theme;
    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    private String content;
    /**
     * 汇报内容
     */
    @ApiModelProperty(value="汇报内容")
    private String reportContent;
    /**
     * 完成进度
     */
    @ApiModelProperty(value="完成进度")
    private String progressCompleted;
    }
