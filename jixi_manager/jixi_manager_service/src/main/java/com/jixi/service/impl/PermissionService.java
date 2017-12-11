package com.jixi.service.impl;

import com.jixi.mapper.PermissionMapper;
import com.jixi.pojo.Permission;
import com.jixi.pojo.PermissionExample;
import com.jixi.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhm on 2017/10/12.
 */
@Service
public class PermissionService implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 获得权限列表
     */
    @Override
    public List<Permission> getPermissionList() {
        PermissionExample example=new PermissionExample();

        return permissionMapper.selectByExample(example);
    }

    /**
     * 添加权限
     * @param permission
     */
    @Override
    public void addPermission(Permission permission) {
        permissionMapper.insertSelective(permission);
    }

    /**
     * 修改权限
     * @param permission
     */
    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    /**
     * 删除一个
     * @param id
     */
    @Override
    public void deleteOne(int id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deletePermissions(String[] ids) {
        for(int i=0;i<ids.length;i++){
            permissionMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    /**
     * 根据roleid删除权限
     * @param roleid
     */
    @Override
    public void deleteByRoleId(Integer roleid) {
        permissionMapper.deleteByRoleId(roleid);
    }

    /**
     * 查询一个
     * @param id
     * @return
     */
    @Override
    public Permission selectOne(int id) {
        return permissionMapper.selectByPrimaryKey(id);
    }
}
