package ua.nure.kravchenko.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Integer id;
    private String login;
    private String password;
    private RoleEntity roleEntity;
    private Location location;
    private Balance balance;
}
