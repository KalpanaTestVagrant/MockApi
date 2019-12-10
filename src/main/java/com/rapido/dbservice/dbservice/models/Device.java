package com.rapido.dbservice.dbservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Device {
    private String carrier;
    private String deviceId;
    private String internet;
    private String manufacturer;
    private String model;
}
