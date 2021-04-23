package ua.nure.kravchenko.entity;

import lombok.Data;
import java.util.List;

@Data
public class Location {
    private Integer id;
    private String adress;
    private double floor;
    private double room;
    private double square;
    private List<User> usersInTheLocation;
    private List<Detail> locationDetails;
    public Location() {
    }

    public Location(String address, int floor, int room, double square) {
        this.adress = address;
        this.floor = floor;
        this.room = room;
        this.square = square;
    }

}
