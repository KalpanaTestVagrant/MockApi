package com.rapido.dbservice.dbservice.models.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter @JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    @Id
    private String id;
    private Location pickupLocation;
    private Location dropLocation;
    private String requestId;
    private String status;
}
