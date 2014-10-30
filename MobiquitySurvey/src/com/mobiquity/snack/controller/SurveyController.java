package com.mobiquity.snack.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mobiquity.snack.context.SpringApplicationContext;
import com.mobiquity.snack.model.AppUser;
import com.mobiquity.snack.model.SurveyEntity;
import com.mobiquity.snack.model.SurveyInfoEntity;
import com.mobiquity.snack.model.SurveyType;
import com.mobiquity.snack.model.UserEntity;
import com.mobiquity.snack.service.SurveyInfoService;
import com.mobiquity.snack.service.SurveyService;
import com.mobiquity.snack.service.UserService;

@Controller
public class SurveyController {
   
    @Autowired
    private SurveyService surveyService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private SurveyInfoService surveyInfoService;

    @RequestMapping(value = "/submitsurvey", method = RequestMethod.POST)
    public String getForm(@RequestParam("cancel") String cancel,
            @ModelAttribute("surveyEntity") SurveyEntity surveyEntity,HttpSession session,HttpServletRequest request) {
        if(!cancel.equalsIgnoreCase("cancel")){
        Long editId = (Long)session.getAttribute("editedId");
       
        if(editId != null){
            System.out.println("==============================================is edited id ???? " + editId);
            surveyEntity.setSurveyId(editId);
        }
        surveyEntity.setOpenSurveyFlag(true);
        surveyEntity.setCreatedDate(new Date());
        surveyEntity.setType(SurveyType.FEAST_POLL);
        
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        surveyEntity = surveyService.addUserToSurvey(appUser.getUserId(),surveyEntity);
       // session.setAttribute("surveyEntity", surveyEntity);
        request.setAttribute("showCreateSurvey", true);
        return "adminheader";
        }else{
            return "adminheader";
        }
       
    }
    @RequestMapping("/createfeed")
    public String createFeed(@RequestParam("cancel") String cancel,
            @ModelAttribute("surveyEntity") SurveyEntity surveyEntity,
            HttpSession session,HttpServletRequest request) {
        if(!cancel.equalsIgnoreCase("cancel")){
            
            Long editId = (Long)session.getAttribute("editedId");
            System.out.println("==============================================is cancel button ???? " + cancel);
            if(editId != null){
                surveyEntity.setSurveyId(editId);
            }
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.getUserById(appUser.getUserId());
        
        surveyEntity.setType(SurveyType.FEEDBACK);
        surveyEntity.setCreatedDate(new Date());
        surveyEntity.setJainOption("--");
        surveyEntity.setVegOption("--");
        surveyEntity.setOpenSurveyFlag(true);
        surveyService.addUserToSurvey(userEntity.getUserId(), surveyEntity);
        request.setAttribute("showCreateFeedback", true);
        return "adminheader";
        }else{
            return "adminheader";
        }
       
    }

    @RequestMapping(value = "/closesurvey")
    public String closeSurvey(HttpSession session,
            @RequestParam("saveId") long saveId,HttpServletRequest request) {
        
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.getUserById(appUser.getUserId());

        SurveyEntity surveyEntity =  surveyService.getSurveyById(saveId);
        if(surveyEntity != null){
            surveyService.closeCurrentSurvey(userEntity, surveyEntity);
        }
        List<SurveyEntity> currentSurvey = surveyService.getCurrentSurvey();
        List<SurveyEntity> openSurveyList = new ArrayList<SurveyEntity>();
        
        for (SurveyEntity entity : currentSurvey) {
            if (entity.isOpenSurveyFlag() == true && entity.getType() == SurveyType.FEAST_POLL) {
                openSurveyList.add(entity);
            }
        }
        session.setAttribute("openSurveyList", openSurveyList);

        

        return "snacksurvey";
    }

    @RequestMapping("/snacksurvey")
    public String snackSurvey(HttpSession session) {
        List<SurveyEntity> currentSurvey = surveyService.getCurrentSurvey();
        List<SurveyEntity> openSurveyList = new ArrayList<SurveyEntity>();
        
        for (SurveyEntity entity : currentSurvey) {
            if (entity.isOpenSurveyFlag() == true && entity.getType() == SurveyType.FEAST_POLL) {
                openSurveyList.add(entity);
            }
        }
        session.setAttribute("openSurveyList", openSurveyList);

       
        return "snacksurvey";
    }

    
    @RequestMapping("/createfeedback")
    public ModelAndView createFeedbackSurvey() {
        
        ModelAndView modelAndView = new ModelAndView("createfeedback");
        SurveyEntity surveyEntity = new SurveyEntity();
        modelAndView.addObject("surveyEntity", surveyEntity);
        
        return modelAndView;
    }

 

