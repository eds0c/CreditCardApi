package com.example.creditcardapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "credit_card")
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "holder_name")
    private String holderName;
    @Column(name = "expiration_date")
    private String expirationDate;
    @Column(name = "cvv")
    private String cvv;
}
