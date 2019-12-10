package com.rapido.dbservice.dbservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Location {
    List<String> locationType;
    private Double latitude;
    private Double longitude;
}
