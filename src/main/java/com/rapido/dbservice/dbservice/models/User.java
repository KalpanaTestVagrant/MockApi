package com.rapido.dbservice.dbservice.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class User {
    @Id
    private String id;
    private String otp;
    private String mobile;
}