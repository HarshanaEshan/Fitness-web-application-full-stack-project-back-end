package com.example.demo.controller;


import com.example.demo.config.Encode;
import com.example.demo.dto.PaymentplanesDTO;
import com.example.demo.dto.SaveCardDTO;
import com.example.demo.dto.userDTO;
import com.example.demo.entity.SaveCard;
import com.example.demo.service.PaymentService;
import com.example.demo.service.SaveCardService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v3/card")
@CrossOrigin
public class SaveCardController {
    @Autowired
    private SaveCardService saveCardService;

    @PostMapping("/saveCard")
    public SaveCardDTO saveCard(@RequestBody SaveCardDTO saveCardDTO)
    {
        return saveCardService.saveCard(saveCardDTO);
    }



    @PutMapping("/updateCard")
    public SaveCardDTO updateUser(@RequestBody SaveCardDTO saveCardDTO)
    {
        return saveCardService.updateCard(saveCardDTO);
    }

    @DeleteMapping("/deleteCard")
    public boolean deleteUser(@RequestBody SaveCardDTO saveCardDTO)
    {
        return saveCardService.deleteCard(saveCardDTO);
    }

    @GetMapping("/{id}")
    public Optional<SaveCard> getProductById(@PathVariable String id) {
        return saveCardService.getCardById(id);
    }
}
