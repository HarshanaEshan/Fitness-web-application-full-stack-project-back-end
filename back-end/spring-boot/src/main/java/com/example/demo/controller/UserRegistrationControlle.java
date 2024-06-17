//package com.example.demo.controller;
//
//import com.example.demo.dto.userDTO;
//import com.example.demo.service.ConfimationService;
//
//import com.example.demo.service.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin
//@RequestMapping(value = "api/v2/token")
//@RestController
//public class UserRegistrationControlle {
//    @Autowired
//    private EmailService emailService;
//
//    @Autowired
//    private ConfimationService confirmationTokenService;
//
//    @PostMapping("/register")
//    public String registerUser(@RequestBody userDTO user) {
//        // Save user logic here
//        // Generate and save confirmation token
//        String token = confirmationTokenService.generateToken(user.getEmail());
//
//        // Construct confirmation link
//        String confirmationLink = "http://yourdomain.com/api/v2/token/confirm?token=" + token;
//
//        // Send confirmation email
//        emailService.sendSimpleMessage(
//                user.getEmail(),
//                "Confirm your email",
//                "Thank you for registering. Please click on the below link to confirm your registration: " + confirmationLink
//        );
//
//        return "Please check your email to confirm your registration.";
//    }
//
//    @GetMapping("/confirm")
//    public String confirmUser(@RequestParam("token") String token) {
//        // Validate token and activate user account
//        boolean isValidToken = confirmationTokenService.validateToken(token);
//        if (isValidToken) {
//            // Activate user account logic
//            return "Your account has been successfully confirmed.";
//        } else {
//            return "Invalid or expired token.";
//        }
//    }
//}
