package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class SaveCardDTO {
    private String userName;
    private String cardName;
    private String carNumber;
    private String exDate;
    private int cvc;
}
