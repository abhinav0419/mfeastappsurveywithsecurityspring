package com.mobiquity.snack.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mobiquity.snack.constants.RoleConstant;
import com.mobiquity.snack.model.AppUser;
import com.mobiquity.snack.model.SurveyEntity;
import com.mobiquity.snack.model.UserEntity;
import com.mobiquity.snack.service.UserService;

@Controller
public class LoginController {
    
    private static final String ERROR_MESSAGE = "Invalid user name or password entered";

    @Autowired private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getForm(HttpServletRequest  request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");  
        if (ipAddress == null) {  
            ipAddress = request.getRemoteAddr();  
            System.out.println(" ==========================================="+ipAddress);
        }
        UserEntity userEntity = new UserEntity();
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("userEntity", userEntity);

        return modelAndView;
    }
    
    @RequestMapping(value = "/loginerror", method = RequestMethod.GET)
    public ModelAndView loginErrorHandling() {
        
        UserEntity userEntity = new UserEntity();
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("userEntity", userEntity);
        modelAndView.addObject("errorMessage",ERROR_MESSAGE);

        return modelAndView;
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public ModelAndView getIndex(
            @ModelAttribute("userEntity") UserEntity userEntity,
            HttpSession session) {
	

        AppUser appUser = (AppUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity entity = userService.getUserById(appUser.getUserId());
        
        session.setAttribute("appUserRole", entity.getUserRole().getRoleName());
        session.setAttribute("userId",entity.getUserId());
       System.out.println("first name is " + entity.getFirstName());
        session.setAttribute("userName",entity.getFirstName());
        
        ModelAndView modelAndView = null;
        
        
        if (hasRole(RoleConstant.ROLE_ADMIN)) {
            modelAndView = new ModelAndView("adminheader");
        } else {
            modelAndView = new ModelAndView("userheader");
        }
        
        return modelAndView;

    }

    @RequestMapping("/createfeast")
    public ModelAndView createSurvey(Map<String, Object> map) {

        ModelAndView modelAndView = new ModelAndView("createsurvey");
        SurveyEntity surveyEntity = new SurveyEntity();
        modelAndView.addObject("surveyEntity", surveyEntity);

        return modelAndView;
    }
    
    private boolean hasRole(String roleName) {
        
        for (GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
            String userRole = authority.getAuthority();
           
                if (roleName.equals(userRole)) {
                   return true;
                    }
                }

        return false;
    }

}
