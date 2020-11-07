
package com.cqmrjb.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqmrjb.system.base.service.impl.BaseServiceImpl;
import com.cqmrjb.system.entity.FileInfo;
import com.cqmrjb.system.mapper.FileInfoMapper;
import com.cqmrjb.system.service.IFileInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @ClassName:文件信息 服务实现类
 * @Description:
 * @author: zhou
 * @date 2020-10-29
 */
@Service
@Transactional
public class FileInfoServiceImpl extends BaseServiceImpl<FileInfoMapper, FileInfo> implements IFileInfoService {
    private String url;

    @Override
    public String addFile(MultipartFile[] files) {

        for (MultipartFile file : files) {
            //判断文件是否为空
            if (file.isEmpty()) {
                return "上传文件不能为空";
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            String[] split = fileName.split("\\.");
            System.out.println(split[1]);

            fileName = split[split.length - 1];
            System.out.print("上传的文件名为: " + fileName + "\n");
            fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "." + fileName;
            System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: " + fileName + "\n");
            //加个时间戳，尽量避免文件名称重复
            String path = "E:/fileUpload/" + fileName;
            //String path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
            //文件绝对路径
            System.out.print("保存文件绝对路径" + path + "\n");
            //创建文件路径
            java.io.File dest = new java.io.File(path);
            //判断文件是否已经存在
            if (dest.exists()) {
                return "文件已经存在";
            }
            //判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            try {
                //上传文件
                file.transferTo(dest); //保存文件
                System.out.print("保存文件路径" + path + "\n");
                //url="http://你自己的域名/项目名/images/"+fileName;//正式项目
                url = "/fileUpload/" + fileName;//本地运行项目
                FileInfo f = new FileInfo();
                f.setFileName(fileName);
                f.setPath(path);
                f.setUrl(url);
                baseMapper.insert(f);
                System.out.print("保存的完整url====" + url + "\n");
                return "上传成功==" + url + "==" + path + "==" + fileName;
            } catch (IOException e) {
                return "上传失败";
            }
        }
        return "上传失败";
    }

    @Override
    public List<FileInfo> listFileInfo(String fileName) {

        QueryWrapper<FileInfo> wrapper = new QueryWrapper<>();
        if (fileName != null && fileName != "") {
            wrapper.like("file_name", fileName);
        }
        wrapper.eq("status", 0);
        wrapper.orderByDesc("update_date");
        return baseMapper.selectList(wrapper);
    }

    @Override
    public boolean doRemoveeIds(long[] arr) {
        return fileInfoMapper.doRemoveeIds(arr);
    }
}
