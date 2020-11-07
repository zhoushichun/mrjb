package com.cqmrjb.system.controller;


import com.cqmrjb.common.result.RCode;
import com.cqmrjb.common.result.Result;
import com.cqmrjb.system.base.controller.BaseController;
import com.cqmrjb.system.entity.BookingOrder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName:预约订单 前端控制器
 * @Description:
 * @author: zhou
 * @date 2020-11-02
 */
@RestController
@RequestMapping("/system/booking-order")
@Api(value = "/system/booking-order", tags = {"预约订单信息"})
@Slf4j
public class BookingOrderController extends BaseController {

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2020-11-02
     * @param:
     * @return:
     */
    @ApiOperation(value = "分页查询预约信息", notes = "分页查询预约信息")
    @PostMapping("/list")
    public Result list(@RequestBody BookingOrder entity) {
        if (entity.getCurrent() == 0) {
            entity.setCurrent(1);
        }
        if (entity.getSize() == 0) {
            entity.setSize(10);
        }
        PageHelper.startPage(entity.getCurrent(), entity.getSize());
        List<BookingOrder> list = bookingOrderService.listBookingOrder(entity.getAppid(), entity.getElectricType(), entity.getOrderSite(), entity.getServiceType(), entity.getPhone(), entity.getSmallRoutineName());
        return Result.SUCCESS(new PageInfo<>(list));
    }

    /**
     * @throws
     * @Title: 增加/修改
     * @author: zhou
     * @date 2020-11-02
     * @date: 2020/5/7 16:48
     * @param:
     * @return:
     */
    @ApiOperation(value = "增加/修改", notes = "增加/修改")
    @PostMapping("/add")
    public Result add(@RequestBody BookingOrder entity) {
        if (entity == null) {
            return Result.FAIL();
        }
        if (entity.getId() == null) {
            boolean b = entity.insert();
            if (!b) {
                return Result.FAIL();
            }
            entity.setAppid(null);
            entity.setElectricType(null);
            entity.setOrderSite(null);
            entity.setPhone(null);
            entity.setServiceType(null);
            entity.setSmallRoutineName(null);
            return list(entity);
        }
        boolean b = bookingOrderService.updateById(entity);
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
     * @date 2020-11-02
     * @param:
     * @return:
     */
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @PostMapping("/delete")
    public Result delete(@RequestParam long[] arr) {
        boolean b = bookingOrderService.doRemoveeIds(arr);
        if (!b) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }

}
