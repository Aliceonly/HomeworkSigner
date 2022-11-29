package com.example.myspring.controller;

import com.example.myspring.CheckPermissionInterceptor;
import com.example.myspring.entity.UserBean;
import com.example.myspring.service.UserService;
import com.example.myspring.utils.MailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@Slf4j
@Controller
public class LoginController {

    //将Service注入Web层
    @Resource
    UserService userService;

    //实现登录
    @RequestMapping("/login")
    public String show(){
        return "login";
    }
    //实现登录
    @RequestMapping("/Elogin")
    public String showE(){
        return "Elogin";
    }

    @RequestMapping("/index")
    public String show1(){
        CheckPermissionInterceptor.delPermisstion("user:login");
        return "index";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password){
        UserBean userBean = userService.LoginIn(name, password);
        log.info("name:{}",name);
        log.info("password:{}",password);
        if(userBean!=null){
            CheckPermissionInterceptor.addPermisstion("user:login");
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping(value = "/GetVCode",method = RequestMethod.POST)
    public String GetVCode(String email){
        UserBean userBean = userService.EloginIn(email);
        if(userBean!=null){
            MailUtils.sendMail(email);
            return "coding";
        }else {
            return "error";
        }
    }

    @RequestMapping(value = "/ElogIn",method = RequestMethod.POST)
    public String Elogin(String code){
        if(code.equals(MailUtils.CODE)){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/signup")
    public String disp(){
        return "signup";
    }

    //实现注册功能
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String signUp(String name,String password,String email){
        UserBean userBean = userService.EloginIn(email);
        if(userBean==null){
            userBean = userService.LoginIn(name, password);
            if (userBean==null){
                MailUtils.sendMail(email);
                userService.Insert(name, password, email);
                return "coding";
            }else{
                return "error";
            }
        }else{
            return "error";
        }
    }

}