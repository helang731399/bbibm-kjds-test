package com.bbibm.memo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bbibm.memo.entity.Addressbook;
import com.bbibm.memo.reqvo.AddressbookVo;

/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-20 14:08:17
 **/
public interface AddressbookService extends IService<Addressbook> {

    IPage<Addressbook> selectPage(Page page, AddressbookVo addressbook);

    Object saveByExcel(String filepath);
}
