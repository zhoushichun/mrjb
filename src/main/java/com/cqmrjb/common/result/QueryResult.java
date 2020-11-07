/**
 * Project: com.jcfx.gradeAll.teaching.common.jwt.common.response
 * Title: QueryResult
 * @(#)QueryResult.java
 * Package com.jcfx.gradeAll.teaching.common.jwt.common.response
 * CreatedDate: 2020/4/28 14:33
 * Description:
 * version V1.0
 * Copyright (c)  JCFX Co., Ltd.
 *
 * This software is the confidential and proprietary information of
 * JCFX Co., Ltd. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with
 * JCFX Co., Ltd.
*/
package com.cqmrjb.common.result;

import java.util.List;


/**
 * @ClassName: QueryResult
 * @Description: <p> (查询结果)</p>
 * @author：furao
 * @date: 2020/4/28 14:33
 * ${tags}$
 */
public class QueryResult<T> {
    //数据列表
    private List<T> list;

    //数据总数
    private long total;

    public QueryResult(List<T> list, long total) {
        this.list = list;
        this.total = total;
    }

    public QueryResult() {}

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
