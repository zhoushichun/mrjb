package com.cqmrjb.system.controller;


import com.cqmrjb.common.result.RCode;
import com.cqmrjb.common.result.Result;
import com.cqmrjb.system.base.controller.BaseController;
import com.cqmrjb.system.entity.ElectricService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: 前端控制器
 * @Description:
 * @author: zhou
 * @date 2020-11-04
 */
@RestController
@RequestMapping("/system/electric-service")
@Api(value = "/system/electric-service", tags = {"电器-服务范围信息"})
@Slf4j
@Transactional
public class ElectricServiceController extends BaseController {

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2020-11-04
     * @param:
     * @return:
     */
    @ApiOperation(value = "查询电器类型-服务范围信息", notes = "查询电器类型-服务范围信息")
    @PostMapping("/list")
    public Result list(@RequestBody ElectricService entity) {
        if (entity.getCurrent() == 0) {
            entity.setCurrent(1);
        }
        if (entity.getSize() == 0) {
            entity.setSize(10);
        }
        PageHelper.startPage(entity.getCurrent(), entity.getSize());
        List<ElectricService> list = electricServiceService.listElectricService(entity.getAppid(), entity.getElectricType(), entity.getServiceType());


        return Result.SUCCESS(list);
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
    @ApiOperation(value = "增加/修改电器和服务范围", notes = "增加/修改电器和服务范围")
    @PostMapping("/add")
    @Transactional
    public Result add(@RequestBody Map<String, Object> entitys) {
        if (entitys.isEmpty()) {
            return Result.FAIL();
        }
        String appid;
        Long electricId;
        try {
            appid = entitys.get("appid").toString();
            electricId = (Long) entitys.get("id");
        } catch (Exception e) {
            return Result.FAIL("注意》id只能为Long类型");

        }
        ArrayList arrayList;
        try {
            this.deleteByAppId(electricId);
            arrayList = (ArrayList) entitys.get("entity");
        } catch (Exception e) {
            return Result.FAIL("类型转换失败");
        }
        if (arrayList.size() == 0) {
            return Result.FAIL();
        }
        for (Object o : arrayList) {
            try {
                ElectricService electricService = new ElectricService();
                electricService.setElectricTypeId(electricId);
                electricService.setServiceTypeId((Long) o);
                boolean insert = electricService.insert();
                if (!insert) {
                    return Result.FAIL();
                }
            } catch (Exception e) {
                return Result.FAIL("电器类型的ID只能为Long类型");
            }
        }

        List<ElectricService> electricServices = electricServiceService.listElectricService(appid, null, null);

        ArrayList<Object> objects = new ArrayList<>();

        for (ElectricService electricService : electricServices) {
            objects.add(electricService.getElectricType());
        }

        return Result.SUCCESS(objects);


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
        boolean b = electricServiceService.doRemoveeIds(arr);
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
    @ApiOperation(value = "根据电器类型删除关联信息", notes = "根据电器类型删除关联信息")
    @PostMapping("/deleteByElectricId")
    public void deleteByAppId(Long electricId) {
        electricServiceService.deleteByAppId(electricId);

    }

}
