package com.example.myspring.controller;

import com.example.myspring.CheckPermission;
import com.example.myspring.bean.User;
import com.example.myspring.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.awt.geom.PathIterator;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController{
    @Resource
    private UserMapper userMapper;
    private int from = 0;

    @GetMapping("/demo")
    @CheckPermission(per = "user:login")
    public String user(Model model) {
        model.addAttribute("list", userMapper.toAll(from));
        return "demo";               //返回到index页面
    }

    @GetMapping("/deno")
    @CheckPermission(per = "user:login")
    public String user1(Model model) {
        from += 5;
        model.addAttribute("list", userMapper.toAll(from));
        return "demo";               //返回到index页面
    }

    @GetMapping("/dem0")
    @CheckPermission(per = "user:login")
    public String user2(Model model) {
        if (from >= 5){
            from -= 5;
        }
        model.addAttribute("list", userMapper.toAll(from));
        return "demo";               //返回到index页面
    }
}
