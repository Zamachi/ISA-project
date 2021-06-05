package com.example.trade_centre.service;

import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.UserModel;
import com.example.trade_centre.repository.iRolesRepository;
import com.example.trade_centre.repository.iUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service()
public class AuthenticationService  implements  iAuthenticationService{

    @Autowired
    private iUserRepository userRepository;

    @Autowired
    private iRolesRepository rolesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        user
            .getUserRoles()
            .forEach(
                roles -> authorities.add( new SimpleGrantedAuthority(roles.getRoleName()) )

            );

        //NOTE: ovo je Spring security User, ne moj user-defined User entity
        return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(), authorities );
    }

    @Override
    public UserModel login(UserModel user) {

        var userEntity = modelMapper.map(user, com.example.trade_centre.entity.User.class);

        try {
            //DANGER: userFromBase je UserDetails, samim tim vraca null nad podacima koji nisu authorities, username ili password, treba prilagoditi interfejs
            var userFromBase = loadUserByUsername(userEntity.getUsername());
            if( userFromBase != null && passwordEncoder.matches( userEntity.getPassword() , userFromBase.getPassword() ) && userFromBase.isEnabled() ){
                return modelMapper.map( userFromBase, UserModel.class );
            }
        } catch (UsernameNotFoundException e) {
            return null;
        }

        return null;

    }
}
