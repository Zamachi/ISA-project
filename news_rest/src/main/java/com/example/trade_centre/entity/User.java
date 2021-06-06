package com.example.trade_centre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Document(collection = "users")
public class User implements Serializable, UserDetails {    //NOTE: Implementiramo UserDetails interfejs da bi entitet mogli da koristimo kroz funkcije sa tokenom
    @Id
    private String id;
    @Field("slug")
    private String slug;
    @Field("username")
    private String username;
    @Field("password")
    private String password; 
    @Field("email")
    private String email;
    @Field("dateCreated")
    private LocalDate dateCreated;
    @Field("country")
    private String country;
    @Field("goldAmount")
    private Long goldAmount;
    @Field("isActive")
    private boolean isActive;
    @Field("userRoles")
    private List<Roles> userRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userRoles.forEach(roles -> authorities.add( new SimpleGrantedAuthority( roles.getRoleName() ) ));

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
