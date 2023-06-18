package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class RegistrationTestController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    @ResponseBody
    public boolean createTestUser(){

        User user = new User();
        user.setLogin("Tomasz2");

        user.setPassword(passwordEncoder.encode("Tomasz"));

        userRepository.save(user);


        User user2 = new User();
        user2.setLogin("Tomasz");

        user2.setPassword(passwordEncoder.encode("Tomasz"));
        userRepository.save(user2);
        return true;
    }
}
