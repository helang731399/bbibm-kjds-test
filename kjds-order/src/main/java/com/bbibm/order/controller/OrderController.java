package com.bbibm.order.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bbibm.order.entity.BbibmKjdsOrder;
import com.bbibm.order.entity.BbibmOrderItme;
import com.bbibm.order.entity.GoodsStatus;
import com.bbibm.order.entity.RecipientAddress;
import com.bbibm.order.service.BbibmKjdsOrderService;
import com.bbibm.order.service.BbibmOrderItmeService;
import com.bbibm.order.service.RecipientAddressService;
import com.bbibm.order.util.DateUtil;
import com.rjkj.cf.common.core.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order" )
@Api(value = "order", tags = "订单同步功能测试")
public class OrderController {

    private final RecipientAddressService recipientAddressService;

    private final BbibmKjdsOrderService bbibmKjdsOrderService;

    private final BbibmOrderItmeService bbibmOrderItmeService;

    private final RedisTemplate redisTemplate;

    private final RestTemplate restTemplate;


    @ApiOperation(value = "test", notes = "test")
    @GetMapping("/selecttest" )
    @Async
    public void getSize()
    {
        List<LinkedHashMap<String,String>> goodsStatuses= (List<LinkedHashMap<String,String>>)restTemplate.getForObject("http://kjds-goods/goods/getGoodsStatus", R.class).getData();
        for(LinkedHashMap<String,String> test:goodsStatuses)
        {
            System.out.println(test.get("area")+"---"+test.get("sid"));
            getorder(test.get("area"),test.get("sid"));
        }
    }


    @ApiOperation(value = "查询订单信息", notes = "查询订单信息")
    @GetMapping("/select" )
    @Async
    public void getorder(String area,String shopId) {
        String url = "http://192.168.0.199:8666/goods/user/getOrder"+"?area="+area+"&shopId="+shopId;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            JSONObject jsonObject = JSON.parseObject(response.body().string());
            JSONArray orderArray=jsonObject.getJSONArray("orders");
            for(Object orders : orderArray)
            {
                String order=JSONObject.toJSONString(orders);
                JSONObject js=JSONObject.parseObject(order);
                JSONArray itemsArray=js.getJSONArray("items");
                RecipientAddress recipientAddress=js.getObject("recipient_address",RecipientAddress.class);
                BbibmKjdsOrder bbibmKjdsOrder =new BbibmKjdsOrder();
                bbibmKjdsOrder.setEstimatedShippingFee(js.getString("estimated_shipping_fee"));
                bbibmKjdsOrder.setPaymentMethod(js.getString("payment_method"));
                bbibmKjdsOrder.setMessageToSeller(js.getString("message_to_seller"));
                bbibmKjdsOrder.setShippingCarrier(js.getString("shipping_carrier"));
                bbibmKjdsOrder.setCurrency(js.getString("currency"));
                bbibmKjdsOrder.setCreateTime(DateUtil.LongToDate(js.getString("create_time")));
                bbibmKjdsOrder.setPayTime(DateUtil.LongToDate(js.getString("pay_time")));
                bbibmKjdsOrder.setDaysToShip(js.getInteger("days_to_ship"));
                bbibmKjdsOrder.setShipByDate(DateUtil.LongToDate(js.getString("ship_by_date")));
                bbibmKjdsOrder.setTrackingNo(js.getString("tracking_no"));
                bbibmKjdsOrder.setOrderStatus(DateUtil.ExchangeString(js.getString("order_status")));
                bbibmKjdsOrder.setUpdateTime(DateUtil.LongToDate(js.getString("update_time")));
                bbibmKjdsOrder.setEscrowAmount("escrow_amount");
                bbibmKjdsOrder.setGoodsToDeclare(js.getString("goods_to_declare"));
                bbibmKjdsOrder.setTotalAmount(js.getString("total_amount"));
                bbibmKjdsOrder.setServiceCode(js.getString("service_code"));
                bbibmKjdsOrder.setCountry(js.getString("country"));
                bbibmKjdsOrder.setOrdersn(js.getString("ordersn"));
                bbibmKjdsOrder.setBuyerUsername(js.getString("buyer_username"));
                setRedis(bbibmKjdsOrder,recipientAddress,itemsArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param bbibmKjdsOrder  d
     */
    private void setRedis(BbibmKjdsOrder bbibmKjdsOrder, RecipientAddress recipientAddress,JSONArray itemsArray)
    {
        try {
            boolean bool=redisTemplate.hasKey(bbibmKjdsOrder.getOrdersn());
            if (!bool) {
                recipientAddress.setOrdersn(bbibmKjdsOrder.getOrdersn());
                bbibmKjdsOrderService.save(bbibmKjdsOrder);
                redisTemplate.opsForValue().set(bbibmKjdsOrder.getOrdersn(), bbibmKjdsOrder.getOrderStatus());
                recipientAddressService.save(recipientAddress);
                setBbibmOrderItmeService(itemsArray,bbibmKjdsOrder.getOrdersn());
                System.out.println("插入");
            } else if (bool &&redisTemplate.opsForValue().get(bbibmKjdsOrder.getOrdersn()) != bbibmKjdsOrder.getOrderStatus()) {
                bbibmKjdsOrderService.updateOrderStatus(bbibmKjdsOrder.getOrdersn(), bbibmKjdsOrder.getOrderStatus());
                redisTemplate.opsForValue().set(bbibmKjdsOrder.getOrdersn(), bbibmKjdsOrder.getOrderStatus());
                System.out.println("更新");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void setBbibmOrderItmeService(JSONArray jsonArray,String ordersn)
    {
        try {
            //String orderItme = JSONObject.toJSONString(jsonArray);
            //JSONObject jsonObject=JSON.parseObject(orderItme);
            //JSONObject jsonObject = JSON.parseObject(response.body().string());
            //JSONArray orderArray=jsonObject.getJSONArray("orders");
            for(Object object:jsonArray) {
                String order=JSONObject.toJSONString(object);
                JSONObject jsonObject=JSONObject.parseObject(order);
                BbibmOrderItme bbibmOrderItme = new BbibmOrderItme();
                bbibmOrderItme.setOrdersn(ordersn);
                bbibmOrderItme.setWeight(jsonObject.getDouble("weight"));
                bbibmOrderItme.setItemName(jsonObject.getString("item_name"));
                bbibmOrderItme.setItemSku(jsonObject.getString("item_sku"));
                bbibmOrderItme.setVariationDiscountedPrice(jsonObject.getBigDecimal("variation_discounted_price"));
                bbibmOrderItme.setVariationId(jsonObject.getLong("variation_id"));
                bbibmOrderItme.setVariationName(jsonObject.getString("variation_name"));
                bbibmOrderItme.setIsAddOnDeal(jsonObject.getInteger("is_add_on_deal"));
                bbibmOrderItme.setItemId(jsonObject.getLong("item_id"));
                bbibmOrderItme.setVariationSku(jsonObject.getString("variation_sku"));
                bbibmOrderItme.setVariationOriginalPrice(jsonObject.getBigDecimal("variation_original_price"));
                bbibmOrderItme.setIsMainItem(jsonObject.getInteger("is_main_item"));
                bbibmOrderItmeService.save(bbibmOrderItme);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
