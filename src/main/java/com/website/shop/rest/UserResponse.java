package com.website.shop.rest;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UserResponse {

    private long id;
    private String phoneNumber;
    private String email;
    private String password;

    private UserResponse.PersonalInfo personalInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PersonalInfo {
        private long id;
        private String firstName;
        private String lastName;
        private String photo;
        private PersonalInfo.Address address;
        private PersonalInfo.PaymentCard paymentCard;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Address {
            private long id;
            private String country;
            private String city;
            private String street;
            private String postalCode;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class PaymentCard {
            private long id;
            private String number;
            private String expirationDate;
            private String secureCode;
            private String fullName;
        }
    }
}
