package com.example.trade_centre.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class QualityModel {

    private String id;
    private String qualityName;
    private String color;

}
