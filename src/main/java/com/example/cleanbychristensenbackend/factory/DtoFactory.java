package com.example.cleanbychristensenbackend.factory;

import com.example.cleanbychristensenbackend.customer.model.Customer;
import com.example.cleanbychristensenbackend.dto.CustomerDto;
import com.example.cleanbychristensenbackend.dto.ReviewDto;
import com.example.cleanbychristensenbackend.review.model.Review;

import java.util.List;
import java.util.stream.Collectors;

public class DtoFactory {

        /*
            Customers
         */
        public static CustomerDto fromCustomer(Customer customer) {
            CustomerDto dto = new CustomerDto();
            dto.setId(customer.getId());
            dto.setFirstName(customer.getFirstName());
            dto.setLastName(customer.getLastName());
            dto.setAddress(customer.getAddress());
            dto.setPhoneNumber(customer.getPhoneNumber());
            dto.setKvm(customer.getKvm());
            return dto;
        }

        public static Customer fromCustomerDto(CustomerDto dto) {
            Customer customer = new Customer();
            if (dto.getId() != null) {
                customer.setId(dto.getId());
            }
            if (dto.getFirstName() != null) {
                customer.setFirstName(dto.getFirstName());
            }
            if (dto.getLastName() != null) {
                customer.setLastName(dto.getLastName());
            }
            if (dto.getAddress() != null) {
                customer.setAddress(dto.getAddress());
            }
            if (dto.getPhoneNumber() != null) {
                customer.setPhoneNumber(dto.getPhoneNumber());
            }
            if (dto.getKvm() != 0) {
                customer.setKvm(dto.getKvm());
            }
            return customer;
        }

        public static List<CustomerDto> fromCustomers(List<Customer> customers) {
            return customers.stream().map(obj -> fromCustomer(obj)).collect(Collectors.toList());
        }

        public static List<Customer> fromCustomerDtos(List<CustomerDto> customerDtos) {
            return customerDtos.stream().map(obj -> fromCustomerDto(obj))
                    .collect(Collectors.toList());
        }

        /*
            Reviews
         */
        public static ReviewDto fromReview(Review review) {
            ReviewDto dto = new ReviewDto();
            dto.setId(review.getId());
            dto.setAmountOfStars(review.getStars());
            dto.setReviewMessage(review.getReviewMessage());
            return dto;
        }

        public static Review fromReviewDto(ReviewDto dto) {
            Review review = new Review();
            if (dto.getId() != null) {
                review.setId(dto.getId());
            }
            if (dto.getAmountOfStars() != 0) {
                review.setStars(dto.getAmountOfStars());
            }
            if (dto.getReviewMessage() != null) {
                review.setReviewMessage(dto.getReviewMessage());
            }
            return review;
        }

        public static List<ReviewDto> fromReviews(List<Review> reviews) {
            return reviews.stream().map(obj -> fromReview(obj)).collect(Collectors.toList());
        }

        public static List<Review> fromReviewDtos(List<ReviewDto> reviewsDtos) {
            return reviewsDtos.stream().map(obj -> fromReviewDto(obj))
                    .collect(Collectors.toList());
        }
}
