package com.example.demo.controller;


import com.example.demo.dto.ConfirmationTokenDTO;
import com.example.demo.service.ConfimationService;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v2/mail")
@CrossOrigin
public class mailController {
    @Autowired
    private ConfimationService confimationService;
    @PostMapping("/saveToken")
    public ConfirmationTokenDTO saveToken(@RequestBody ConfirmationTokenDTO confirmationTokenDTO)
    {
        return confimationService.saveToken(confirmationTokenDTO);
    }
}
