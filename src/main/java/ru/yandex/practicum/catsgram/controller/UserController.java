package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exceptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exceptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.tomcat.jni.SSLConf.check;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    private final Map<String, User> users = new HashMap<>();

    @GetMapping
    public List<User> findAll() {
        log.debug("Текущее количество пользователей: {}", users.size());
        return new ArrayList<>(users.values());
    }

    @PostMapping
    public User create(@RequestBody User user) throws Exception {
        check(user);
        log.debug("Added object: {}", user);
        users.put(user.getEmail(), user);
        return user;
    }

    @PutMapping
    public User saveUser(@RequestBody User user) throws Exception {
        if (user.getEmail() == null) {
            throw new InvalidEmailException("Не введен адрес электронной почты");
        }
        if (users.containsKey(user.getEmail())) {
            log.debug("Updated object: {}", user);
        } else {
            log.debug("Added object: {}", user);
        }
        users.put(user.getEmail(), user);
        return user;
    }



    private void check(User user) throws Exception {
        if (user.getEmail() == null) {
            throw new InvalidEmailException("Не введен адрес электронной почты");
        } else {
            for (String email : users.keySet()) {
                if (email.equals(user.getEmail())) {
                    throw new UserAlreadyExistException("Пользователь с таким адресом электронной почты уже существует");
                }
            }
        }
    }
}
