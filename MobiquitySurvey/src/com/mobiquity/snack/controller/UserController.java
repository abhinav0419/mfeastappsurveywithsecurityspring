package com.mobiquity.snack.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mobiquity.snack.model.AppUser;
import com.mobiquity.snack.model.ContactDetailEntity;
import com.mobiquity.snack.model.UserEntity;
import com.mobiquity.snack.service.ContactDetailService;
import com.mobiquity.snack.service.UserService;

@Controller
public class UserController {

    @Autowired private MessageDigestPasswordEncoder messageDigestPasswordEncoder;
    @Autowired private ContactDetailService contactDetailService;

    @Autowired private UserService userService;

    @RequestMapping("/userheader")
    public String getUserHeader() {

        return "userheader";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String uploadFileHandler(
           // @RequestParam("mobileNumber") Long mobileNumber,
           // @RequestParam("permenantAddress") String permenantAddress,
           // @RequestParam("temporaryAddress") String temporaryAddress,
           @RequestParam("can") String cancel,
          @Valid  @ModelAttribute("contactDetailEntity") ContactDetailEntity contactDetailEntity,
          BindingResult bindingResult,  HttpSession session, HttpServletRequest request) {
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.getUserById(appUser.getUserId());
        
        if (!cancel.equalsIgnoreCase("cancel")) {
            if (bindingResult.hasErrors()) {
                request.setAttribute("contactDetailNotUpdated", true);
               
                if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN")) {
                    return "adminheader";
                }
                else {
                    return "userheader";
                }
            } 
            ContactDetailEntity contactDetailEntity1 = contactDetailService.getContactByUserId(userEntity);
            if (contactDetailEntity1 != null) {
                contactDetailEntity.setContactId(contactDetailEntity1.getContactId());
            }
            contactDetailEntity.setMobileNumber(contactDetailEntity.getMobileNumber());
            contactDetailEntity.setPermenantAddress(contactDetailEntity.getPermenantAddress());
            contactDetailEntity.setTemporaryAddress(contactDetailEntity.getTemporaryAddress());
            contactDetailEntity.setUserId(userEntity);

            contactDetailService.addUserToContactDetail(userEntity,
                    contactDetailEntity);
            request.setAttribute("contactDetailUpdated", true);
            ContactDetailEntity validatedUserContactDetail = contactDetailService.getContactByUserId(userEntity);
            session.setAttribute("validatedUserContactDetail", validatedUserContactDetail);
            if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN")) {
                return "adminheader";
            }
            else {
                return "userheader";
            }
        } else {
            if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN")) {
                return "adminheader";
            }
            else {
                return "userheader";
            }
        }
    }

//    @RequestMapping(value = "/usereprofile")
//    public String fileUpload(Map<String, Object> map) {
//        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserEntity userEntity = userService.getUserById(appUser.getUserId());
//        
//        ContactDetailEntity contactDetailEntity =contactDetailService.getContactByUserId(userEntity);
//        if(contactDetailEntity == null){
//            contactDetailEntity = new ContactDetailEntity();
//        }
//        map.put("contactDetailEntity", contactDetailEntity);
//
//        return "user";
//    }

    @RequestMapping(value = "/showimg/{id}", method = RequestMethod.GET)
    public void showimg(@PathVariable("id") Integer id,
            HttpServletResponse response, HttpSession session,
            HttpServletRequest request) throws IOException, SQLException {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserEntity userEntity = userService.getUserByName(userDetails.getUsername());
        byte[] bytes = null;
        Blob blob = userService.getDisplayPic(userEntity.getUserId());

        if (blob != null) {
            bytes = blob.getBytes(1, (int) blob.length());
        }
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        if (bytes != null) {
            outputStream.write(bytes);
        }
    }

    @RequestMapping("/changepassword")
    public String ChangePassword(HttpSession session) {

        return "changepassword";
    }

    @RequestMapping("/userprofile")
    public ModelAndView userProfile(Map<String, Object> map, HttpSession session) {
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.getUserById(appUser.getUserId());
        
        ContactDetailEntity contactDetailEntity =contactDetailService.getContactByUserId(userEntity);
        if(contactDetailEntity == null){
            contactDetailEntity = new ContactDetailEntity();
        }
        ModelAndView modelAndView = new ModelAndView("userprofile");
        modelAndView.addObject("contactDetailEntity", contactDetailEntity);
       // ContactDetailEntity validatedUserContactDetail = contactDetailService.getContactByUserId(userEntity);
        //session.setAttribute("validatedUserContactDetail", validatedUserContactDetail);

        return modelAndView;
    }

    @RequestMapping(value = "/newpassword", method = RequestMethod.POST)
    public String changePassword(
            @RequestParam("oldPassword") String oldPassword,HttpServletRequest request ,
            @RequestParam("newPassword") String newPassword, HttpSession session, @RequestParam("cancel") String cancel) {

        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.getUserById(appUser.getUserId());
        String salt = userEntity.getSalt();
        String encPass = encodePassword(oldPassword, salt);
        if (!cancel.equalsIgnoreCase("cancel")) {
            if (encPass.equals(userEntity.getPassword())) {
                encPass = encodePassword(newPassword, salt);
                userEntity = userService.updateUserPassword(userEntity.getUserId(),
                        encPass);

            }
            request.setAttribute("showChangePassword", true);
            if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN")) {
                return "adminheader";
            }
            else {
                return "userheader";
            }
        } else {
            if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN")) {
                return "adminheader";
            }
            else {
                return "userheader";
            }
        }
    }

    @RequestMapping("/feedbacksurvey")
    public String feedback() {

        return "feedbacksurvey";
    }

    @RequestMapping("/uploadpic")
    public String uploadPic() {

        return "uploadpic";
    }

    private String encodePassword(String password, String salt) {

        String encPassword = messageDigestPasswordEncoder.encodePassword(password, salt);
        return encPassword;
    }

    @RequestMapping(value = "profilepic", method = RequestMethod.POST)
    public String profilepic(
            @RequestParam("displayPic") MultipartFile[] displayPic,
            HttpSession session, @RequestParam("cancel") String cancel,HttpServletRequest request) {
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.getUserById(appUser.getUserId());
        if (!cancel.equalsIgnoreCase("cancel")) {
            MultipartFile file = displayPic[0];

            byte[] bytes = null;
            try {
                bytes = file.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ContactDetailEntity contactDetailEntity = contactDetailService.getContactByUserId(userEntity);
            if (contactDetailEntity == null) {
                contactDetailEntity = new ContactDetailEntity();
            }

            contactDetailEntity.setUserId(userEntity);

            if (bytes != null && bytes.length > 0) {
                Blob blob = null;

                try {
                    blob = new SerialBlob(bytes);
                } catch (SerialException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                userEntity.setDisplayPic(blob);
            }

            contactDetailService.addUserToContactDetail(userEntity,
                    contactDetailEntity);
            request.setAttribute("picUploaded",true);
            if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN")) {
                return "adminheader";
            }
            else {
                return "userheader";
            }
        } else {
            if (userEntity.getUserRole().getRoleName().equalsIgnoreCase("ADMIN")) {
                return "adminheader";
            }
            else {
                return "userheader";
            }
        }

    }
}
