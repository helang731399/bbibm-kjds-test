package com.bbibm.log.repvo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("task_vo")
@ApiModel(value = "")
public class TaskVo {
    /**
     * 汇报类别
     */
    @ApiModelProperty(value="汇报类别")
    private String reportType;
    /**
     * 主题
     */
    @ApiModelProperty(value="主题")
    private String theme;
    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    private String content;
    /**
     * 汇报内容
     */
    @ApiModelProperty(value="汇报内容")
    private String reportContent;
    /**
     * 完成进度
     */
    @ApiModelProperty(value="完成进度")
    private String progressCompleted;
}
