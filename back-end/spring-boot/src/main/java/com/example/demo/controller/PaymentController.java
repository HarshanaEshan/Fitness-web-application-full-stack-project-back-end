package com.example.demo.controller;


import com.example.demo.config.Encode;
import com.example.demo.dto.PaymentplanesDTO;
import com.example.demo.dto.userDTO;
import com.example.demo.service.PaymentService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;



    @PostMapping("/savePayments")
    public PaymentplanesDTO saveUser(@RequestBody PaymentplanesDTO paymentplanesDTO)
    {
        return paymentService.savePayments(paymentplanesDTO);
    }
}
