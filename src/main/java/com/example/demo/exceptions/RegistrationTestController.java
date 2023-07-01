package com.example.demo.exceptions;

import com.example.demo.User;
import com.example.demo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class RegistrationTestController {

    private final UserService userService;

    @GetMapping
    @ResponseBody
    public boolean createTestUser(){

        try {
            userService.registerUser("Tomasz", "TOmasz");
        } catch (ValidationException e) {

            List<String> validationErrors = e.getValidationErrors();

            // n1`model.setAttribute("validation", validationErrors);

            // return widok;
        }
        return true;
    }
}
