package com.example.trade_centre.model;

import com.example.trade_centre.entity.Roles;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
public class UserModel{
    private String id;
    private String slug;
    private String username;
    private String password;
    private String email;
    private LocalDate dateCreated;
    private String country;
    private Long goldAmount;
    private boolean isActive;
    private List<Roles> userRoles;


}
