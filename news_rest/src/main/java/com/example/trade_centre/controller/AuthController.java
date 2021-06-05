package com.example.trade_centre.controller;

import com.example.trade_centre.model.UserModel;
import com.example.trade_centre.service.AuthenticationService;
import com.example.trade_centre.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("loginuser")
    @CrossOrigin(origins="*")
    private UserModel loginUser(@RequestBody  UserModel userModel){
        return  userService.login(userModel);
    }

}
