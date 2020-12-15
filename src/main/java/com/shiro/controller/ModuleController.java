package com.shiro.controller;

import com.shiro.pojo.Module;
import com.shiro.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ModuleController
{
    @Autowired
    private ModuleService moduleService;

    /*
     * 这个方法是利用@SelectProvide实现表的查询
     */
    @RequestMapping("/sysadmin/module/list")
    public String moduleList(Model model)
    {
        List<Module> dataList = moduleService.findModuleBySelectProvider();
        model.addAttribute("dataList", dataList);
        return "/sysadmin/module/jModuleList";

    }

    @RequestMapping("/sysadmin/module/insert")
    public String moduleInsert(Module module)
    {
        moduleService.insertByAnnotation(module);
        return "forward:/sysadmin/module/list";

    }

    /*
     * 这个方法是删除模块（权限）的，对应的后台请求路径：/sysadmin/module/delete
     */
    @RequestMapping("/sysadmin/module/delete")
    public String moduleDelete(String moduleId)
    {
        moduleService.deleteModule(moduleId);
        return "forward:/sysadmin/module/list";
    }

    @RequestMapping("/sysadmin/module/tocreate")
    public String moduleCreate(Model model)
    {
        List<Module> dataList = moduleService.findAllModule();
        model.addAttribute("moduleList", dataList);
        return "/sysadmin/module/jModuleCreate";
    }
}
