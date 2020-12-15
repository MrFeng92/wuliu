package com.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController
{
    @RequestMapping("/{pageName}")
    public String goPage(@PathVariable String pageName)
    {
        return "/home/" + pageName;
    }

    /**
     * 定位系统管理页面
     *
     * @param pageName
     * @return
     */
    @RequestMapping("/sysadmin/{pageName}")
    public String geSystemPage(@PathVariable String pageName)
    {
        return "/sysadmin/" + pageName;
    }

    @RequestMapping("/home/{pageName}")
    public String geHomePage(@PathVariable String pageName)
    {
        return "/home/" + pageName;
    }
}