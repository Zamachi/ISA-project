package com.example.trade_centre.service;


import com.example.trade_centre.entity.Roles;
import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.UserModel;
import com.example.trade_centre.repository.iUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service()
public class UserService implements iUserService, UserDetailsService{

    @Autowired
    private iUserRepository userRepository;
    @Autowired
    private AutoMapperService autoMapperService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User insert(UserModel model) {

        model.setSlug( model.getUsername().toLowerCase() );

        var sameSlugs = findAllBySlug(model.getSlug());

        if (sameSlugs.size() > 0) {
            return null;
        }

        model.setDateCreated( LocalDate.now() );
        model.setActive(true);
        model.setGoldAmount( (long) (1+Math.random()*1000000) );



        model.setUserRoles( rolesService.generateRegisteredUserRoles() );

        var test = modelMapper.map(model,User.class);

        return userRepository.insert( test );
    }

    @Override
    public User insert(User entity) {
        return userRepository.insert(entity);
    }

    @Override
    public User findBySlug(String slug) {
        return userRepository.findBySlug(slug);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllBySlug(String slug) {
        return userRepository.findAllBySlug( slug );
    }

//    @Override
//    public UserModel login(UserModel userModel) {
//        var userEntity = modelMapper.map(userModel, com.example.trade_centre.entity.User.class);
//
//        try {
//            //DANGER: userFromBase je UserDetails, samim tim vraca null nad podacima koji nisu authorities, username ili password, treba prilagoditi interfejs
//            var userFromBase = loadUserByUsername(userEntity.getUsername());
//            if( userFromBase != null && passwordEncoder.matches( userEntity.getPassword() , userFromBase.getPassword() ) && userFromBase.isEnabled() ){
//                return modelMapper.map( userFromBase, UserModel.class );
//            }
//        } catch (UsernameNotFoundException e) {
//            return null;
//        }
//
//        return null;
//    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {

        var user_from_database = findByUsername(s);

       if(user_from_database == null) {
           throw new UsernameNotFoundException("User not found");
       }

       return user_from_database;

    }
}
