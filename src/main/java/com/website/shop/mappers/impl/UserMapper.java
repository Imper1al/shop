package com.website.shop.mappers.impl;

import com.website.shop.entity.User;
import com.website.shop.mappers.Mapper;
import com.website.shop.rest.UserRequest;
import com.website.shop.rest.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserResponse> {

    @Override
    public UserResponse mapTo(User from) {
        return UserResponse.builder()
                .id(from.getId())
                .email(from.getEmail())
                .phoneNumber(from.getPhoneNumber())
                .personalInfo(mapPersonalInfo(from.getPersonalInfo()))
                .build();
    }

    @Override
    public User createUserRequestToUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setPersonalInfo(userRequest.getPersonalInfo());
        return user;
    }

    private UserResponse.PersonalInfo mapPersonalInfo(User.PersonalInfo personalInfo) {
        return UserResponse.PersonalInfo.builder()
                .id(personalInfo.getId())
                .firstName(personalInfo.getFirstName())
                .lastName(personalInfo.getLastName())
                .photo(personalInfo.getPhoto())
                .address(mapAddress(personalInfo.getAddress()))
                .paymentCard(mapPaymentCard(personalInfo.getPaymentCard()))
                .build();
    }

    private UserResponse.PersonalInfo.Address mapAddress(User.PersonalInfo.Address address) {
        return UserResponse.PersonalInfo.Address.builder()
                .id(address.getId())
                .city(address.getCity())
                .country(address.getCountry())
                .street(address.getStreet())
                .postalCode(address.getPostalCode())
                .build();
    }
    private UserResponse.PersonalInfo.PaymentCard mapPaymentCard(User.PersonalInfo.PaymentCard paymentCard) {
        return UserResponse.PersonalInfo.PaymentCard.builder()
                .id(paymentCard.getId())
                .number(paymentCard.getNumber())
                .expirationDate(paymentCard.getExpirationDate())
                .secureCode(paymentCard.getSecureCode())
                .fullName(paymentCard.getFullName())
                .build();
    }
}
