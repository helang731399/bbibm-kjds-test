package com.bbibm.time.controller;

import com.rjkj.cf.common.core.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@AllArgsConstructor
@RequestMapping("/time" )
@Api(value = "user", tags = "定时调用测试")
public class timeController {


    @GetMapping("/test" )
    public R getById( ) {
        System.out.println("调用成功"+new Date());
        return R.ok();
    }

}
