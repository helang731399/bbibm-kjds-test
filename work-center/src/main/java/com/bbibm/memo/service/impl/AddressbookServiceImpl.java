package com.bbibm.memo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbibm.memo.entity.Addressbook;
import com.bbibm.memo.mapper.AddressbookMapper;
import com.bbibm.memo.reqvo.AddressbookVo;
import com.bbibm.memo.service.AddressbookService;
import com.bbibm.memo.util.SexUtil;
import com.bbibm.memo.util.XLSXtoJSON;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;


/**
 *@描述：
 *@项目：
 *@公司：软江科技
 *@作者：Qu.KePeng code generator
 *@时间：2020-05-20 14:08:17
 **/
@Service
@AllArgsConstructor
public class AddressbookServiceImpl extends ServiceImpl<AddressbookMapper, Addressbook> implements AddressbookService {

    private final AddressbookMapper addressbookMapper;

    private final XLSXtoJSON xlsXtoJSON;

    private final SexUtil sexUtil;

    @Override
    public IPage<Addressbook> selectPage(Page page, AddressbookVo addressbook) {
        LambdaQueryWrapper<Addressbook> lambdaQueryWrapper=new QueryWrapper<Addressbook>().lambda();
        if(StringUtils.isNotEmpty(addressbook.getLinkman()))
        {
            lambdaQueryWrapper.like(Addressbook::getLinkman,addressbook.getLinkman());
        }
        if(StringUtils.isNotEmpty(addressbook.getPhone()))
        {
            lambdaQueryWrapper.like(Addressbook::getPhone,addressbook.getPhone());
        }
        if(StringUtils.isNotEmpty(addressbook.getCompanyphone()))
        {
            lambdaQueryWrapper.like(Addressbook::getCompanyphone,addressbook.getCompanyphone());
        }
        if(StringUtils.isNotEmpty(addressbook.getQq()))
        {
            lambdaQueryWrapper.like(Addressbook::getQq,addressbook.getQq());
        }
        if(addressbook.getBirthday()!=null)
        {
            lambdaQueryWrapper.eq(Addressbook::getBirthday,addressbook.getBirthday());
        }
        if(StringUtils.isNotEmpty(addressbook.getCompany()))
        {
            lambdaQueryWrapper.like(Addressbook::getCompany,addressbook.getCompany());
        }
        if(StringUtils.isNotEmpty(addressbook.getGroups())){
            lambdaQueryWrapper.like(Addressbook::getGroups,addressbook.getGroups());
        }
        return addressbookMapper.selectPage(page,lambdaQueryWrapper);
    }

    @Override
    public Object saveByExcel(String filepath) {
        try {
            ArrayList<String> jsonString= xlsXtoJSON.xlsx_to_json(filepath);
            for(String jsonStr:jsonString)
            {
                Addressbook addressbook = new Addressbook();
                JSONObject jsonObject= JSON.parseObject(jsonStr);
                addressbook.setGroups(jsonObject.getString("联系人分组"));
                addressbook.setLinkman(jsonObject.getString("联系人姓名"));
                addressbook.setSex(sexUtil.stringToInt(jsonObject.getString("性别")));
                addressbook.setCompany(jsonObject.getString("公司名称"));
                addressbook.setBirthday(jsonObject.getDate("生日"));
                addressbook.setPhone(jsonObject.getString("移动电话"));
                addressbook.setCompanyphone(jsonObject.getString("公司电话"));
                addressbook.setEmail(jsonObject.getString("电子邮件"));
                addressbook.setCompanyfax(jsonObject.getString("传真"));
                addressbook.setQq(jsonObject.getString("QQ"));
                addressbook.setIcq(jsonObject.getString("ICQ"));
                addressbook.setMsn(jsonObject.getString("MSN"));
                addressbook.setCompanyweb(jsonObject.getString("公司网址"));
                addressbook.setCompanyaddress(jsonObject.getString("公司地址"));
                addressbook.setJob(jsonObject.getString("联系人职务"));
                addressbook.setNote(jsonObject.getString("备注"));
                addressbookMapper.insert(addressbook);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
