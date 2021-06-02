package com.example.trade_centre.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class RolesModel {

    private String id;
    private String roleName;
}
