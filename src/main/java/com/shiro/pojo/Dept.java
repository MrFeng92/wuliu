package com.shiro.pojo;

public class Dept extends BasePojo
{
    private String deptId;//部门的主键id
    private String parentId;//父部门的主键
    private String deptName;//部门名称
    private int orderNo;//排序号
    private int state;//部门状态，0表示停用，1表示启用

    //表示和父部门的自关联关系
    private Dept parentDept;

    public String getDeptId()
    {
        return deptId;
    }

    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public int getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(int orderNo)
    {
        this.orderNo = orderNo;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }


    public Dept getParentDept()
    {
        return parentDept;
    }

    public void setParentDept(Dept parentDept)
    {
        this.parentDept = parentDept;
    }
}
