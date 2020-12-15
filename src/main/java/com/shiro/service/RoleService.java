package com.shiro.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiro.mapper.ModuleMapper;
import com.shiro.mapper.RoleMapper;
import com.shiro.pojo.Module;
import com.shiro.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleService
{
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ModuleMapper moduleMapper;

    public List<Role> findAllRole()
    {
        return roleMapper.findAllRole();
    }

    public void roleInsert(Role role)
    {
        role.setRoleId(UUID.randomUUID().toString());
        role.setCreateTime(new Date());
        role.setUpdateTime(role.getCreateTime());
        roleMapper.roleInsert(role);
    }

    public Role findRoleById(String roleId)
    {
        return roleMapper.findRoleById(roleId);
    }

    public void roleUpdate(Role role)
    {
        roleMapper.roleUpdate(role);
    }

    public void deleteRole(String roleId)
    {
        roleMapper.deleteRole(roleId);
    }

    /*
     * 利用Jackson工具来组织json格式数据 Jackson需要引入相关的依赖jar包， pom.xml坐标： <dependency>
     * <groupId>com.fasterxml.jackson.core</groupId>
     * <artifactId>jackson-databind</artifactId>
     * <version>${jackson.version}</version> </dependency> 实现思路：
     * 1.查出所有的权限集合，所以需要注入ModuleMapper 2.调用Jackson工具，把集合转换成对应json数据
     */
    public String getJson(String roleId)
    {
        // 当前角色拥有的所有的权限id的集合
        // 对应的sql语句是去role_module_p中间表去查
        List<String> moduleIdsListOfCurrentRole = roleMapper.findModuleIdsByRoleId(roleId);

        List<Module> moduleList = moduleMapper.findAllModule();

        for (Module m : moduleList)
        {
            if (moduleIdsListOfCurrentRole.contains(m.getModuleId()))
            {
                m.setChecked("true");
            }
            else
            {
                m.setChecked("false");
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            // writeValueAsString可以把一个对象集合或单个对象转换成json串
            // 一定要记住这个OjectMapper和writeValueAsString这个方法
            String json = mapper.writeValueAsString(moduleList);
            return json;
        } catch (JsonProcessingException e)
        {

            e.printStackTrace();
        }
        return null;
    }

    /*
     * 这个方法是通过循环多次执行sql语句，来实现多条数据插入，这是一种比较常用的开发手段
     */
    public void insertRoleModule(String[] moduleIds, String roleId)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("roleId", roleId);
        for (String moduleId : moduleIds)
        {
            map.put("moduleId", moduleId);
            // 注意，不要把方法写在别的映射文件
            roleMapper.insertRoleModule(map);
        }

    }
}
