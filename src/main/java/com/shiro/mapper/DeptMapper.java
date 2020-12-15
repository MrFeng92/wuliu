package com.shiro.mapper;

import com.shiro.pojo.Dept;

import java.util.List;

public interface DeptMapper {
    List<Dept> findAllDept();
    //需要注意的是：方法名要和映射文件里对应id要一致
    void insert(Dept dept);

    Dept findDeptById(String deptId);

    void update(Dept dept);

    void deleteone(String deptId);

    void deleteBatch(String[] deptId);
}
