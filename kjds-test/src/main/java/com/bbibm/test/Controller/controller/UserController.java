package com.bbibm.test.Controller.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbibm.test.Controller.entity.User;
import com.bbibm.test.Controller.service.UserService;
import com.rjkj.cf.common.core.util.R;
import com.rjkj.cf.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;




/**
 *@描述：用户测试
 *@项目：
 *@公司：软江科技
 *@作者：helang
 *@时间：2020-05-12 14:20:54
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/user" )
@Api(value = "user", tags = "用户测试管理")
public class UserController {

    private final UserService userService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param user 用户测试
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getUserPage(Page page, User user) {
        return R.ok(userService.page(page, Wrappers.query(user)));
    }


    /**
     * 通过id查询用户测试
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(userService.getById(id));
    }

    /**
     * 新增用户测试
     * @param user 用户测试
     * @return R
     */
    @ApiOperation(value = "新增用户测试", notes = "新增用户测试")
    @SysLog("新增用户测试" )
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('用户模块_user_add')" )
    public R save(@RequestBody User user) {
        return R.ok(userService.save(user));
    }

    /**
     * 修改用户测试
     * @param user 用户测试
     * @return R
     */
    @ApiOperation(value = "修改用户测试", notes = "修改用户测试")
    @SysLog("修改用户测试" )
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('用户模块_user_edit')" )
    public R updateById(@RequestBody User user) {
        return R.ok(userService.updateById(user));
    }

    /**
     * 通过id删除用户测试
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除用户测试", notes = "通过id删除用户测试")
    @SysLog("通过id删除用户测试" )
    @DeleteMapping("/{id}" )
    //@PreAuthorize("@pms.hasPermission('用户模块_user_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(userService.removeById(id));
    }

}
