package ua.nure.kravchenko.entity.help;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
