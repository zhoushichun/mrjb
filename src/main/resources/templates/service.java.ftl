
package ${package.Service};

import ${package.Entity}.${entity};
import au.com.bus4u.system.base.service.BaseService;
/**
*
*@ClassName:${table.comment!} 服务类
*@Description:
*@author: ${author}
*@date ${date}
*
*/
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends BaseService<${entity}> {

}
</#if>
