package com.shiro.controller;

import com.shiro.pojo.Role;
import com.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RoleController
{
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/sysadmin/role/list")
    public String roleList(Model model)
    {
        List<Role> roleList = roleService.findAllRole();
        model.addAttribute("dataList", roleList);
        return "/sysadmin/role/jRoleList";
    }

    /**
     * 角色新增页面跳转
     *
     * @return
     */
    @RequestMapping("/sysadmin/role/tocreate")
    public String toCreate()
    {
        return "/sysadmin/role/jRoleCreate";
    }

    /**
     * 角色新增保存
     *
     * @param role
     * @return
     */
    @RequestMapping("/sysadmin/role/insert")
    public String roleInsert(Role role)
    {
        roleService.roleInsert(role);
        return "forward:/sysadmin/role/list";
    }

    /**
     * 角色更新
     *
     * @param roleId
     * @param model
     * @return
     */
    @RequestMapping("/sysadmin/role/toupdate")
    public String toUpdate(String roleId, Model model)
    {
        Role role = roleService.findRoleById(roleId);
        model.addAttribute(role);
        return "/sysadmin/role/jRoleUpdate";
    }

    /**
     * 角色更新保存
     *
     * @param role
     * @return
     */
    @RequestMapping("/sysadmin/role/roleAction_update")
    public String roleUpdate(Role role)
    {
        roleService.roleUpdate(role);
        return "forward:/sysadmin/role/list";
    }

    /**
     * 角色删除
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/sysadmin/role/delete")
    public String delete(String roleId)
    {
        roleService.deleteRole(roleId);
        return "forward:/sysadmin/role/list";
    }

    /**
     * 角色权限模块
     *
     * @param model
     * @param roleId
     * @return
     */
    @RequestMapping("/sysadmin/role/tomodule")
    public String roleModule(Model model, String roleId)
    {
        String json = roleService.getJson(roleId);
        System.out.println(json);
        model.addAttribute("zTreeJson", json);
        model.addAttribute("roleId", roleId);
        return "/sysadmin/role/jRoleModule";
    }

    /*
     * 这个方法是为选中的角色分配权限， 对应的请求路径：/sysadmin/role/module
     *
     */
    @RequestMapping("/sysadmin/role/module")
    public String roleModuleInsert(String[] moduleIds, String roleId)
    {
        roleService.insertRoleModule(moduleIds, roleId);
        return "forward:/sysadmin/role/list";
    }
}
