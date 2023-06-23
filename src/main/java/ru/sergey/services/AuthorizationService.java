package ru.sergey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergey.exceptions.InvalidCredentialsException;
import ru.sergey.exceptions.UnauthorizedUserException;
import ru.sergey.repositories.UserRepository;

import java.util.List;
@Service
public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    //проверка на заполненность и возвращение возможных операций для данного пользователя
    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentialsException("User name or password is empty");
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);

        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUserException("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}