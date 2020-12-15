package com.shiro.shiro;

import com.shiro.pojo.Module;
import com.shiro.pojo.User;
import com.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AuthRealm extends AuthorizingRealm
{
    @Autowired
    private UserService userService;

    /*
     * 这个方法是做用户授权管理的 重点掌握： 多对多关联查询
     *
     * @see
     * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
     * .shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        Subject subject = SecurityUtils.getSubject();
        // 从session里拿到当前用户的登录名
        String username = (String) subject.getSession(false).getAttribute("username");
        User user = userService.findModulesOfCurrentUser(username);
        // 得到当前用户的权限集合
        List<Module> moduleList = user.getModules();
        // 这个集合，就相当于提供给shiro授权管理的用户的资料
        List<String> infoList = new ArrayList<String>();
        // 循环，将用户的权限信息加到infoList里
        for (Module m : moduleList)
        {
            infoList.add(m.getName());
        }

        // 叫出授权管理员,这个类不要new错
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 把权限信息交给用户来管理
        info.addStringPermissions(infoList);
        return info;
    }

    /*
     * 做用户登录验证处理的
     *
     * @see
     * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.
     * apache.shiro.authc.AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        // 实现思路：
        // 1.token里拿到当前用户输入的用户名
        // 2.根据用户名，去数据库查找对应的用户
        // 3.找到shiro的登录验证员，把user对象，user的真实密码交给验证员，验证会会自动把用户的真实密码和
        // 用户的真实密码做比对的
        UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
        String loginUsername = loginToken.getUsername();// 拿到用户输入的登录名
        User user = userService.findUserByUsername(loginUsername);
        // 把user对象、user对象的真实密码、当前AuthRealm的名字传进去
        String name = this.getName();
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), name);
        return info;
    }

}
