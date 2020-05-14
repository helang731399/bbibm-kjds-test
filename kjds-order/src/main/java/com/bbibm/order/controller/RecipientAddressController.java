package com.bbibm.order.controller;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbibm.order.entity.RecipientAddress;
import com.bbibm.order.service.RecipientAddressService;
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
 *@时间：2020-05-13 13:29:05
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/recipientaddress" )
@Api(value = "recipientaddress", tags = "管理")
public class RecipientAddressController {

    private final RecipientAddressService recipientAddressService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param recipientAddress 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getRecipientAddressPage(Page page, RecipientAddress recipientAddress) {
        return R.ok(recipientAddressService.page(page, Wrappers.query(recipientAddress)));
    }


    /**
     * 通过id查询
     * @param ordersn id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{ordersn}" )
    public R getById(@PathVariable("ordersn" ) String ordersn) {
        return R.ok(recipientAddressService.getById(ordersn));
    }

    /**
     * 新增
     * @param recipientAddress 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('generator_recipientaddress_add')" )
    public R save(@RequestBody RecipientAddress recipientAddress) {
        return R.ok(recipientAddressService.save(recipientAddress));
    }

    /**
     * 修改
     * @param recipientAddress 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('generator_recipientaddress_edit')" )
    public R updateById(@RequestBody RecipientAddress recipientAddress) {
        return R.ok(recipientAddressService.updateById(recipientAddress));
    }

    /**
     * 通过id删除
     * @param ordersn id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{ordersn}" )
    @PreAuthorize("@pms.hasPermission('generator_recipientaddress_del')" )
    public R removeById(@PathVariable String ordersn) {
        return R.ok(recipientAddressService.removeById(ordersn));
    }

}
