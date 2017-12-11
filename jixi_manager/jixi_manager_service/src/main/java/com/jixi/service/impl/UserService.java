package com.jixi.service.impl;

import com.jixi.mapper.UserMapper;
import com.jixi.pojo.User;
import com.jixi.pojo.UserExample;
import com.jixi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by zhm on 2017/10/12.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 获得用户列表
     */
    @Override
    public List<User> getUserList() {
        UserExample example=new UserExample();
        return userMapper.selectByExample(example);
    }

    /**
     * 统计用户数量
     * @return
     */
    @Override
    public long countByExample() {
        UserExample example=new UserExample();
        return userMapper.countByExample(example);
    }

    /**
     * 新增用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    /**
     * 修改用户
     * @param user
     */
    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 删除一个
     * @param id
     */
    @Override
    public void deleteOne(int id) {
        userMapper.deleteByPrimaryKey(id);
    }


    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteUsers(String[] ids) {
        for (int i=0;i<ids.length;i++){
            userMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    /**
     * 查找一个
     * @param id
     * @return
     */
    @Override
    public User selectOne(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过用户名查用户信息
     */
    @Override
    public User selectByUserName(String username) {
        return userMapper.selectByUserName(username);
    }

    /**
     * 通过roleid查用户信息
     * @param roleid
     * @return
     */
    @Override
    public List<User> selectByRoleId(int roleid) {
        return userMapper.selectByRoleId(roleid);
    }

    /**
     * 通过用户名获得该用户角色
     * @param username
     * @return
     */
    @Override
    public Set<String> getRoleByUname(String username) {
        return userMapper.getRoleByUname(username);
    }

    /**
     * 通过用户名获得该用户权限
     * @param username
     * @return
     */
    @Override
    public Set<String> getPermissions(String username) {
        return userMapper.getPermissions(username);
    }
}
