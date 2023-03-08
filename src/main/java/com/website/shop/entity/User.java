package com.website.shop.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.testng.annotations.Optional;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id @GeneratedValue
    private long id;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("personalInfo")

    private PersonalInfo personalInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PersonalInfo {

        @Id @GeneratedValue
        private long id;
        private String firstName;
        private String lastName;
        private String photo;
        @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
        @JoinColumn(name = "address_id", nullable = false)
        private Address address;
        @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
        @JoinColumn(name = "paymentCard_id", nullable = false)
        private PaymentCard paymentCard;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Address {

            @Id @GeneratedValue
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

            @Id @GeneratedValue
            private long id;
            private String number;
            private String expirationDate;
            private String secureCode;
            private String fullName;
        }
    }
}
