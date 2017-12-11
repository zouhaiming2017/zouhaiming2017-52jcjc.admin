package com.jixi.controller;

import com.jixi.pojo.Permission;
import com.jixi.service.IPermissionService;
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
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    /**
     * 显示权限列表
     */
    @RequestMapping("/list")
    public String getPermissionList(Model model){
        List<Permission> permissions=permissionService.getPermissionList();
        model.addAttribute("permissions",permissions);
        return "permission/list";
    }

    /**
     * 转到新增页面
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addPermission(){
        return "permission/add";
    }

    /**
     * 新增角色
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addPermission(Permission permission){
        permissionService.addPermission(permission);
        return "redirect:/permission/list";
    }

    /**
     * 转到修改页面
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updatePermission(Model model,int id){
        model.addAttribute("permission",permissionService.selectOne(id));
        return "permission/update";
    }

    /**
     * 修改角色
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updatePermission(Permission permission){
        permissionService.updatePermission(permission);
        return "redirect:/permission/list";
    }

    /**
     * 删除一个
     */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(int id){
        permissionService.deleteOne(id);
        return "redirect:/permission/list";
    }

    /**
     * 批量删除
     */
    @RequestMapping(value = "/delete")
    public String delete(String ids){
        String[] id = ids.split(",");
        permissionService.deletePermissions(id);
        return "redirect:/permission/list";
    }
}
