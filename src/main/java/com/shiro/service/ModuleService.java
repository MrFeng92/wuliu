package com.shiro.service;

import com.shiro.mapper.ModuleMapper;
import com.shiro.pojo.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ModuleService
{
    @Autowired
    private ModuleMapper moduleMapper;

    public List<Module> findModuleBySelectProvider()
    {
        return moduleMapper.findAllModule();
    }

    public void insertByAnnotation(Module module)
    {
        module.setModuleId(UUID.randomUUID().toString());
        module.setCreateTime(new Date());
        module.setUpdateTime(module.getCreateTime());
        module.setState(1);// 设置默认状态值
        moduleMapper.insetByAnnotation(module);
    }

    public void deleteModule(String moduleId)
    {
        moduleMapper.deleteModule(moduleId);
    }

    public List<Module> findAllModule()
    {
        return moduleMapper.findAllModule();
    }
}
