package com.cqmrjb.system.mapper;

import com.cqmrjb.system.entity.ServiceTypeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:服务类型 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2020-11-03
 *
 */
 @Mapper
 @Repository
public interface ServiceTypeInfoMapper extends BaseMapper<ServiceTypeInfo> {

 /**
 * @Title: 物理批量删除
 * @Description: <p></p>
 * @author: zhou
 * @date: 2020-11-03
 * @param: int []arr = new int []{,}
 * @return: boolean
 * @throws
 */
 public boolean doRemoveeIds(long[] arr);


}
