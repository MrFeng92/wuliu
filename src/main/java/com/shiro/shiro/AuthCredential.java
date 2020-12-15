package com.shiro.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class AuthCredential extends SimpleCredentialsMatcher
{
    /*
     * 方法里两个形参 1.token 登录令牌，存的是当前用户的登录名和登录名
     * 我们的目的，就是从token里，拿到当前的登录密码=>把这个登录密码做MD5Hash加密 2.info
     * 存放的是user对象，以及user的真实密码，这个info我们不做处理
     *
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info)
    {
        UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
        // 得到用户输入的登录密码,得到的密码是char[]数组，如果想做代码处理的话，需要先转换成String
        String loginPassword = String.valueOf(loginToken.getPassword());
        String username = loginToken.getUsername();
        // 对登录密码做加密处理
        String enctypePassword = Enctype.md5(loginPassword, username, 3);
        // 这一步相当于从token先拿出未加密的登录密码，加密完之后放回去，再交给shiro做密码的校验
        // setPassword，要的char[]数组，所以需要做String=>Char[]的转换
        loginToken.setPassword(enctypePassword.toCharArray());

        // 注意：这个方法，返回时，返回的是LoingToken,因为loginToken里存的是加密的登录密码
        return super.doCredentialsMatch(loginToken, info);
    }

}
