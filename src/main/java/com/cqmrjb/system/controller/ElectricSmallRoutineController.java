package com.cqmrjb.system.controller;


import com.cqmrjb.common.result.RCode;
import com.cqmrjb.common.result.Result;
import com.cqmrjb.system.base.controller.BaseController;
import com.cqmrjb.system.entity.ElectricSmallRoutine;
import com.cqmrjb.system.entity.ElectricSmallRoutineVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: 前端控制器
 * @Description:
 * @author: zhou
 * @date 2020-11-04
 */
@RestController
@RequestMapping("/system/electric-small-routine")
@Api(value = "/system/electric-small-routine", tags = {"小程序-电器类型信息"})
@Slf4j
public class ElectricSmallRoutineController extends BaseController {

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2020-11-04
     * @param:
     * @return:
     */
    @ApiOperation(value = "查询小程序-电器类型信息", notes = "查询小程序-电器类型信息")
    @PostMapping("/list")
    public Result list(@RequestBody ElectricSmallRoutine entity) {


        if (entity.getCurrent() == 0) {
            entity.setCurrent(1);
        }
        if (entity.getSize() == 0) {
            entity.setSize(10);
        }

        PageHelper.startPage(entity.getCurrent(), entity.getSize());
        List<ElectricSmallRoutineVO> list = electricSmallRoutineService.listElectricSmallRoutine(entity.getAppid(), entity.getElectricType());

        return Result.SUCCESS(new PageInfo<>(list));
    }

    /**
     * @throws
     * @Title: 增加/修改
     * @author: zhou
     * @date 2020-11-04
     * @date: 2020/5/7 16:48
     * @param:
     * @return:
     */
    @ApiOperation(value = "增加/修改小程序-电器类型", notes = "增加/修改小程序-电器类型")
    @PostMapping("/add")
    @Transactional
    public Result add(@RequestBody Map<String, Object> entitys) {

        if (entitys.isEmpty()) {
            return Result.FAIL();
        }
        String appId = null;
        try {
            appId = entitys.get("id").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }


        ArrayList arrayList = null;
        try {
            this.deleteByAppId(appId);
            arrayList = (ArrayList) entitys.get("entity");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (arrayList.size() == 0) {
            return Result.FAIL();
        }

        for (Object o : arrayList) {

            try {
                ElectricSmallRoutine electricSmallRoutine = new ElectricSmallRoutine();
                electricSmallRoutine.setAppid(appId);
                electricSmallRoutine.setElectricTypeId((Long) o);
                boolean insert = electricSmallRoutine.insert();
                if (!insert) {
                    return Result.FAIL();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ElectricSmallRoutine electricSmallRoutine = new ElectricSmallRoutine();
        electricSmallRoutine.setAppid(appId);
        return this.list(electricSmallRoutine);

    }

    /**
     * @throws
     * @Title: 删除
     * @Description: <p>删除使用物理删除</p>
     * @author: zhou
     * @date 2020-11-04
     * @param:
     * @return:
     */
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @PostMapping("/delete")
    public Result delete(@RequestParam long[] arr) {
        boolean b = electricSmallRoutineService.doRemoveeIds(arr);
        if (!b) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }

    /**
     * @throws
     * @Title: 删除
     * @Description: <p>删除使用物理删除</p>
     * @author: zhou
     * @date 2020-11-04
     * @param:
     * @return:
     */
    @ApiOperation(value = "根据appid删除关联信息", notes = "根据appid删除关联信息")
    @PostMapping("/deleteByAppId")
    public void deleteByAppId(String appid) {
        electricSmallRoutineService.deleteByAppId(appid);

    }

}
