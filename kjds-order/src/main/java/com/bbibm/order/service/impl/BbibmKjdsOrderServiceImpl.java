package com.bbibm.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbibm.order.entity.BbibmKjdsOrder;
import com.bbibm.order.entity.GoodsStatus;
import com.bbibm.order.mapper.BbibmKjdsOrderMapper;
import com.bbibm.order.service.BbibmKjdsOrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-13 13:35:39
 **/
@Service
public class BbibmKjdsOrderServiceImpl extends ServiceImpl<BbibmKjdsOrderMapper, BbibmKjdsOrder> implements BbibmKjdsOrderService {

    private RestTemplate restTemplate;

    @Override
    public void updateOrderStatus(String Ordersn, String status) {

    }

    /*@Override
    public List<GoodsStatus> getgoodsStatus() {
        List<GoodsStatus> list=restTemplate.getForObject("http://kjds-goods:8997/goods/getGoodsStatus",
                List.class);
        return list;
    }*/
}
