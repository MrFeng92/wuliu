package com.shiro.pojo;

import java.util.List;

public class User extends BasePojo
{
    private String userId;// 登录用户id
    private String deptId;// 所属部门id
    // 如果没有_ ，就不要大写，比如username
    private String username;// 登录名
    private String password;// 密码
    private int state;// 状态
    // 表示一个用户只属于一个部门
    private Dept dept;
    // 一个用户只有一个用户信息
    private UserInfo userInfo;
    // 配置用户和权限的多对多关系
    private List<Module> modules;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getDeptId()
    {
        return deptId;
    }

    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public Dept getDept()
    {
        return dept;
    }

    public void setDept(Dept dept)
    {
        this.dept = dept;
    }

    public UserInfo getUserInfo()
    {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }

    public List<Module> getModules()
    {
        return modules;
    }

    public void setModules(List<Module> modules)
    {
        this.modules = modules;
    }
}
