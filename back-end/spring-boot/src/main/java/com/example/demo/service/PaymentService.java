package com.example.demo.service;


import com.example.demo.dto.PaymentplanesDTO;
import com.example.demo.dto.userDTO;
import com.example.demo.entity.Paymentplanes;
import com.example.demo.entity.User;
import com.example.demo.repo.PaymentRepo;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper modelMapper1;

    public PaymentplanesDTO savePayments(PaymentplanesDTO paymentplanesDTO){
        paymentRepo.save(modelMapper1.map(paymentplanesDTO, Paymentplanes.class));
        return paymentplanesDTO;
    }

    public List<PaymentplanesDTO> getAllpayments()
    {
        List<Paymentplanes>userList=paymentRepo.findAll();
        return modelMapper1.map(userList,new TypeToken<List<PaymentplanesDTO>>(){}.getType());
    }

    public boolean deletePayments(PaymentplanesDTO paymentplanesDTO){
        paymentRepo.delete(modelMapper1.map(paymentplanesDTO,Paymentplanes.class));
        return true;
    }
}
