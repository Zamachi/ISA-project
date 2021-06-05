package com.example.trade_centre.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class TraitModel {

    private String id;
    private String traitName;

}
