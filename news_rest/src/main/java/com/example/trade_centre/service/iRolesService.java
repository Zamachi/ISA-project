package com.example.trade_centre.service;

import com.example.trade_centre.entity.Roles;
import com.example.trade_centre.model.RolesModel;
import com.example.trade_centre.model.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface iRolesService {

    List<Roles> generateRegisteredUserRoles();
    List<Roles> fetchUserRoles(UserModel userModel);
     List<Roles> findAllRoles();

     Roles createRole( RolesModel rolesModel);

     Roles updateRole( RolesModel rolesModel);

     void deleteRoleById( String id);
}
