package com.bbibm.order.entity;
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
 *@时间：2020-05-13 13:29:05
 **/
@Data
@TableName("recipient_address")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class RecipientAddress extends Model<RecipientAddress> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId(type= IdType.INPUT)
    @ApiModelProperty(value="")
    private String ordersn;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String phone;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String name;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String fullAddress;
    }
