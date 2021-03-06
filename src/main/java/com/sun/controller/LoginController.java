package com.sun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class LoginController {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
        if(!StringUtils.isEmpty(username) && password.equals("123")){
            session.setAttribute("loginUser",username);
            return "dashboard";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }
}
