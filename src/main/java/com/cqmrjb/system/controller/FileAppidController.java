package com.cqmrjb.system.controller;

import com.cqmrjb.common.result.RCode;
import com.cqmrjb.common.result.Result;
import com.cqmrjb.system.base.controller.BaseController;
import com.cqmrjb.system.entity.FileAppid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: 前端控制器
 * @Description:
 * @author: zhou
 * @date 2020-11-02
 */
@RestController
@RequestMapping("/system/file-appid")
@Api(value = "/system/file-appid", tags = {"小程序-文件信息"})
@Slf4j
public class FileAppidController extends BaseController {

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2020-11-02
     * @param:
     * @return:
     */
    @ApiOperation(value = "分页查询小程序-文件信息", notes = "分页查询小程序-文件信息")
    @PostMapping("/list")
    public Result list(@RequestBody FileAppid entity) {
        if(entity.getCurrent()==0){
            entity.setCurrent(1);
        }
        if(entity.getSize()==0){
            entity.setSize(10);
        }
        PageHelper.startPage(entity.getCurrent(), entity.getSize());

        List<FileAppid> list = fileAppidService.listFileAppidInfo(entity.getAppid(), entity.getFileId(), entity.getSmallRoutineName());
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
    @ApiOperation(value = "增加/修改小程序关联的文件", notes = "增加/修改小程序关联的文件")
    @PostMapping("/add")
    public Result add(@RequestBody FileAppid entity) {
        if (entity == null) {
            return Result.FAIL();
        }
        if (entity.getId() == null) {
            boolean b = entity.insert();
            if (!b) {
                return Result.FAIL();
            }
            entity.setAppid(null);
            entity.setSmallRoutineName(null);
            entity.setFileId(null);
            return list(entity);
        }
        boolean b = fileAppidService.updateById(entity);
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
        boolean b = fileAppidService.doRemoveeIds(arr);
        if (!b) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }


}
