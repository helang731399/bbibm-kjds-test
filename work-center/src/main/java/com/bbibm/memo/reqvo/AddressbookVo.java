package com.bbibm.memo.reqvo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("addressbookVo")
@EqualsAndHashCode()
@ApiModel(value = "")
public class AddressbookVo {

    /**
     * 联系人姓名
     */
    @ApiModelProperty(value="联系人姓名")
    private String linkman;

    /**
     * 移动电话
     */
    @ApiModelProperty(value="移动电话")
    private String phone;

    /**
     * 公司电话
     */
    @ApiModelProperty(value="公司电话")
    private String companyphone;

    /**
     * QQ
     */
    @ApiModelProperty(value="QQ")
    private String qq;

    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty(value="生日")
    private Date birthday;

    /**
     * 所在单位
     */
    @ApiModelProperty(value="所在单位")
    private String company;

    /**
     * 联系人分组
     */
    @ApiModelProperty(value="联系人分组")
    private String groups;
}
