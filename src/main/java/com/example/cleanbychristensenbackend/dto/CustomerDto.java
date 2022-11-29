package com.example.cleanbychristensenbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CustomerDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private double kvm;
}