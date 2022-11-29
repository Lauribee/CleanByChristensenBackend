package com.example.cleanbychristensenbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class ReviewDto implements Serializable {
    private Long id;
    private Double amountOfStars;
    private String reviewMessage;
}
