package com.example.trade_centre.service;

import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.UserModel;
import com.example.trade_centre.repository.iUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service()
public class LoginService implements iLoginService{

    @Autowired
    private iUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserModel login(UserModel user) {

        var userEntity = modelMapper.map(user,User.class);

        var userFromBase = userRepository.findByUsername( userEntity.getUsername() );

        if( userFromBase != null && passwordEncoder.matches( userEntity.getPassword() , userFromBase.getPassword() ) && userFromBase.isActive()){
            return modelMapper.map( userFromBase, UserModel.class );
        }

        return null;
    }
}
