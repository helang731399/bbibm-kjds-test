package com.bbibm.test.Controller;

import com.rjkj.cf.common.core.util.R;
import com.rjkj.cf.common.log.annotation.SysLog;
import com.rjkj.cf.common.security.annotation.Inner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/test" )
@Api(value = "test", tags = "测试新项目")
public class TestController {

    @ApiOperation(value = "测试新项目", notes = "测试新项目")
    @SysLog("测试新项目" )
    @PostMapping("/gettest")
    @ApiImplicitParam(name ="type",value = "ios或者android（1为android  0为ios）",required = true,dataType = "String")
    @Inner(value = false)
    public R gettset()
    {
        return R.ok("测试成功！！");
    }
}
