

package com.cqmrjb.common.utils;

import java.util.UUID;


/**
 * @ClassName: UUIDUtil
 * @Description: <p> (UUIDUtil快速生成)</p>
 * @author：furao
 * @date: 2020/4/27 19:26
 * ${tags}$
 */
public class UUIDUtil {

    public static String getUuid(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
    
}
