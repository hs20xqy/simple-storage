package com.storage.controller;

import com.storage.domain.User;
import com.storage.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by hs on 2017/6/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/index");
        view.addObject("name", "watson");
        return view;
    }

    @RequestMapping("/registerView")
    public ModelAndView registerView() {
        ModelAndView view = new ModelAndView("/register");
        return view;
    }

    @RequestMapping("/login")
    public ModelAndView login(String email, String password) {
        ModelAndView view = new ModelAndView();
        User user = userService.login(email, password);
        if (user == null) {
            view.addObject("msg", "用户名密码错误!");
            view.addObject("email", email);
            view.setViewName("/index");
        }else {
            view.setViewName("/home");
            view.addObject("user", user);
        }
        return view;
    }

    @RequestMapping("/register")
    public ModelAndView register(User user, String rePassword, String remember) {
        ModelAndView view = new ModelAndView();
        if (!user.getPassword().equals(rePassword)) {
            view.setViewName("/register");
            view.addObject("msg", "两次密码不相同");
            view.addObject("email", user.getEmail());
            view.addObject("userName", user.getUserName());
            return view;
        }
        boolean result = userService.register(user);
        if (!result) {
            view.addObject("msg", "注册失败");
            view.addObject("email", user.getEmail());
            view.addObject("userName", user.getUserName());
            view.setViewName("/register");
        }else {
            view.setViewName("/index");
            view.addObject("user", user);
            view.addObject("email", user.getEmail());
        }
        return view;
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public String checkEmail(String email, HttpServletResponse response) {
        if (userService.checkEmailExist(email)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return "success";
    }
}
