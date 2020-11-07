
package com.cqmrjb.system.service;

import com.cqmrjb.system.base.service.BaseService;
import com.cqmrjb.system.entity.SmallRoutineContent;

import java.util.List;

/**
*
*@ClassName:小程序内容 服务类
*@Description:
*@author: zhou
*@date 2020-10-29
*
*/
public interface ISmallRoutineContentService extends BaseService<SmallRoutineContent> {

    SmallRoutineContent getSmallRoutineContentByTitle(String title);

    List<SmallRoutineContent> listRoutineContentInfo(String title, String content, String appid);

    boolean doRemoveeIds(long[] arr);
}
