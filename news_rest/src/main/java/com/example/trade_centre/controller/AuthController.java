package com.example.trade_centre.controller;

import com.example.trade_centre.config.JWT.JWTTokenUtil;
import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.UserModel;
import com.example.trade_centre.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtil jwtTokenUtill;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("loginuser")
    @CrossOrigin(origins="*")
    private ResponseEntity<UserModel> loginUser(@RequestBody  UserModel userModel){

        try{
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userModel.getUsername(), userModel.getPassword()
                    )
            );

            User user = (User) authenticate.getPrincipal();

            return ResponseEntity.ok()
                    .header("Access-Control-Expose-Headers", HttpHeaders.AUTHORIZATION)
                    .header("Access-Control-Allow-Headers", HttpHeaders.AUTHORIZATION)
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtill.generateAccessToken(user) )
                    .body( modelMapper.map( user, UserModel.class ) );
        } catch (BadCredentialsException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }


}
