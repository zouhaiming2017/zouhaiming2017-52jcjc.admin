package com.jixi.controller;

import com.jixi.pojo.User;
import com.jixi.service.IRoleService;
import com.jixi.service.IUserService;
import com.jixi.utils.RandomValidateCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

/**
 * Created by zhm on 2017/9/21.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    /**
     * md5密码加密
     * @param str
     * @param salt
     * @return
     */
    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString() ;
    }

    /**
     * 登录页面生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证登录
     * @param model
     * @param userName
     * @param password
     * @param inputStr
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String userName, String password,String inputStr, HttpSession session) {
        //从session中获取随机数
        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
        User user=userService.selectByUserName(userName);

        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken token = new UsernamePasswordToken(userName,md5(password,"52jc"));
        try {
            if(random.equals(inputStr)){
                subject.login(token);
                model.addAttribute("user", user);
                return  "user/login" ;
            }else {
                model.addAttribute("error","验证码错误");
                return "redirect:/";
            }

        } catch (AuthenticationException e) {
            e.printStackTrace();
            model.addAttribute("error","用户名或密码错误");
            return "redirect:/";
        }
    }

    /**
     * 用户列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getUserList(Model model){
        List<User> users=userService.getUserList();
        //补全roleName
        for(User user:users){
            if(user==null||user.getRoleid()==null){
                continue;
            }
            user.setRolename(roleService.selectOne(user.getRoleid()).getRolename());
            userService.updateUser(user);
        }
        model.addAttribute("users",users);
        return "user/list";
    }


    /**
     * 跳转到新增页面
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addUser(Model model){
        model.addAttribute("roles",roleService.getRoleList());
        return "user/add";
    }

    /**
     * 新增用户
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addUser(User user){
        user.setPassword(md5(user.getPassword(),"52jc"));
        userService.addUser(user);
        return "redirect:/user/list";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateUser(Model model,int id){
        model.addAttribute("roles",roleService.getRoleList());
        model.addAttribute("user",userService.selectOne(id));
        return "user/update";
    }

    /**
     * 修改用户
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/user/list";
    }

    /**
     * 跳转到修改密码页面
     */
    @RequestMapping(value = "/updatePassword",method = RequestMethod.GET)
    public String updatePassword(Model model,int id){
        model.addAttribute("user",userService.selectOne(id));
        return "user/updatePassword";
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public String updatePassword(Model model,String oldpassword,String newpassword,int id){
        User user=userService.selectOne(id);
        if(!md5(oldpassword,"52jc").equals(user.getPassword())){
            model.addAttribute("user",userService.selectOne(id));
            model.addAttribute("err","密码错误！");
            return "user/updatePassword";
        }else {
            user.setPassword(md5(newpassword,"52jc"));
            userService.updateUser(user);
            return "redirect:/";
        }
    }

    /**
     * 删除单个用户
     */
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(int id){
        userService.deleteOne(id);
        return "redirect:/user/list";
    }


    /**
     * 批量删除用户
     */
    @RequestMapping(value = "/delete")
    public String deleteUser(String ids){
        String[] id = ids.split(",");
        userService.deleteUsers(id);
        return "redirect:/user/list";
    }
}

