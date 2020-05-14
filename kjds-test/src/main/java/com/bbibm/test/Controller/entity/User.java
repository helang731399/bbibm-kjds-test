package com.bbibm.test.Controller.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


    
/**
 *@描述：用户测试
 *@项目：
 *@公司：软江科技
 *@作者：helang
 *@时间：2020-05-12 14:20:54
 **/
@Data
@TableName("user")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户测试")
public class User extends Model<User> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type= IdType.INPUT)
    @ApiModelProperty(value="id")
    private Integer id;
    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;
    /**
     * 年龄
     */
    @ApiModelProperty(value="年龄")
    private Integer age;
    }
