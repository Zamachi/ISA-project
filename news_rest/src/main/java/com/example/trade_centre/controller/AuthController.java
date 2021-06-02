package com.example.trade_centre.controller;

import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.UserModel;
import com.example.trade_centre.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("loginuser")
    @CrossOrigin(origins="*")
    private UserModel loginUser(@RequestBody  UserModel userModel){
        return  loginService.login(userModel);
    }

}
