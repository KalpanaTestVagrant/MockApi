package com.rapido.dbservice.dbservice.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class AuthLog {
    @Id
    private String id;
    private Boolean active;
    private Integer rating;
    private String userId;
    private Double loginOn;
    private String userType;
    private Integer appId;
    private String apnToken;
    private Location location;
    private Device device;
    private Double logoutOn;
    private String logoutVia;
}
