package com.jixi.controller;

import com.jixi.pojo.Permission;
import com.jixi.pojo.Role;
import com.jixi.pojo.User;
import com.jixi.service.IPermissionService;
import com.jixi.service.IRoleService;
import com.jixi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by zhm on 2017/10/12.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IPermissionService permissionService;

    /**
     * 显示角色列表
     */
    @RequestMapping("/list")
    public String getRoleList(Model model){
        List<Role> roles=roleService.getRoleList();
        //补全角色的用户
        for(Role role:roles){
            String userNames="";
            if(userService.selectByRoleId(role.getId())==null){
                continue;
            }
            List<User> users=userService.selectByRoleId(role.getId());
            int i=0;
            for(User user:users){
              if(i==users.size()-1){
                  userNames+=user.getUsername();
              }else {
                  userNames+=user.getUsername()+",";
              }
              i++;
            }
            role.setUsers(userNames);
            roleService.updateRole(role);
        }
        model.addAttribute("roles",roles);
       return "role/list";
    }

    /**
     * 转到新增页面
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addRole(){
        return "role/add";
    }

    /**
     * 新增角色
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addRole(Role role,String permissions){
        roleService.addRole(role);
        //同时新增权限
        String[] pers=permissions.split(",");
        for(String s:pers){
            Permission permission=new Permission();
            permission.setFieldname(s);
            permission.setRoleid(role.getId());
            permissionService.addPermission(permission);
        }
        return "redirect:/role/list";
    }

    /**
     * 转到修改页面
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateRole(Model model,int id){
        model.addAttribute("role",roleService.selectOne(id));
        return "role/update";
    }

    /**
     * 修改角色
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateRole(Role role,String permissions){
        roleService.updateRole(role);
        //同时修改权限(删除原来的，添加现在的)
        permissionService.deleteByRoleId(role.getId());
        String[] pers=permissions.split(",");
        for(String s:pers){
            Permission permission=new Permission();
            permission.setFieldname(s);
            permission.setRoleid(role.getId());
            permissionService.addPermission(permission);
        }
        return "redirect:/role/list";
    }

    /**
     * 删除一个
     */
    @RequestMapping(value = "/deleteOne")
    public String deleteOneRole(int id){
        roleService.deleteOne(id);
        return "redirect:/role/list";
    }

    /**
     * 批量删除
     */
    @RequestMapping(value = "/delete")
    public String deleteRoles(String ids){
        String[] id = ids.split(",");
        roleService.deleteRoles(id);
        System.out.println(ids);
        return "redirect:/role/list";
    }
}
