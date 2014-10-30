package com.mobiquity.snack.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mobiquity.snack.model.UserEntity;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public ModelAndView logoutUser(HttpSession session, HttpServletResponse response) {

        session.removeAttribute("validatedUser");
        session.invalidate();
        ModelAndView modelAndView = new ModelAndView("login");
        UserEntity userEntity = new UserEntity();
        modelAndView.addObject("userEntity", userEntity);
        
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
        return modelAndView;
        
    }
}
