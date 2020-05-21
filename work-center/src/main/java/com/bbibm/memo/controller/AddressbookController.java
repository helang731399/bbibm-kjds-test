package com.bbibm.memo.controller;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbibm.memo.entity.Addressbook;
import com.bbibm.memo.reqvo.AddressbookVo;
import com.bbibm.memo.service.AddressbookService;
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
 *@时间：2020-05-20 14:08:17
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/addressbook" )
@Api(value = "addressbook", tags = "通讯录管理")
public class AddressbookController {

    private final AddressbookService addressbookService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param addressbookvo
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getAddressbookPage(Page page, AddressbookVo addressbookvo) {
        return R.ok(addressbookService.selectPage(page,addressbookvo));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/id" )
    public R getById(String id) {
        return R.ok(addressbookService.getById(id));
    }

    /**
     * 新增
     * @param addressbook 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    public R save(@RequestBody Addressbook addressbook) {
        return R.ok(addressbookService.save(addressbook));
    }

    /**
     * 修改
     * @param addressbook 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    public R updateById(@RequestBody Addressbook addressbook) {
        return R.ok(addressbookService.updateById(addressbook));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/id" )
    public R removeById(String id) {
        return R.ok(addressbookService.removeById(id));
    }

    /**
     *
     * @param filepath  文件路径全称
     * @return
     */
    @ApiOperation(value = "通讯录批量导入", notes = "通讯录批量导入")
    @SysLog("通讯录批量导入" )
    @PostMapping("/filepath")
    public R saveByExcel(String filepath)
    {
        return R.ok(addressbookService.saveByExcel(filepath));
    }

}