    @RequestMapping("/showfeedback")
    public String showAllFeedback(HttpSession session) {
        
        List<SurveyEntity> currentSurvey = surveyService.getCurrentSurvey();
        List<SurveyEntity> openFeedbackSurveyList = new ArrayList<SurveyEntity>();
        
        for (SurveyEntity entity : currentSurvey) {
            if (entity.isOpenSurveyFlag() == true
                    && entity.getType() == SurveyType.FEEDBACK) {
                openFeedbackSurveyList.add(entity);
            }
        }
        session.setAttribute("openFeedbackSurveyList", openFeedbackSurveyList);

        return "feedbacksurvey";
    }
    @RequestMapping(value = "/saveselection")
    public String saveSelection(HttpSession session, @RequestParam("saveId") long saveId,
            @RequestParam("selection") String selection, @RequestParam("cancel") String cancel
            ,HttpServletRequest request) {
        
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.getUserById(appUser.getUserId());
        SurveyEntity surveyEntity = surveyService.getSurveyById(saveId);
       
        SurveyInfoEntity surveyInfoEntity = surveyInfoService.getInfoByUserAndSurvey(userEntity, surveyEntity);
        if(surveyInfoEntity == null){
            surveyInfoEntity = new SurveyInfoEntity();
        }
       
        if(!cancel.equalsIgnoreCase("cancel")){
           
        surveyInfoEntity.setSurveyId(surveyEntity);
        surveyInfoEntity.setUserId(userEntity);
        surveyInfoEntity.setSurveyId(surveyService.getSurveyById(saveId));
        surveyInfoEntity.setCreatedDate(new Date());
        surveyInfoEntity.setSurveyOption(selection);
        
        surveyInfoService.saveSurveyInfo(
                surveyInfoEntity, userEntity.getUserId(),
                surveyEntity.getSurveyId());
        

        request.setAttribute("selection", selection);
        
        request.setAttribute("showFeastSelection", true);
        if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN"))
            return "adminheader";
        else
            return "userheader";
        }else{
        
        
        if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN"))
            return "adminheader";
        else
            return "userheader";
    }}

    @RequestMapping(value = "/savefeedbackselection", method = RequestMethod.POST)
    public String saveFeedbackSelection(HttpSession session,
            @RequestParam("saveId") long saveId,
            @RequestParam("suggestion") String suggestion,@RequestParam("cancel") String cancel,HttpServletRequest request) {
//        SurveyInfoEntity surveyInfoEntity = surveyInfoService.getSurveyInfoById(saveId);
//        AppUser appUser = (AppUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserEntity userEntity = userService.getUserById(appUser.getUserId());
//        
//        if(!cancel.equalsIgnoreCase("cancel")){
//        if (surveyInfoEntity == null) {
//            surveyInfoEntity = new SurveyInfoEntity();
//        }
//            surveyInfoEntity.setUserId(userEntity);
//        
//        surveyInfoEntity.setSurveyInfoId(saveId);
//        surveyInfoEntity.setCreatedDate(new Date());
//        surveyInfoEntity.setFeedback(suggestion);
//        
//        @SuppressWarnings("unchecked")
//        List<SurveyEntity> openFeedbackSurveyList = (List<SurveyEntity>) session
//                .getAttribute("openFeedbackSurveyList");
//       
//       
//
//        for (SurveyEntity surveyEntity : openFeedbackSurveyList) {
//            if (surveyEntity.getSurveyId() == saveId) {
//
//                System.out.println("========================================trying to save the survey info entity");
//                surveyInfoService.saveSurveyInfo(
//                        surveyInfoEntity, userEntity.getUserId(),
//                        surveyEntity.getSurveyId());
//                break;
//            }
//        }
//        request.setAttribute("showFeedSelection", true);
//        if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN"))
//            return "adminheader";
//        else
//            return "userheader";
//    }else{
//        if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN"))
//            return "adminheader";
//        else
//            return "userheader";}
//    }
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.getUserById(appUser.getUserId());
        SurveyEntity surveyEntity = surveyService.getSurveyById(saveId);
       
        SurveyInfoEntity surveyInfoEntity = surveyInfoService.getInfoByUserAndSurvey(userEntity, surveyEntity);
        if(surveyInfoEntity == null){
            surveyInfoEntity = new SurveyInfoEntity();
        }
       
        if(!cancel.equalsIgnoreCase("cancel")){
           
       // surveyInfoEntity.setSurveyId(surveyEntity);
        surveyInfoEntity.setUserId(userEntity);
        surveyInfoEntity.setSurveyId(surveyService.getSurveyById(saveId));
        surveyInfoEntity.setCreatedDate(new Date());
        surveyInfoEntity.setFeedback(suggestion);
       // surveyInfoEntity.setSurveyOption(selection);
        
        surveyInfoService.saveSurveyInfo(
                surveyInfoEntity, userEntity.getUserId(),
                surveyEntity.getSurveyId());
        

       // request.setAttribute("selection", selection);
        //request.setAttribute("showFeedSelection", true);
        request.setAttribute("showFeedSelection", true);
        if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN"))
            return "adminheader";
        else
            return "userheader";
        }else{
        
        
        if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN"))
            return "adminheader";
        else
            return "userheader";
    }}

    @RequestMapping(value = "/closefeedsurvey")
    public String closeFeedSurvey(HttpSession session,
            @RequestParam("saveId") long saveId) {

        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.getUserById(appUser.getUserId());

        SurveyEntity surveyEntity =  surveyService.getSurveyById(saveId);
        if(surveyEntity != null){
            surveyService.closeCurrentSurvey(userEntity, surveyEntity);
        }
        List<SurveyEntity> currentSurvey = surveyService.getCurrentSurvey();
        List<SurveyEntity> openFeedbackSurveyList = new ArrayList<SurveyEntity>();
        
        for (SurveyEntity entity : currentSurvey) {
            if (entity.isOpenSurveyFlag() == true && entity.getType() == SurveyType.FEEDBACK) {
                openFeedbackSurveyList.add(entity);
            }
        }
        session.setAttribute("openFeedbackSurveyList", openFeedbackSurveyList);
        return "feedbacksurvey";
    }
    
    @RequestMapping("/cancel")
    public String cancelRequest(){
        AppUser appUser = (AppUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.getUserByUserId(appUser.getUserId());
        
        if(userEntity.getUserRole().getRoleName().equals("ADMIN"))
            
        return "adminheader";
        else
            return "userheader";
    }

}
