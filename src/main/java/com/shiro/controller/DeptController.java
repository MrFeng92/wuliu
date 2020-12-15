package com.shiro.controller;

import com.shiro.pojo.Dept;
import com.shiro.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DeptController
{
    @Autowired
    private DeptService deptService;

    /*
     * 部门查询，现根据前台页面要什么数据来确定
     * 所以：
     * 1.找到部门查询的列表页面 ，页面路径：WEB-INF/pages/sysadmin/dept/jDeptList
     * 2.通过Controller,定位部门列表页面
     * 3.找到部门列表页面的访问路径：/sysadmin/dept/list
     * 4.前台页面要的数据：deptId，父部门名称，本部门名称(detpName)，状态（state)
     */
    @RequestMapping("/sysadmin/dept/list")
    public String deptList(Model model)
    {
        // 组织部门数据，利用model传向前台页面
        List<Dept> dataList = deptService.findAllDept();
        model.addAttribute("dataList", dataList);

        return "/sysadmin/dept/jDeptList";
    }

    /*
     * 这个方法用来定位用户新增页面的，对应的后台请求路径：/sysadmin/dept/tocreate
     * 对应的页面路径：WEB-INF/pages/sysadmin/dept/jDeptCreate.jsp
     * 需要注意：
     * 前台页面需要父部门的列表信息，所以转向页面的时候，需要把数据传过去
     */
    @RequestMapping("/sysadmin/dept/tocreate")
    public String toCreate(Model model)
    {
        List<Dept> dataList = deptService.findAllDept();
        model.addAttribute("dataList", dataList);
        return "/sysadmin/dept/jDeptCreate";
    }

    /*
     * 这个方法是新增保存的方法，对应的后台请求路径是：/sysadmin/dept/insert
     */
    @RequestMapping("/sysadmin/dept/insert")
    public String insert(Dept dept)
    {
        deptService.insert(dept);
        // 新增完后，转发到部门列表页面
        return "forward:/sysadmin/dept/list";
    }

    /*
     * 这个方法是用来转向更新页面的，对应的后台请求路径： /sysadmin/dept/toupdate
     * 对应的页面：WEB-INF/pages/sysadmin/dept/jDeptUpdate.jsp
     * 需要向页面传的值：
     * 1.当前被选中的部门的名称。实现的方式，前台通过勾选check，来进行修改，同时也把对应的部门主键值也
     * 传过来了，所以我们可以根据主键值来查询对应的部门信息
     * 2.所有部门的信息集合
     */
    @RequestMapping("/sysadmin/dept/toupdate")
    public String toUpdate(String deptId, Model model)
    {
        Dept dept = deptService.findDeptById(deptId);
        List<Dept> dataList = deptService.findAllDept();
        model.addAttribute("deptInfo", dept);
        model.addAttribute("dataList", dataList);
        return "sysadmin/dept/jDeptUpdate";
    }

    /*
     * 这个方法是用来更新部门信息并保存的，对应的后台请求路径：/sysadmin/dept/update
     */
    @RequestMapping("/sysadmin/dept/update")
    public String update(Dept dept)
    {
        deptService.update(dept);
        return "forward:/sysadmin/dept/list";
    }

    /*
     * 这个方法是用来删除单个部门的的，对应的后台请求路径是：/sysadmin/dept/deleteone
     */
    @RequestMapping("/sysadmin/dept/deleteone")
    public String deleteone(String deptId)
    {
        deptService.deleteone(deptId);
        return "forward:/sysadmin/dept/list";
    }

    /*
     * 这个方法是用来删除多个部门的，对应的后台请求路径：/sysadmin/dept/delete
     * 需要掌握的是 String[]这种接参方式，数组内部用，来分割的
     */
    @RequestMapping("/sysadmin/dept/delete")
    public String deleteBatch(String[] deptId)
    {
        deptService.deleteBatch(deptId);
        return "forward:/sysadmin/dept/list";
    }
}
