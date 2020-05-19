package com.bbibm.memo.entity;
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

import java.time.LocalDateTime;
import java.util.Date;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-19 10:09:55
 **/
@Data
@TableName("memo")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Memo extends Model<Memo> {
private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type= IdType.INPUT)
    @ApiModelProperty(value="主键ID")
    private Integer id;
    /**
     * 备忘人
     */
    @ApiModelProperty(value="备忘人")
    private String people;
    /**
     * 备忘日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty(value="备忘日期")
    private Date time;
    /**
     * 主题
     */
    @ApiModelProperty(value="主题")
    private String theme;
    /**
     * 可查看该备忘人员
     */
    @ApiModelProperty(value="可查看该备忘人员")
    private String admin;
    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private String createpeople;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty(value="创建时间")
    private Date createtime;
    /**
     * 处理状态
     */
    @ApiModelProperty(value="处理状态")
    private String status;
    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    private String content;
    /**
     * 
     */
    @ApiModelProperty(value="附件")
    private String attachment;
    }
