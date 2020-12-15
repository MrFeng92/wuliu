package com.shiro.service;

import com.shiro.mapper.DeptMapper;
import com.shiro.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DeptService
{
    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> findAllDept()
    {
        return deptMapper.findAllDept();
    }

    /*
     * 这个方法是用户部门新增
     * 需要设置：
     * 1.部门的主键值，利用uuid的生成策略
     * 2.部门创建时间和更新时间
     * 3.部门的状态，state=1，表示启用
     */
    public void insert(Dept dept)
    {
        dept.setDeptId(UUID.randomUUID().toString());
        dept.setCreateTime(new Date());
        dept.setUpdateTime(dept.getCreateTime());
        dept.setState(1);
        // 现在，部门对象，有如下的值：部门id,部门名称（通过页面已经传过来了），父部门id，创建时间
        // 更新时间，和状态
        deptMapper.insert(dept);
    }

    /*
     * 这个方法是根据主键来查找部门信息
     */
    public Dept findDeptById(String deptId)
    {

        return deptMapper.findDeptById(deptId);
    }

    /*
     * 这个方法是更新部门信息的
     */
    public void update(Dept dept)
    {
        dept.setUpdateTime(new Date());
        // 别忘了，设置部门的状态值
        dept.setState(1);
        deptMapper.update(dept);
    }

    public void deleteone(String deptId)
    {
        deptMapper.deleteone(deptId);
    }

    /*
     * 这个方法是批量删除部门id的，第一种实现思路，就是循环调用删除单个部门的方法
     * 第二种方式，就是利用Mybatis的动态标签来做批量删除
     */
    public void deleteBatch(String[] deptId)
    {
        deptMapper.deleteBatch(deptId);
    }
}
