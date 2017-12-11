package com.jixi.service;

import com.jixi.pojo.User;

import java.util.List;
import java.util.Set;

/**
 * Created by zhm on 2017/10/12.
 */
public interface IUserService {
    List<User> getUserList();
    long countByExample();
    void addUser(User user);
    void updateUser(User user);
    void deleteOne(int id);
    void deleteUsers(String ids[]);
    User selectOne(int id);
    User selectByUserName(String username);
    List<User> selectByRoleId(int roleid);
    Set<String> getRoleByUname(String username);
    Set<String> getPermissions(String username);
}
