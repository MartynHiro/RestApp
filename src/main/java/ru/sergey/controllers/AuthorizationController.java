package ru.sergey.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.sergey.exceptions.InvalidCredentialsException;
import ru.sergey.exceptions.UnauthorizedUserException;
import ru.sergey.services.Authorities;
import ru.sergey.services.AuthorizationService;
import ru.sergey.users.User;

import java.util.List;

@RestController
public class AuthorizationController {
    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestBody @Validated User user) {
        return service.getAuthorities(user.getLogin(), user.getPassword());
    }

    //отсылает обратно клиенту HTTP-статус с кодом 400 и телом в виде сообщения из exception
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentialsException e) {
        return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
    }

    //так же пишет в консоль сообщение из exception
    @ExceptionHandler(UnauthorizedUserException.class)
    public ResponseEntity<String> unauthorizedUser(UnauthorizedUserException e) {
        final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);
        logger.error(e.getMessage());
        return new ResponseEntity<>("UNAUTHORIZED", HttpStatus.UNAUTHORIZED);
    }
}