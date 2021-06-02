package com.example.trade_centre.service;

import com.example.trade_centre.entity.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class RolesService implements iRolesService{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Roles> generateRegisteredUserRoles() {

        List<Roles> listOfRoles = new ArrayList<>();

        Roles role = new Roles();
        role.setRoleName("user");

        listOfRoles.add(role);

        return listOfRoles;

    }
}
