package com.bbibm.memo.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbibm.memo.entity.Memo;
import com.bbibm.memo.reqvo.MemoVo;
import com.bbibm.memo.service.MemoService;
import com.bbibm.memo.util.DatetoLocalDateTimeUtil;
import com.bbibm.memo.util.FileUpdate;
import com.rjkj.cf.common.core.util.R;
import com.rjkj.cf.common.log.annotation.SysLog;
import io.minio.errors.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-19 10:09:55
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/memo" )
@Api(value = "memo", tags = "管理")
public class MemoController {

    private final MemoService memoService;

    private FileUpdate fileUpdate;

    /**
     * 分页查询
     * @param page 分页对象
     * @param memo 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getMemoPage(Page page, Memo memo) {
        return R.ok(memoService.page(page, Wrappers.query(memo)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/id" )
    public R getById(Integer id) {
        return R.ok(memoService.getById(id));
    }

    /**
     * 新增
     * @param memo 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    public R save(@RequestBody Memo memo) throws IOException, XmlPullParserException, NoSuchAlgorithmException, RegionConflictException, InvalidKeyException, InvalidArgumentException, ErrorResponseException, NoResponseException, InvalidBucketNameException, InsufficientDataException, InternalException {
        fileUpdate.get(memo.getAttachment());
        return R.ok(memoService.save(memo));
    }

    /**
     * 修改
     * @param memo 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    public R updateById(@RequestBody Memo memo) {
        return R.ok(memoService.updateById(memo));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("id" )
    public R removeById(Integer id) {
        return R.ok(memoService.removeById(id));
    }

    /**
     * 条件查询
     * @param
     * @return
     */
    @ApiOperation(value = "条件查询", notes = "条件查询")
    @SysLog("条件查询" )
    @PostMapping("/select")
    public R getMemoList(Page page, MemoVo memoVo) {
        return R.ok(memoService.selectbyMemo(page,memoVo));
    }
}
