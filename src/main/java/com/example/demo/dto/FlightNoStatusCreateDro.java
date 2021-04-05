package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightNoStatusCreateDro {
    private int airCompanyId;
    private int airplaneId;
    private String dep_country;
    private String dest_country;
    private int distance;

    @DateTimeFormat(pattern = "HH:mm")
    private String est_flight_time;

}
