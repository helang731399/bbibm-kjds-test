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

import java.util.Date;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-20 14:08:17
 **/
@Data
@TableName("addressbook")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Addressbook extends Model<Addressbook> {
private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.INPUT)
    @ApiModelProperty(value="主键ID")
    private  Integer id;
    /**
     * 联系人姓名
     */
    @ApiModelProperty(value="联系人姓名")
    private String linkman;
    /**
     * 性别（0：女，1：男）
     */
    @ApiModelProperty(value="性别（0：女，1：男）")
    private Integer sex;
    /**
     * 联系人分组
     */
    @ApiModelProperty(value="联系人分组")
    private String groups;
    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value="生日")
    private Date birthday;
    /**
     * 移动电话
     */
    @ApiModelProperty(value="移动电话")
    private String phone;
    /**
     * 职务
     */
    @ApiModelProperty(value="职务")
    private String job;
    /**
     * QQ
     */
    @ApiModelProperty(value="QQ")
    private String qq;
    /**
     * ICQ
     */
    @ApiModelProperty(value="ICQ")
    private String icq;
    /**
     * MSN
     */
    @ApiModelProperty(value="MSN")
    private String msn;
    /**
     * 所在单位
     */
    @ApiModelProperty(value="所在单位")
    private String company;
    /**
     * 公司电话
     */
    @ApiModelProperty(value="公司电话")
    private String companyphone;
    /**
     * 传真
     */
    @ApiModelProperty(value="传真")
    private String companyfax;
    /**
     * 公司网址
     */
    @ApiModelProperty(value="公司网址")
    private String companyweb;
    /**
     * 公司地址
     */
    @ApiModelProperty(value="公司地址")
    private String companyaddress;
    /**
     * 电子邮箱
     */
    @ApiModelProperty(value="电子邮箱")
    private String email;
    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String note;
    }
