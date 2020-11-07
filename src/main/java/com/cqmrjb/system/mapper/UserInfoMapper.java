package com.cqmrjb.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqmrjb.system.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *@ClassName:用户信息表 Mapper 接口
 *@Description:
 *@author: zhou
 *@date 2020-10-28
 *
 */
 @Mapper
 @Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {



}
