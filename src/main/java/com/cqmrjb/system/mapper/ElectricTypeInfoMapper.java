package com.cqmrjb.system.mapper;

import com.cqmrjb.system.entity.ElectricTypeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName:电器类型 Mapper 接口
 * @Description:
 * @author: zhou
 * @date 2020-11-03
 */
@Mapper
@Repository
public interface ElectricTypeInfoMapper extends BaseMapper<ElectricTypeInfo> {

    /**
     * @throws
     * @Title: 物理批量删除
     * @Description: <p></p>
     * @author: zhou
     * @date: 2020-11-03
     * @param: int []arr = new int []{,}
     * @return: boolean
     */
    boolean doRemoveeIds(long[] arr);


}
