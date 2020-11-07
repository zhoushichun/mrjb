package com.cqmrjb.system.controller;

import com.cqmrjb.common.result.Result;
import com.cqmrjb.system.base.controller.BaseController;
import com.cqmrjb.system.entity.UserInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.List;


@RestController
@RequestMapping("/system/userInfo")
@Api(value = "/system/user", tags = {"用户信息"})
@Slf4j
public class UserInfoController extends BaseController {

    /**
     * 用户登录
     *
     * @param entity 用户信息对象
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/login")
    @ApiOperation(value = "登录", notes = "登录")
    public Result getToken(@RequestBody UserInfo entity) {

        String login = userInfoService.login(entity);

        if (login.contains("登录成功")) {
            return Result.SUCCESS(login);
        }

        return Result.FAIL(login);
    }


    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2020-10-29
     * @param:
     * @return:
     */
    @ApiOperation(value = "分页查询用户信息", notes = "分页查询用户信息")
    @PostMapping("/list")
    public Result list(@RequestBody UserInfo entity) {
        if (entity.getCurrent() == 0) {
            entity.setCurrent(1);
        }
        if (entity.getSize() == 0) {
            entity.setSize(10);
        }
        PageHelper.startPage(entity.getCurrent(), entity.getSize());
        List<UserInfo> list = userInfoService.listUserInfo(entity.getPhone(), entity.getRole());
        return Result.SUCCESS(new PageInfo<>(list));
    }

}
