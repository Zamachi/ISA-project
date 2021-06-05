package com.example.trade_centre.service;

import com.example.trade_centre.model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface iAuthenticationService extends UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    UserModel login(UserModel user);
}
