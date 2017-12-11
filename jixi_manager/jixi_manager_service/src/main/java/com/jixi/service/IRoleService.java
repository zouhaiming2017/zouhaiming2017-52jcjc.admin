package com.jixi.service;

import com.jixi.pojo.Role;

import java.util.List;

/**
 * Created by zhm on 2017/10/12.
 */
public interface IRoleService {
    List<Role> getRoleList();
    void addRole(Role role);
    void updateRole(Role role);
    void deleteOne(int id);
    void deleteRoles(String ids[]);
    Role selectOne(int id);
}
