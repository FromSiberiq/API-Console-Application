package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    private Location location;
    private Current current;
}
