package ua.nure.kravchenko.entity;

import lombok.Data;
import java.sql.Timestamp;


@Data
public class Payment {
    private Integer id;
    private Timestamp date;
    private double money;
    private boolean acceptStatus;
    private Balance balance;
}
