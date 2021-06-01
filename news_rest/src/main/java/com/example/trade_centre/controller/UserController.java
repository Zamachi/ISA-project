package com.example.trade_centre.controller;

import com.example.trade_centre.entity.Item;
import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.UserModel;
import com.example.trade_centre.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("createaccount")
    @CrossOrigin(origins = "*")
    private User createAccount(@RequestBody  UserModel entity){
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        return userService.insert(entity);
    }

    @GetMapping("finduserbyusername")
    private User findUserByUsername(String username){
        return userService.findByUsername(username);
    }

}
