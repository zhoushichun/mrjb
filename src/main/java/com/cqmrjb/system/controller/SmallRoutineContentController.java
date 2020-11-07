package com.cqmrjb.system.controller;


import com.cqmrjb.common.result.RCode;
import com.cqmrjb.common.result.Result;
import com.cqmrjb.system.base.controller.BaseController;
import com.cqmrjb.system.entity.SmallRoutineContent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName:小程序内容 前端控制器
 * @Description:
 * @author: zhou
 * @date 2020-10-29
 */
@RestController
@RequestMapping("/system/small-routine-content")
@Api(value = "/system/small-routine-content", tags = {"小程序内容信息"})
@Slf4j
public class SmallRoutineContentController extends BaseController {

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2020-10-29
     * @param:
     * @return:
     */
    @ApiOperation(value = "分页查询小程序内容信息", notes = "查询信息")
    @PostMapping("/list")
    public Result list(@RequestBody SmallRoutineContent entity) {
        if(entity.getCurrent()==0){
            entity.setCurrent(1);
        }
        if(entity.getSize()==0){
            entity.setSize(10);
        }
        PageHelper.startPage(entity.getCurrent(), entity.getSize());
        List<SmallRoutineContent> list = smallRoutineContentService.listRoutineContentInfo(entity.getTitle(), entity.getContent(),entity.getAppid());
        return Result.SUCCESS(new PageInfo<>(list));
    }

    /**
     * @throws
     * @Title: 增加/修改
     * @author: zhou
     * @date 2020-10-29
     * @date: 2020/5/7 16:48
     * @param:
     * @return:
     */
    @ApiOperation(value = "增加/修改", notes = "增加/修改")
    @PostMapping("/add")
    public Result add(@RequestBody SmallRoutineContent entity) {
        if (entity == null) {
            return Result.FAIL();
        }
        if (entity.getId() == null) {
            SmallRoutineContent smallRoutineContent = smallRoutineContentService.getSmallRoutineContentByTitle(entity.getTitle());
            if (smallRoutineContent != null) {
                return Result.FAIL("标题已经存在");
            }
            boolean b = entity.insert();
            if (!b) {
                return Result.FAIL();
            }
            entity.setAppid(null);
            entity.setContent(null);
            entity.setTitle(null);
            return this.list(entity);
        }
        boolean b = smallRoutineContentService.updateById(entity);
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
     * @date 2020-10-29
     * @param:
     * @return:
     */
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @PostMapping("/delete")
    public Result delete(@RequestParam long[] arr) {
        boolean b = smallRoutineContentService.doRemoveeIds(arr);
        if (!b) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }


}
