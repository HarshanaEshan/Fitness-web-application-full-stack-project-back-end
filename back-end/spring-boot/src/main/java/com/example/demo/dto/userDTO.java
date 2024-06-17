package com.example.demo.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class userDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private double weight;
    private double height;
    private String email;
    private boolean confirmed;
    private String confirmationToken;


}
