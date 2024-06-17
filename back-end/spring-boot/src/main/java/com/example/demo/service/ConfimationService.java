package com.example.demo.service;

import com.example.demo.dto.ConfirmationTokenDTO;
import com.example.demo.dto.SaveCardDTO;
import com.example.demo.entity.ConfirmationToken;
import com.example.demo.entity.Paymentplanes;
import com.example.demo.entity.SaveCard;
import com.example.demo.repo.ConfirmationTokenRepo;
import com.example.demo.repo.SaveCardRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ConfimationService {

    @Autowired
    private ConfirmationTokenRepo confirmationTokenRepo;
    @Autowired
    private ModelMapper modelMapper;



    public ConfirmationTokenDTO saveToken(ConfirmationTokenDTO confirmationTokenDTO){
        confirmationTokenRepo.save(modelMapper.map(confirmationTokenDTO, ConfirmationToken.class));
        return confirmationTokenDTO;

    }



    public String generateToken(String userEmail) {
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.setToken(token);
        confirmationToken.setUserEmail(userEmail);
        confirmationToken.setExpiryDate(LocalDateTime.now().plusHours(24));
        // Set the userName field as the primary key
        confirmationToken.setUserName(userEmail); // You might want to adjust this based on your business logic
        confirmationTokenRepo.save(confirmationToken);
        return token;
    }

    public boolean validateToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenRepo.findByToken(token);
        if (confirmationToken != null && !confirmationToken.isExpired()) {
            // Optionally, you may want to delete the token after it's been used for validation
            confirmationTokenRepo.delete(confirmationToken);
            return true;
        }
        return false;
    }
}
