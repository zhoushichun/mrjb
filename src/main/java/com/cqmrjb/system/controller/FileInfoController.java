package com.cqmrjb.system.controller;


import com.cqmrjb.common.result.RCode;
import com.cqmrjb.common.result.Result;
import com.cqmrjb.system.base.controller.BaseController;
import com.cqmrjb.system.entity.FileInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName:文件信息 前端控制器
 * @Description:
 * @author: zhou
 * @date 2020-10-29
 */
@RestController
@RequestMapping("/system/file-info")
@Api(value = "/system/file-info", tags = {"文件/图片信息"})
@Slf4j
public class FileInfoController extends BaseController {

    /**
     * @throws
     * @Title: 查询信息
     * @Description: <p></p>
     * @author: zhou
     * @date 2020-10-29
     * @param:
     * @return:
     */
    @ApiOperation(value = "分页查询文件信息", notes = "分页查询文件信息")
    @PostMapping("/list")
    public Result list(@RequestBody FileInfo entity) {
        if(entity.getCurrent()==0){
            entity.setCurrent(1);
        }
        if(entity.getSize()==0){
            entity.setSize(10);
        }
        PageHelper.startPage(entity.getCurrent(), entity.getSize());

        List<FileInfo> list = fileInfoService.listFileInfo(entity.getFileName());
        return Result.SUCCESS(new PageInfo<>(list));
    }

    @PostMapping("addFile")
    @ApiOperation(value = "图片上传", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result addFile(@RequestParam("fileNames") MultipartFile[] files) {
        String s = fileInfoService.addFile(files);
        if (s.contains("上传成功")) {
            String[] split = s.split("\\==");
            FileInfo f = new FileInfo();
            f.setFileName(split[3]);
            f.setPath(split[2]);
            f.setUrl(split[1]);

            return Result.SUCCESS(f);
        }
        return Result.FAIL(s);
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
    @ApiOperation(value = "添加/修改文件或图片", notes = "添加/修改文件或图片")
    @PostMapping("/add")
    public Result add(@RequestBody FileInfo entity) {
        if (entity == null) {
            return Result.FAIL();
        }
        if (entity.getId() == null) {
            boolean b = entity.insert();
            if (!b) {
                return Result.FAIL();
            }
            return Result.SUCCESS(RCode.SUCCESS);
        }
        boolean b = fileInfoService.updateById(entity);
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
        boolean b = fileInfoService.doRemoveeIds(arr);
        if (!b) {
            return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }


}
