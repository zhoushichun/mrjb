package com.cqmrjb.system.controller;


import com.cqmrjb.common.result.RCode;
import com.cqmrjb.common.result.Result;
import com.cqmrjb.system.base.controller.BaseController;
import com.cqmrjb.system.entity.SmallRoutineInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName:小程序程序 前端控制器
 * @Description:
 * @author: zhou
 * @date 2020-10-29
 */
@RestController
@RequestMapping("/system/small-routine-info")
@Api(value = "/system/small-routine-info", tags = {"小程序信息"})
@Slf4j
public class SmallRoutineInfoController extends BaseController {

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2020-10-29
     * @param:
     * @return:
     */
    @ApiOperation(value = "分页查询所有小程序信息", notes = "分页查询所有小程序信息")
    @PostMapping("/list")
    public Result list(@RequestBody SmallRoutineInfo entity) {
        if (entity.getCurrent() == 0) {
            entity.setCurrent(1);
        }
        if (entity.getSize() == 0) {
            entity.setSize(10);
        }
        PageHelper.startPage(entity.getCurrent(), entity.getSize());
        List<SmallRoutineInfo> list = smallRoutineInfoService.listRoutineInfo(entity.getSmallRoutineName(), entity.getAppid(), entity.getManufacturers());
        return Result.SUCCESS(new PageInfo<>(list));
    }

    /**
     * @throws
     * @Title: 增加/修改
     * @author: zhou
     * @date 2020-10-29
     * @param:
     * @return:
     */
    @ApiOperation(value = "增加/修改", notes = "增加/修改")
    @PostMapping("/add")
    public Result add(@RequestBody SmallRoutineInfo entity) {

        if (entity == null) {
            return Result.FAIL();
        }

        if (entity.getId() == null) {
            SmallRoutineInfo smallRoutineInfo = smallRoutineInfoService.getAppid(entity.getAppid());
            if (smallRoutineInfo != null) {
                return Result.FAIL("appid已经存在");
            }
            boolean b = entity.insert();
            if (!b) {
                return Result.FAIL();
            }
            entity.setAppid(null);
            entity.setManufacturers(null);
            entity.setSmallRoutineName(null);
            return this.list(entity);
        }
        boolean b = smallRoutineInfoService.updateById(entity);
        if (!b) {
            return Result.FAIL();
        }
        entity.setAppid(null);
        entity.setManufacturers(null);
        entity.setSmallRoutineName(null);
        return this.list(entity);
    }

    /**
     * @throws
     * @Title: 删除
     * @Description: <p>删除使用物理删除</p>
     * @author: zhou
     * @date 2020-10-29
     * @param:
     * @return:
     */
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @PostMapping("/delete")
    public Result delete(@RequestParam long[] arr) {
        if (arr.length == 0) {
            return Result.FAIL();
        }
        boolean b = smallRoutineInfoService.doRemoveeIds(arr);
        if (!b) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }


}
