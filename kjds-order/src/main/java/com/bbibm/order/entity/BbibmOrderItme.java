package com.bbibm.order.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-13 13:32:59
 **/
@Data
@TableName("bbibm_order_itme")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class BbibmOrderItme extends Model<BbibmOrderItme> {
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
    private Double weight;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String itemName;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String itemSku;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private BigDecimal variationDiscountedPrice;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long variationId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String variationName;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer isAddOnDeal;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long itemId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String variationSku;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private BigDecimal variationOriginalPrice;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer isMainItem;
    }
