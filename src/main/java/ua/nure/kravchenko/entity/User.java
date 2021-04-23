package ua.nure.kravchenko.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String login;
    private RoleEntity roleEntity;
    private Location location;
    private Balance balance;
    private String token;
    private String name;
    private String surname;
}
