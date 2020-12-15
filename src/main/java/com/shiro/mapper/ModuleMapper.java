package com.shiro.mapper;

import com.shiro.pojo.Module;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface ModuleMapper
{
    List<Module> findAllModule();

    /*
     * 这个方法是用@SelectProvider实现查询,type指定对应类，method，指定对应类里的对应方法 注意方法返回的是一sql语句。
     */
//    @SelectProvider(type = ModuleMapperProvider.class, method = "select")
//    List<Module> findModuleBySelectProvider();

    @Insert("insert into module_p (module_id,parent_id,name,ctype,create_time,update_time,state)values(#{moduleId},#{parentId},#{name},#{ctype},#{createTime},#{updateTime},#{state})")
    void insetByAnnotation(Module module);

    @Delete("delete from module_p where module_id=#{moduleId}")
    void deleteModule(String moduleId);
}
