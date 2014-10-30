package com.mobiquity.snack.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mobiquity.snack.model.ContactDetailEntity;
import com.mobiquity.snack.model.SurveyEntity;
import com.mobiquity.snack.model.SurveyInfoEntity;
import com.mobiquity.snack.model.SurveyInfoUi;
import com.mobiquity.snack.model.SurveyType;
import com.mobiquity.snack.model.UserEntity;
import com.mobiquity.snack.service.SurveyInfoService;
import com.mobiquity.snack.service.SurveyService;
import com.mobiquity.snack.service.UserService;

@Controller
public class AdminController {

    @Autowired private UserService userService;

    @Autowired private SurveyService surveyService;

    @Autowired private SurveyInfoService surveyInfoService;

    @RequestMapping("/adminhome")
    public String AdminHeader(Map<String, Object> map) {

        ContactDetailEntity contactDetailEntity = new ContactDetailEntity();
        map.put("contactDetailEntity", contactDetailEntity);

        return "adminheader";
    }

    @RequestMapping("/addemployee")
    public ModelAndView addEmployee() {

        ModelAndView modelAndView = new ModelAndView("addemployee");
        UserEntity userEntity = new UserEntity();
        modelAndView.addObject("userEntity", userEntity);

        return modelAndView;
    }

    @RequestMapping(value = "/newemployee", method = RequestMethod.POST)
    public String createNewEmployee(@RequestParam("cancel") String cancel,
            @Valid @ModelAttribute("userEntity") UserEntity userEntity, BindingResult bindingResult,
            @RequestParam("role") String role, HttpServletRequest request, @RequestParam("dob") String dob) {
        
            if (!cancel.equalsIgnoreCase("cancel")) {
                if (bindingResult.hasErrors()) {
                    request.setAttribute("clickOnAddEmployee", true);
                    List<ObjectError> errors = (List<ObjectError>)(bindingResult.getAllErrors());
                    for(ObjectError obj: errors){
                        System.out.println("--------------------------------------------");
                        System.out.println(obj.getDefaultMessage() + "  " );
                    }
                    return "adminheader";
                } 
                System.out.println("date value is --------------------------------------------: " + dob);
                Date dateOfBirth = dateFormatter(dob);
                userEntity.setBirthDate(dateOfBirth);
                userEntity.setActive(true);
                userService.saveUserWithRole(role, userEntity);
                userEntity = null;
                request.setAttribute("clickOnAddEmployee", true);
                request.setAttribute("addEmployeeSuccess", true);
                
                return "adminheader";
            }else{
                return "adminheader";
            }
            
        }
    

    @RequestMapping(value = "/createfeastpoll")
    public ModelAndView createFeastPoll(Map<String, Object> map) {

        ModelAndView modelAndView = new ModelAndView("createfeastpoll");

        SurveyEntity surveyEntity = new SurveyEntity();
        modelAndView.addObject("surveyEntity", surveyEntity);

        return modelAndView;
    }

    @RequestMapping("/surveyhistory")
    public ModelAndView showSurveyHistory() {
//        if(backButton.equalsIgnoreCase("goback")){
//            ModelAndView modelAndView = new ModelAndView("adminheader");
//            request.setAttribute("gobacktosnacksurvey", true);
//            return modelAndView;
//        }
        List<SurveyEntity> allSurveyList = surveyService.getCurrentSurvey();
        List<SurveyEntity> allFeastSurveyList = new ArrayList<SurveyEntity>();

        for (SurveyEntity surveyEntity : allSurveyList) {
            if (surveyEntity.getType() == SurveyType.FEAST_POLL) {
                allFeastSurveyList.add(surveyEntity);
            }
        }
        ModelAndView modelAndView = new ModelAndView("surveyhistory");
        modelAndView.addObject("allFeastSurveyList", allFeastSurveyList);

        return modelAndView;
    }

    @RequestMapping("/feedbackhistory")
    public ModelAndView showFeedbackHistory() {

        List<SurveyEntity> allSurveyList = surveyService.getCurrentSurvey();
        List<SurveyEntity> allFeedbackList = new ArrayList<SurveyEntity>();

        for (SurveyEntity surveyEntity : allSurveyList) {
            if (surveyEntity.getType() == SurveyType.FEEDBACK) {
                allFeedbackList.add(surveyEntity);
            }
        }
        ModelAndView modelAndView = new ModelAndView("feedbackhistory");
        modelAndView.addObject("allFeedbackList", allFeedbackList);

        return modelAndView;
    }

