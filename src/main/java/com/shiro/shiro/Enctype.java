package com.shiro.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Enctype
{
    public static void main(String[] args)
    {
        // 第一个参数：登录密码
        // 第二个参数：盐，盐不同，生成的密文就不同，一般把登录名当做盐
        // 第三个参数：加密次数，次数不同，生成的密文也不同，一般2~3次即可，太多影响性能
        Md5Hash md5 = new Md5Hash("123456", "chenchen", 3);
        System.out.println(md5.toString());
    }

    public static String md5(String loginPassword, String username, int i)
    {

        return new Md5Hash(loginPassword, username, i).toString();
    }

}
