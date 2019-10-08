package com.redcatt.controller;

import com.redcatt.pojo.User;
import com.redcatt.service.sercice.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Resource
    LoginService loginService;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "userName") String account,
                        @RequestParam(value = "passWord") String passWord,
                        HttpSession session, Model model) {
        User user = loginService.getUserByAccount(account);
        if (user != null && user.getPassWord().equals(passWord)) {
            session.setAttribute("user", user.getUserName());
            return "main";
        }
        model.addAttribute("msg", "账号或者密码错误！");
        return "login";
    }

    @RequestMapping("/")
    public String index() {
        return "login";
    }
}
