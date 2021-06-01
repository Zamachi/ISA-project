package com.example.trade_centre.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Tags {
    @Id
    private String id;
    private String name;
    private String name_search;
}
