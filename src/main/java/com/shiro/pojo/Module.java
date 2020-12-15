package com.shiro.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Module extends BasePojo
{
    // module_id 对应的驼峰映射规则 moduleId
    // JsonProperty的作用就是在Jackson处理json数据时，根据注解里的字段来进行转换
    @JsonProperty("id")
    private String moduleId;// 权限表主键
    @JsonProperty("pId")
    private String parentId;// 父权限id
    private String name; // 权限名字
    private int ctype;// 权限类型，1,2,3,4 侧栏菜单，主菜单，按钮
    private int state;// 状态，1启用 0停用
    private int orderNo; // 排序号
    private String remark; // 备注

    // 这个属性是专门用来对应zTree回显得
    private String checked;

    public String getModuleId()
    {
        return moduleId;
    }

    public void setModuleId(String moduleId)
    {
        this.moduleId = moduleId;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getCtype()
    {
        return ctype;
    }

    public void setCtype(int ctype)
    {
        this.ctype = ctype;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public int getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(int orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getChecked()
    {
        return checked;
    }

    public void setChecked(String checked)
    {
        this.checked = checked;
    }
}
