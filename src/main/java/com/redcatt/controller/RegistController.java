package com.redcatt.controller;

import com.redcatt.pojo.User;
import com.redcatt.service.sercice.LoginService;
import com.redcatt.service.sercice.RegistService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class RegistController {

    @Resource
    LoginService loginService;
    @Resource
    RegistService registService;

    @RequestMapping("regist")
    public String regist(@RequestParam("userName") String userName,
                         @RequestParam("passWord") String passWord, Model model) {
        User user = loginService.getUserByAccount(userName);
        if (null == user) {
            registService.addUser(userName, passWord);
            model.addAttribute("msg", "注册成功，请登录!");
            return "login";
        }
        model.addAttribute("msg", "用户名已经存在!");
        return "regist";
    }
}
