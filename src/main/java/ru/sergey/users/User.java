package ru.sergey.users;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

//pojo объект для сохранения юзеров
@Validated
public class User {
    @Size(min = 3, max = 20)
    @NotBlank
    private final String login;
    @NotBlank
    @Min(5)
    @Max(25)
    private final String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
