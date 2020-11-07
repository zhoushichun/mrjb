package ${package.Controller};


import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import au.com.bus4u.common.result.RCode;
import au.com.bus4u.common.result.Result;
import au.com.bus4u.system.entity.${table.entityName};
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import au.com.bus4u.system.base.controller.BaseController;

/**
*
*@ClassName:${table.comment!} 前端控制器
*@Description:
*@author: ${author}
*@date ${date}
*
*/
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@Api(value="<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>",tags={"${table.comment!}信息"})
@Slf4j
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} extends BaseController{
</#if>

    /**
    * @Title: 查询信息
    * @Description: <p></p>
    *@author: ${author}
    *@date ${date}
    * @param:
    * @return:
    * @throws
    */
   // @OperationLog(operation = "查询${table.comment!}信息",content = "查询${table.comment!}信息")
    @ApiOperation(value = "查询信息", notes = "查询信息")
    @GetMapping("/list")
    public Result list(){
    List<${table.entityName}> list = ${table.entityName}Service.list(null);
    return Result.SUCCESS(list);
    }

    /**
    * @Title: 增加/修改
    *@author: ${author}
    *@date ${date}
    * @date: 2020/5/7 16:48
    * @param:
    * @return:
    * @throws
    */
    //@OperationLog(operation = "增加/修改${table.comment!}信息",content = "增加/修改${table.comment!}信息")
    @ApiOperation(value = "增加/修改", notes = "增加/修改")
    @PostMapping("/add")
    public Result add(@RequestBody ${table.entityName} entity){
    if (entity == null){
    return Result.FAIL();
    }
    if (entity.getId() == null){
    boolean b = entity.insert();
    if (!b){
    return Result.FAIL();
    }
    return Result.SUCCESS(RCode.SUCCESS);
    }
    boolean b = ${table.entityName}Service.updateById(entity);
    if (!b){
    return Result.FAIL();
    }
    return Result.SUCCESS(RCode.SUCCESS);
    }

    /**
    * @Title: 删除
    * @Description: <p>删除使用物理删除</p>
    *@author: ${author}
    *@date ${date}
    * @param:
    * @return:
    * @throws
    */
   // @OperationLog(operation = "物理删除${table.comment!}信息",content = "物理删除${table.comment!}信息")
    @ApiOperation(value = "物理删除", notes = "物理删除")
    @DeleteMapping("/delete")
    public Result delete(@RequestParam long[] arr){
        boolean b = ${table.entityName}Mapper.doRemoveeIds(arr);
        if (!b){
        return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }

    /**
    * @Title: 逻辑删除
    * @Description: <p>逻辑删除</p>
    *@author: ${author}
    *@date ${date}
    * @param:
    * @return:
    * @throws
    */
   // @OperationLog(operation = "逻辑删除${table.comment!}信息",content = "逻辑删除${table.comment!}信息")
    @ApiOperation(value = "逻辑删除", notes = "逻辑删除")
    @DeleteMapping("/deleteIds")
    public Result deleteIds(@RequestParam long[] ids){
        ArrayList<Long> objects = Lists.newArrayList();
        for (int i = 0; i< ids.length;i++){
        objects.add(ids[i]);
        }
        boolean b = ${table.entityName}Service.removeByIds(objects);
        if (!b){
        return Result.FAIL();
        }
        return Result.SUCCESS(RCode.SUCCESS);
    }

}
</#if>
