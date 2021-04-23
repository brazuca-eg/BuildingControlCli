package ua.nure.kravchenko.entity;

import lombok.Data;

@Data
public class Detail {
    private Integer id;
    private java.sql.Timestamp datetime;
    private double parameter;
    private int mark;
    private Location location;
}
