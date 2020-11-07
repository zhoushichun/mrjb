
package com.cqmrjb.system.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;


public interface BaseService<T> extends IService<T>   {



    /**
     * @Title: 分页查询
     * @Description: <p></p>
     * @author: zhoushichun
     * @date: 2020/4/28 15:28
     * @param: current 当前页数
     * @param: size 每页大小
     * @return:
     * @throws
     */
    IPage<T> getPageList(int current, int size);


}
