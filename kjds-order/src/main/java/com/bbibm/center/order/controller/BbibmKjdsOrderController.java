package com.bbibm.center.order.controller;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbibm.center.order.entity.BbibmKjdsOrder;
import com.bbibm.center.order.service.BbibmKjdsOrderService;
import com.rjkj.cf.common.core.util.R;
import com.rjkj.cf.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;




/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-13 13:35:39
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/bbibmkjdsorder" )
@Api(value = "bbibmkjdsorder", tags = "管理")
public class BbibmKjdsOrderController {

    private final BbibmKjdsOrderService bbibmKjdsOrderService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param bbibmKjdsOrder 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getBbibmKjdsOrderPage(Page page, BbibmKjdsOrder bbibmKjdsOrder) {
        return R.ok(bbibmKjdsOrderService.page(page, Wrappers.query(bbibmKjdsOrder)));
    }


    /**
     * 通过id查询
     * @param estimatedShippingFee id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{estimatedShippingFee}" )
    public R getById(@PathVariable("estimatedShippingFee" ) String estimatedShippingFee) {
        return R.ok(bbibmKjdsOrderService.getById(estimatedShippingFee));
    }

    /**
     * 新增
     * @param bbibmKjdsOrder 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('generator_bbibmkjdsorder_add')" )
    public R save(@RequestBody BbibmKjdsOrder bbibmKjdsOrder) {
        return R.ok(bbibmKjdsOrderService.save(bbibmKjdsOrder));
    }

    /**
     * 修改
     * @param bbibmKjdsOrder 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('generator_bbibmkjdsorder_edit')" )
    public R updateById(@RequestBody BbibmKjdsOrder bbibmKjdsOrder) {
        return R.ok(bbibmKjdsOrderService.updateById(bbibmKjdsOrder));
    }

    /**
     * 通过id删除
     * @param estimatedShippingFee id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{estimatedShippingFee}" )
    @PreAuthorize("@pms.hasPermission('generator_bbibmkjdsorder_del')" )
    public R removeById(@PathVariable String estimatedShippingFee) {
        return R.ok(bbibmKjdsOrderService.removeById(estimatedShippingFee));
    }

}
