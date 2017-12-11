package com.jixi.service.impl;

import com.jixi.mapper.RoleMapper;
import com.jixi.pojo.Role;
import com.jixi.pojo.RoleExample;
import com.jixi.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhm on 2017/10/12.
 */
@Service
public class RoleService implements IRoleService{
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 获得角色列表
     * @return
     */
    @Override
    public List<Role> getRoleList() {
        RoleExample example=new RoleExample();
        return roleMapper.selectByExample(example);
    }

    /**
     * 添加角色
     * @param role
     */
    @Override
    public void addRole(Role role) {
        roleMapper.insertSelective(role);
    }

    /**
     * 更新角色
     * @param role
     */
    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 删除一个
     * @param id
     */
    @Override
    public void deleteOne(int id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteRoles(String[] ids) {
        for(int i=0;i<ids.length;i++){
            roleMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
        }
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    @Override
    public Role selectOne(int id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