    @RequestMapping("/changesurveystatus")
    public ModelAndView changeSurveyStatus() {

        surveyService.changeSurveyStatus(1);
        ModelAndView modelAndView = new ModelAndView("surveyhistory");

        return modelAndView;

    }

    @RequestMapping("/editsurvey")
    public ModelAndView editCurrentSurvey(@RequestParam("surveyId") long surveyId, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("createfeastpoll");
        Long editedId = new Long(surveyId);
        SurveyEntity editSurvey = surveyService.getSurveyById(surveyId);
        modelAndView.addObject("surveyEntity", editSurvey);
        session.setAttribute("editedId", editedId);

        return modelAndView;

    }
    @RequestMapping("/editfeedbacksurvey")
    public ModelAndView editCurrentFeedbackSurvey(@RequestParam("surveyId") long surveyId, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("createfeedback");
        Long editedId = new Long(surveyId);
        SurveyEntity editSurvey = surveyService.getSurveyById(surveyId);
        modelAndView.addObject("surveyEntity", editSurvey);
        session.setAttribute("editedId", editedId);

        return modelAndView;

    }

    //    code merge ---------------------------------------------------------------------------------

    @RequestMapping("/surveyreport")
    public ModelAndView showSurveyReport(@RequestParam("surveyId") long surveyId) {

        List<SurveyInfoEntity> surveySelectionList = surveyInfoService.fecthSurverySelection(surveyId);
        List<SurveyInfoUi> surveyInfoUIList = new ArrayList<SurveyInfoUi>();
        int jain = 0;
        int veg = 0;
        int none = 0;

        for (SurveyInfoEntity surveyInfoEntity : surveySelectionList) {

            SurveyInfoUi surveyInfoUI = new SurveyInfoUi();
            
            surveyInfoUI.setSurveyName(surveyInfoEntity.getSurveyId().getSurveyName());
            surveyInfoUI.setFirstName(surveyInfoEntity.getUserId().getFirstName());
            surveyInfoUI.setLastName(surveyInfoEntity.getUserId().getLastName());
            surveyInfoUI.setSurveyOption(surveyInfoEntity.getSurveyOption());
            //surveyInfoEntity.setFeedback(surveyInfoEntity.getFeedback());
            if (surveyInfoUI.getSurveyOption().equalsIgnoreCase("jain")) {
                jain++;
            } else if (surveyInfoUI.getSurveyOption().equalsIgnoreCase("veg")) {
                veg++;
            }
            else {
                none++;
            }
            
            surveyInfoUIList.add(surveyInfoUI);
        }

        ModelAndView modelAndView = new ModelAndView("surveyreport");
        modelAndView.addObject("surveyInfoUIList", surveyInfoUIList);
        modelAndView.addObject("jainCount", jain);
        modelAndView.addObject("vegCount", veg);
        modelAndView.addObject("noneCount", none);

        return modelAndView;

    }

    @RequestMapping("/feedbackreport")
    public ModelAndView showFeedbackReport(@RequestParam("surveyId") long surveyId) {

        List<SurveyInfoEntity> surveySelectionList = surveyInfoService.fecthSurverySelection(surveyId);
        List<SurveyInfoUi> surveyInfoUIList = new ArrayList<SurveyInfoUi>();

        for (SurveyInfoEntity surveyInfoEntity : surveySelectionList) {

            SurveyInfoUi surveyInfoUI = new SurveyInfoUi();
            surveyInfoUI.setSurveyName(surveyInfoEntity.getSurveyId().getSurveyName());
            surveyInfoUI.setFirstName(surveyInfoEntity.getUserId().getFirstName());
            surveyInfoUI.setLastName(surveyInfoEntity.getUserId().getLastName());
            surveyInfoUI.setFeedback(surveyInfoEntity.getFeedback());
            //surveyInfoUI.setSurveyOption(surveyInfoEntity.getSurveyOption());

            surveyInfoUIList.add(surveyInfoUI);
        }

        ModelAndView modelAndView = new ModelAndView("feedbackreport");
        modelAndView.addObject("surveyInfoUIList", surveyInfoUIList);

        return modelAndView;

    }

    private Date dateFormatter(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date dob = null;
        try {
            dob = dateFormat.parse(date);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return dob;
    }
}
