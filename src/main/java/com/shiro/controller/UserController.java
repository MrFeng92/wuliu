package com.shiro.controller;

import com.shiro.pojo.Dept;
import com.shiro.pojo.User;
import com.shiro.pojo.UserInfo;
import com.shiro.service.DeptService;
import com.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptServcie;

    /*
     * 这个方法是用来定位用户查询列表页面的，对应的后台请求路径： /sysadmin/user/list
     * 对应的前台页面：WEB-INF/pages/sysadmin/user/jUserList.jsp
     *
     */
    @RequestMapping("/sysadmin/user/list")
    public String userList(Model model)
    {
        List<User> dataList = userService.findAllUser();
        model.addAttribute("dataList", dataList);
        return "/sysadmin/user/jUserList";
    }

    /*
     * 这个方法是转向用户新增页面的，对应的后台请求路径是：/sysadmin/user/tocreate
     * 对应的页面路径：WEB-INF/pages/sysadmin/user/jUserCreate.jsp
     * 根据前台页面的取值结构，我们需要组织两组数据 1.所有部门信息 2.所有的用户的真实姓名
     */
    @RequestMapping("/sysadmin/user/tocreate")
    public String toCreate(Model model)
    {
        List<Dept> deptList = deptServcie.findAllDept();
        List<User> userList = userService.findAllUser();
        model.addAttribute("deptList", deptList);
        model.addAttribute("userList", userList);

        return "/sysadmin/user/jUserCreate";
    }

    /*
     * 这个方法是用来保存用户信息的，对应的后台请求路径：/sysadmin/user/insert 需要注意： 如果新增的参数信息过多：建议
     * 1.先用debug来调试，确定参数都能够准确接收上来之后，再写后面的方法 2.日期格式的转换问题，容易被忽略 3.作业：利用@initbinder
     * 实现日期格式的绑定
     */
    @RequestMapping("/sysadmin/user/insert")
    public String userInsert(User user, UserInfo userinfo)
    {
        userService.insert(user, userinfo);
        return "forward:/sysadmin/user/list";
    }

    /*
     * 对应的请求路径：/sysadmin/user/delete
     */
    @RequestMapping("/sysadmin/user/delete")
    public String userDelete(String userId)
    {
        userService.deleteUser(userId);
        return "forward:/sysadmin/user/list";
    }
}
