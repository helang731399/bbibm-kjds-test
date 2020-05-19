package com.bbibm.memo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bbibm.memo.entity.Memo;
import com.bbibm.memo.reqvo.MemoVo;

/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-19 10:09:55
 **/
public interface MemoService extends IService<Memo> {

    IPage selectbyMemo(Page page, MemoVo memoVo);
}
