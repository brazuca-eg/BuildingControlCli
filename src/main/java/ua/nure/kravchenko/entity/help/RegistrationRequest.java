package ua.nure.kravchenko.entity.help;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String login;
    private String password;
    private String name;
    private String surname;
}
