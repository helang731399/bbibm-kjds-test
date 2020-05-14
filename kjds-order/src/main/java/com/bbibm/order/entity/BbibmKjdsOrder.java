package com.bbibm.order.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-13 13:35:39
 **/
@Data
@TableName("bbibm_kjds_order")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class BbibmKjdsOrder extends Model<BbibmKjdsOrder> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ApiModelProperty(value="")
    private String estimatedShippingFee;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String paymentMethod;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String messageToSeller;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String shippingCarrier;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String currency;
    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value="")
    private LocalDateTime createTime;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime payTime;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer daysToShip;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime shipByDate;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String trackingNo;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String orderStatus;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime updateTime;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String escrowAmount;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String goodsToDeclare;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String totalAmount;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String serviceCode;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String country;
    /**
     * 
     */
    @TableId(type=IdType.INPUT)
    @ApiModelProperty(value="")
    private String ordersn;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String buyerUsername;
    }
