package com.example.trade_centre.service;

import com.example.trade_centre.entity.Roles;
import com.example.trade_centre.entity.User;
import com.example.trade_centre.model.RolesModel;
import com.example.trade_centre.model.UserModel;
import com.example.trade_centre.repository.iRolesRepository;
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

    @Autowired
    private iRolesRepository rolesRepository;

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

    @Override
    public List<Roles> findAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles createRole(RolesModel rolesModel) {
        return rolesRepository.insert( modelMapper.map( rolesModel, Roles.class ) );
    }

    @Override
    public Roles updateRole(RolesModel rolesModel) {

        var old_role = rolesRepository.findById( rolesModel.getId() ).get();

        old_role.setRoleName( rolesModel.getRoleName() );

        return rolesRepository.save( old_role );
    }

    @Override
    public void deleteRoleById(String id) {
        rolesRepository.deleteById(id);
    }
}
