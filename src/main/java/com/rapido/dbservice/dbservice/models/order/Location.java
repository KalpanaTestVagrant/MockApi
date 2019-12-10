package com.rapido.dbservice.dbservice.models.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Location {
    List<String> locationType;
    private Double lat;
    private Double lng;
    private Double currLat;
    private Double currLng;
    private Double setLat;
    private Double setLng;
}
