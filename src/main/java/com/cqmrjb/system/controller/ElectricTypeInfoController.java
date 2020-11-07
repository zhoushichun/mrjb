package com.cqmrjb.system.controller;


import com.cqmrjb.common.result.RCode;
import com.cqmrjb.common.result.Result;
import com.cqmrjb.system.base.controller.BaseController;
import com.cqmrjb.system.entity.ElectricTypeInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName:电器类型 前端控制器
 * @Description:
 * @author: zhou
 * @date 2020-11-03
 */
@RestController
@RequestMapping("/system/electric-type-info")
@Api(value = "/system/electric-type-info", tags = {"电器类型信息"})
@Slf4j
public class ElectricTypeInfoController extends BaseController {

    /**
     * @throws
     * @Title: 分页查询电器类型信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2020-11-03
     * @param:
     * @return:
     */
    @ApiOperation(value = "分页查询电器类型信息", notes = "分页查询电器类型信息")
    @PostMapping("/list")
    public Result<ElectricTypeInfo> list(@RequestBody ElectricTypeInfo entity) {
        if (entity.getCurrent() == 0) {
            entity.setCurrent(1);
        }
        if (entity.getSize() == 0) {
            entity.setSize(10);
        }
        PageHelper.startPage(entity.getCurrent(), entity.getSize());

        List<ElectricTypeInfo> list = electricTypeInfoService.listElectricTypeInfo(entity.getElectricType());
        return Result.SUCCESS(new PageInfo<>(list));
    }

    /**
     * @throws
     * @Title: 增加/修改
     * @author: zhou
     * @date 2020-11-03
     * @date: 2020/5/7 16:48
     * @param:
     * @return:
     */
    @ApiOperation(value = "增加/修改", notes = "增加/修改")
    @PostMapping("/add")
    public Result add(@RequestBody ElectricTypeInfo entity) {
        if (entity == null) {
            return Result.FAIL();
        }
        if (entity.getId() == null) {
            if (entity.getElectricType() == null) {
                return Result.FAIL("信息不能为空");
            }
            boolean b = entity.insert();

            if (!b) {
                return Result.FAIL();
            }
            entity.setElectricType(null);
            return this.list(entity);
        }
        boolean b = electricTypeInfoService.updateById(entity);
        if (!b) {
            return Result.FAIL();
        }
        entity.setElectricType(null);
        return this.list(entity);
    }

    /**
     * @throws
     * @Title: 删除
     * @Description: <p>删除使用物理删除</p>
     * @author: zhou
     * @date 2020-11-03
     * @param:
     * @return:
     */
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @DeleteMapping("/delete")
    public Result delete(@RequestParam long[] arr) {
        boolean b = electricTypeInfoService.doRemoveeIds(arr);
        if (!b) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }

}
