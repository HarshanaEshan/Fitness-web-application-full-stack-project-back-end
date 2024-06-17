package com.example.demo.repo;

import com.example.demo.entity.ConfirmationToken;
import com.example.demo.entity.Paymentplanes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationTokenRepo extends JpaRepository<ConfirmationToken,String> {
    ConfirmationToken findByToken(String token);
}
