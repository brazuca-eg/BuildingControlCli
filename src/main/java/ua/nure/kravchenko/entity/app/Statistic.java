package ua.nure.kravchenko.entity.app;

import lombok.Data;
import ua.nure.kravchenko.entity.Location;

import java.sql.Timestamp;

@Data
public class Statistic {
    private Timestamp date;
    private Location location;
    private double markAverage;
    private double parametersAverage;
}
