package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class SaveCard {
    @Id
    private String userName;
    private String cardName;
    private String carNumber;
    private String exDate;
    private int cvc;
}
