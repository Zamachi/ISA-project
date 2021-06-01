package com.example.trade_centre.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserModel {
    private String id;
    private String slug;
    private String username;
    private String password;
    private String email;
    private LocalDate date_created;
    private String country;
    private Long gold_amount;
    private boolean is_active;
}
