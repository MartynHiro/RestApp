package ru.sergey.repositories;

import org.springframework.stereotype.Repository;
import ru.sergey.services.Authorities;
import ru.sergey.users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userRepository;

    //создаем вручную наших юзеров
    public UserRepository() {
        userRepository = new ArrayList<>();
        userRepository.add(new User("Ana", "11236"));
        userRepository.add(new User("Sergey", "25416"));
        userRepository.add(new User("MamaSita", "234567754"));
    }

    public List<Authorities> getUserAuthorities(String login, String password) {

        for (User user : userRepository) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return Arrays.asList(Authorities.values());
            }
        }
        return new ArrayList<>();
    }
}
