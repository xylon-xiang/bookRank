package com.xylon.book.controller;

import com.xylon.book.model.User;
import com.xylon.book.service.LoginService;
import com.xylon.book.service.LogonService;
import com.xylon.book.service.SearchService;
import com.xylon.book.service.UserService;
import com.xylon.book.util.GenerateUserId;
import com.xylon.book.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class LogController {

    @Autowired
    LoginService loginService;

    @Autowired
    LogonService logonService;

    @Autowired
    UserService userService;

    JsonUtil jsonUtil = new JsonUtil();

    GenerateUserId generateUserId = new GenerateUserId();


    @PostMapping("/logon")
    public String Logon(@RequestParam("user")User user){

        if (logonService.CheckInvitationCode(user)){
            user.setUserId(generateUserId.GenerateUID());
            logonService.AddUser(user);
            return "Success!";
        }
        else
            return "Fail!";
    }


    @PostMapping("/login")
    public String Login(@RequestParam("user") User user){
        if (loginService.CheckUser(user)){
            return "Success";
        }
        else return "failure!";

    }

    @GetMapping("/user")
    public String GetUserInfo(@RequestParam("user_id")long userId){

        return jsonUtil.ClassIntoJson(userService.GetUserInfo(userId));
    }

    @PostMapping("/userChange")
    public String UpdateUserInfo(@RequestParam("user")User user){

        userService.UpdateUserInformation(user);

        return "Success!";
    }


}
