package com.example.trade_centre.service;

import com.example.trade_centre.entity.Roles;
import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.UserModel;
import com.example.trade_centre.repository.iUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class RolesService implements iRolesService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private iUserRepository userRepository;


    @Override
    public List<Roles> generateRegisteredUserRoles() {

        List<Roles> listOfRoles = new ArrayList<>();

        Roles role = new Roles();
        role.setRoleName("ROLE_USER");

        listOfRoles.add(role);

        return listOfRoles;

    }

    @Override
    public List<Roles> fetchUserRoles(UserModel userModel) {

        return modelMapper.map( userModel, User.class ).getUserRoles();

    }
}
