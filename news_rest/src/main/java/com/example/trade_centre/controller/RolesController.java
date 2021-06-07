package com.example.trade_centre.controller;

import com.example.trade_centre.entity.Roles;
import com.example.trade_centre.model.RolesModel;
import com.example.trade_centre.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping("getallroles")
    @CrossOrigin(origins = "*")
    public List<Roles> findAllTraits(){
        return rolesService.findAllRoles();
    }

    @PostMapping("createrole")
    @CrossOrigin(origins="*")
    private Roles createRole(@RequestBody RolesModel rolesModel){
        return rolesService.createRole(rolesModel);
    }

    @PutMapping("updaterole")
    @CrossOrigin(origins = "*")
    private Roles updateRole(@RequestBody RolesModel rolesModel){
        return rolesService.updateRole(rolesModel);
    }

    @DeleteMapping("deleterole/{id}")
    @CrossOrigin(origins = "*")
    private void deleteRoleById(@PathVariable("id") String id){
        rolesService.deleteRoleById(id);
    }

}
