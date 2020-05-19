package com.bbibm.memo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbibm.memo.entity.Memo;
import com.bbibm.memo.mapper.MemoMapper;
import com.bbibm.memo.reqvo.MemoVo;
import com.bbibm.memo.service.MemoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-19 10:09:55
 **/
@Service
@AllArgsConstructor
public class MemoServiceImpl extends ServiceImpl<MemoMapper, Memo> implements MemoService {

    private final MemoMapper memoMapper;

    @Override
    public IPage selectbyMemo(Page page, MemoVo memoVo) {
        QueryWrapper<Memo> queryWrapper=new QueryWrapper<>();
        if(!memoVo.getContent().isEmpty())
        {
           queryWrapper.lambda().like(Memo::getContent,memoVo.getContent());
        }
        if(!memoVo.getStatus().isEmpty())
        {
            queryWrapper.lambda().like(Memo::getStatus,memoVo.getStatus());
        }
        if(!memoVo.getTheme().isEmpty())
        {
            queryWrapper.lambda().like(Memo::getTheme,memoVo.getTheme());
        }
        if(memoVo.getStartime()!=null && memoVo.getEndTime()!=null)
        {
            queryWrapper.lambda().between(Memo::getTime,memoVo.getStartime(),memoVo.getEndTime());
        }
        return memoMapper.selectPage(page,queryWrapper);
    }
}
