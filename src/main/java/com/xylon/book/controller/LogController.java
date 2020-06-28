package com.xylon.book.controller;

import com.xylon.book.service.LoginService;
import com.xylon.book.service.LogonService;
import com.xylon.book.util.LogStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LogController {

    @Autowired
    LoginService loginService;

    @Autowired
    LogonService logonService;


    @PostMapping("/logon")
    public void Logon(){


    }


    @PostMapping("/login")
    public void Login(){

    }

    @GetMapping("/user")
    public String GetUserInfo(){

        return "";
    }


}
