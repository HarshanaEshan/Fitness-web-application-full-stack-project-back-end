package com.example.demo.controller;

import com.example.demo.dto.ConfirmationTokenDTO;
import com.example.demo.dto.userDTO;
import com.example.demo.service.ConfimationService;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RequestMapping(value = "api/v2/token")
@RestController
public class UserRegistrationController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private ConfimationService confimationService;

    @PostMapping("/register")
    public String registerUser(@RequestBody userDTO user) {
        // Save user logic here
        String token = confimationService.generateToken(user.getEmail());
        String confirmationLink = "http://localhost:8080/api/v2/token/confirm?token=" + token;
        emailService.sendSimpleMessage(
                user.getEmail(),
                "Confirm your email",
                "Thank you for registering. Please click on the below link to confirm your registration:"+confirmationLink
        );
        return "Please check your email to confirm your registration.";
    }





    @GetMapping("/confirm")
    public String confirmUser(@RequestParam("token") String token) {
        // Validate token and activate user account
        boolean isValidToken = confimationService.validateToken(token);
        if (isValidToken) {
            // Activate user account login
            return "Your account has been successfully confirmed.";
        } else {
            return "Invalid or expired token.";
        }
    }

}

