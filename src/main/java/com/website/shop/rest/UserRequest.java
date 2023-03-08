package com.website.shop.rest;

import com.website.shop.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserRequest {

    @NotBlank(message = "Field is mandatory")
    private String phoneNumber;

    @NotBlank(message = "Field is mandatory")
    @Email(regexp = "^.+@.+\\..+$", message = "Wrong email format")
    private String email;
    @Size(min = 4, max = 255, message = "Password size > 3 < 256")
    private String password;

    private User.PersonalInfo personalInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PersonalInfo {
        private String firstName;
        private String lastName;
        private String photo;
        private User.PersonalInfo.Address address;
        private User.PersonalInfo.PaymentCard paymentCard;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Address {
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
            private String number;
            private String expirationDate;
            private String secureCode;
            private String fullName;
        }
    }
}
