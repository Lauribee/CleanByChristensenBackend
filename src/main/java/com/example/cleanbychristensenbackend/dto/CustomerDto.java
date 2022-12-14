package com.example.cleanbychristensenbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CustomerDto implements Serializable {
    private Long id;
    private String subject;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String message;
    private Double kvm;
}