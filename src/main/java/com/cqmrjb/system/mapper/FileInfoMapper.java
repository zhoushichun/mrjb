package com.cqmrjb.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqmrjb.system.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:文件信息 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2020-10-29
 *
 */
 @Mapper
 @Repository
public interface FileInfoMapper extends BaseMapper<FileInfo> {

 /**
 * @Title: 物理批量删除
 * @Description: <p></p>
 * @author: zhou
 * @date: 2020-10-29
 * @param: int []arr = new int []{,}
 * @return: boolean
 * @throws
 */
  boolean doRemoveeIds(long[] arr);


}
