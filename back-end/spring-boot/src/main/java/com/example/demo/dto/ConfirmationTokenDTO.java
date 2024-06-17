package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class ConfirmationTokenDTO {
    private String userName;
    private String token;
    private String userEmail;
    private LocalDateTime expiryDate;

}
