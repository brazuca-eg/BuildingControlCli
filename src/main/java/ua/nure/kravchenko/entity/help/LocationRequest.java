package ua.nure.kravchenko.entity.help;

import lombok.Data;

@Data
public class LocationRequest {
    private String address;
    private int floor;
    private int room;
    private double square;
}
