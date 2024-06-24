package com.example.creditcardapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "creditcard")
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "holderName")
    private String holderName;
    @Column(name = "expirationDate")
    private String expirationDate;
    @Column(name = "cvv")
    private String cvv;
}
