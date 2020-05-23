package com.bbibm.center.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bbibm.center.order.entity.BbibmKjdsOrder;

/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-13 13:35:39
 **/

public interface BbibmKjdsOrderService extends IService<BbibmKjdsOrder> {

    void updateOrderStatus(String Ordersn,String status);

    //List<GoodsStatus> getgoodsStatus();
}
