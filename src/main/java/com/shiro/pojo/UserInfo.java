package com.shiro.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserInfo extends BasePojo
{
    private String userInfoId;// 用户信息表id，这个id值和use_p的id是一样的，值是一致的
    private String name;// 用户的真姓名
    private String cardNo;// 身份证号
    private String managerId;// 领导id(相当于部门的父部门，做自关联查询的时候要用的）
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinDate;// 入职时间
    private Double salary;// 薪资
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;// 生日
    private String gender;// 性别
    private String station;// 级别
    private String telephone;// 电话
    private String userLevel;// 用户级别
    private String remark;// 标注
    private String orderNo;// 排序号

    // 表示自关联查询的领导信息
    private UserInfo manager;

    public String getUserInfoId()
    {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId)
    {
        this.userInfoId = userInfoId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCardNo()
    {
        return cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getManagerId()
    {
        return managerId;
    }

    public void setManagerId(String managerId)
    {
        this.managerId = managerId;
    }

    public Date getJoinDate()
    {
        return joinDate;
    }

    public void setJoinDate(Date joinDate)
    {
        this.joinDate = joinDate;
    }

    public Double getSalary()
    {
        return salary;
    }

    public void setSalary(Double salary)
    {
        this.salary = salary;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getStation()
    {
        return station;
    }

    public void setStation(String station)
    {
        this.station = station;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getUserLevel()
    {
        return userLevel;
    }

    public void setUserLevel(String userLevel)
    {
        this.userLevel = userLevel;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public UserInfo getManager()
    {
        return manager;
    }

    public void setManager(UserInfo manager)
    {
        this.manager = manager;
    }
}
