
package com.cqmrjb.system.service;

import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.entity.UserInfo;

import java.util.List;

/**
*
*@ClassName:用户信息表 服务类
*@Description:
*@author: zhou
*@date 2020-10-28
*
*/
public interface IUserInfoService extends BaseService<UserInfo> {

    String login(UserInfo entity);

    UserInfo getUserByUserName(String phone);

    List<UserInfo> listUserInfo(String phone, String role);
}
