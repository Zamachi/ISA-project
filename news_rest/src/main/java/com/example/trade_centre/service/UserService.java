package com.example.trade_centre.service;


import com.example.trade_centre.entity.Roles;
import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.UserModel;
import com.example.trade_centre.repository.iUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service()
public class UserService implements iUserService, UserDetailsService {

    @Autowired
    private iUserRepository userRepository;
    @Autowired
    private AutoMapperService autoMapperService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RolesService rolesService;


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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
