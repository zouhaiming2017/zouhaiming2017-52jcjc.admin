package com.jixi.service;

import com.jixi.pojo.Permission;

import java.util.List;

/**
 * Created by zhm on 2017/10/12.
 */
public interface IPermissionService {
    List<Permission> getPermissionList();
    void addPermission(Permission permission);
    void updatePermission(Permission permission);
    void deleteOne(int id);
    void deletePermissions(String ids[]);
    void  deleteByRoleId(Integer roleid);
    Permission selectOne(int id);
}
