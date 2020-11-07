package com.cqmrjb.system.mapper;

import com.cqmrjb.system.entity.FileAppid;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *@ClassName: Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2020-11-02
 *
 */
 @Mapper
 @Repository
public interface FileAppidMapper extends BaseMapper<FileAppid> {

 /**
 * @Title: 物理批量删除
 * @Description: <p></p>
 * @author: zhou
 * @date: 2020-11-02
 * @param: int []arr = new int []{,}
 * @return: boolean
 * @throws
 */
 boolean doRemoveeIds(long[] arr);


 List<FileAppid> listFileAppidInfo(@Param("appid") String appid, @Param("fileId")Long fileId, @Param("smallRoutineName") String smallRoutineName);
}
