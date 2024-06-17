package com.example.demo.service;


import com.example.demo.config.Encode;
import com.example.demo.dto.SaveCardDTO;
import com.example.demo.dto.userDTO;
import com.example.demo.entity.SaveCard;
import com.example.demo.entity.User;
import com.example.demo.repo.SaveCardRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class SaveCardService {

    @Autowired
    private SaveCardRepo saveCardRepo;
    @Autowired
    private ModelMapper modelMapper;

    Encode encode=new Encode();

    public SaveCardDTO saveCard(SaveCardDTO saveCardDTO){
//        String cardName = saveCardDTO.getCardName();
//        String cardNumber= saveCardDTO.getCarNumber();
//        //String cardExDate = saveCardDTO.getExDate();
//
//        String hashedName = encode.hashPassword(cardName);
//        String hashedNumber = encode.hashPassword(cardNumber);
//        //String hashedExDate = encode.hashPassword(cardExDate);
//
//
//        saveCardDTO.setCardName(hashedName);
//        saveCardDTO.setCarNumber(hashedNumber);
//        //saveCardDTO.setExDate(hashedExDate);


        saveCardRepo.save(modelMapper.map(saveCardDTO, SaveCard.class));
        return saveCardDTO;

    }

    public SaveCardDTO updateCard(SaveCardDTO saveCardDTO){
        saveCardRepo.save(modelMapper.map(saveCardDTO,SaveCard.class));
        return  saveCardDTO;
    }

    public boolean deleteCard(SaveCardDTO saveCardDTO){
        saveCardRepo.delete(modelMapper.map(saveCardDTO,SaveCard.class));
        return true;
    }

    public Optional<SaveCard> getCardById(String id) {
        Optional<SaveCard> cardDetail=saveCardRepo.findById(id);
        if (cardDetail.isPresent()) {
            SaveCard card = cardDetail.get();
            return Optional.of(card);
        } else {
            return Optional.empty();
        }
    }
}
