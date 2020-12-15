package com.shiro.mapper;

import com.shiro.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper
{
    List<Role> findAllRole();

    void roleInsert(Role role);

    Role findRoleById(String roleId);

    void roleUpdate(Role role);

    void deleteRole(String roleId);

    List<String> findModuleIdsByRoleId(String roleId);

    void insertRoleModule(Map<String, String> map);
}
