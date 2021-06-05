package com.example.trade_centre.service;

import com.example.trade_centre.entity.Roles;
import com.example.trade_centre.model.UserModel;

import java.util.List;

public interface iRolesService {

    List<Roles> generateRegisteredUserRoles();
    List<Roles> fetchUserRoles(UserModel userModel);
}
