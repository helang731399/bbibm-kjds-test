package com.bbibm.log.controller;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbibm.log.entity.Log;
import com.bbibm.log.entity.ManageMentality;
import com.bbibm.log.service.LogService;
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
 *@时间：2020-05-22 09:28:21
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/log" )
@Api(value = "log", tags = "管理")
public class LogController {

    private final LogService logService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param log 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getLogPage(Page page, Log log) {
        return R.ok(logService.page(page, Wrappers.query(log)));
    }


    /**
     * 通过id查询
     * @param logId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/logId" )
    public R getById( String logId) {
        return R.ok(logService.getById(logId));
    }

    /**
     * 保存
     * @param log
     * @param manageMentality
     * @return R
     */
    @ApiOperation(value = "保存", notes = "保存")
    @SysLog("保存" )
    @PostMapping("/saveLog")
    public R saveLog(@RequestBody Log log,ManageMentality manageMentality) {
        return R.ok(logService.saveLog(log,manageMentality));
    }

    /**
     * 提交点评
     * @param log
     * @param manageMentality
     * @return R
     */
    @ApiOperation(value = "提交点评", notes = "提交点评")
    @SysLog("提交点评" )
    @PostMapping("/commit")
    public R commit(@RequestBody Log log,ManageMentality manageMentality) {
        return R.ok(logService.commitLog(log,manageMentality));
    }

    /**
     * 修改
     * @param log 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    public R updateById(@RequestBody Log log) {
        return R.ok(logService.updateById(log));
    }

    /**
     * 通过id删除
     * @param logId id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/logId" )
    public R removeById( String logId) {
        return R.ok(logService.removeById(logId));
    }

}
