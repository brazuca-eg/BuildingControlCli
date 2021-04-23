package ua.nure.kravchenko.entity;

import lombok.Data;

@Data
public class Balance {
    private Integer id;
    private int card;
    private double balance;
    private double request;
    private UserEntity user;
}































































