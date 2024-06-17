package com.example.demo.repo;

import com.example.demo.entity.Paymentplanes;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Paymentplanes,String> {
}
