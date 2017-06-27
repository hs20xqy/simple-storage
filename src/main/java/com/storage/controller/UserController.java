package com.storage.controller;

import com.storage.domain.User;
import com.storage.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView register(String userName, String email, String password, String rePassword) {
        ModelAndView view = new ModelAndView();
        if (!password.equals(rePassword)) {
            view.setViewName("/register");
            view.addObject("msg", "");
            view.addObject("email", email);
            view.addObject("userName", userName);
            return view;
        }
        User user = new User(userName, email, password);
        boolean result = userService.register(user);
        if (!result) {
            view.addObject("msg", "失败");
            view.addObject("email", email);
            view.addObject("userName", userName);
            view.setViewName("/register");
        }else {
            view.setViewName("/login");
            view.addObject("user", user);
            view.addObject("email", user.getEmail());
        }
        return view;
    }
}
