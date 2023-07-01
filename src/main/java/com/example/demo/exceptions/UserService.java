package com.example.demo.exceptions;

import com.example.demo.User;
import com.example.demo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(String login, String password) throws ValidationException {

        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));

        List<String> validationFailures = validate(user);
        if(validationFailures.isEmpty()){
            return userRepository.save(user);
        } else {
            throw new ValidationException(validationFailures);
        }

    }

    private List<String> validate(User user) {
        Optional<User> byLogin = userRepository.findByLogin(user.getLogin());
        if(byLogin.isPresent()){
            return Arrays.asList("loginAlreadyExists");
        }
        return Collections.emptyList();
    }



}
