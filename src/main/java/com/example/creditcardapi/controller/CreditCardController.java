package com.example.creditcardapi.controller;

import com.example.creditcardapi.entity.CreditCard;
import com.example.creditcardapi.repository.CreditCardRepository;
import com.example.creditcardapi.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditcards")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping
    public List<CreditCard> getAllCreditCards() {
        return creditCardService.getAllCreditCards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Long id) {
        CreditCard creditCard = creditCardService.getCreditCardById(id).orElseThrow(() -> new RuntimeException("Credit Card not found"));
        return ResponseEntity.ok().body(creditCard);
    }

    @PostMapping
    public CreditCard addCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardService.addCreditCard(creditCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditCard> updateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCardDetails) {
        CreditCard updatedCreditCard = creditCardService.updateCreditCard(id, creditCardDetails);
        return ResponseEntity.ok(updatedCreditCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreditCard(@PathVariable Long id) {
        creditCardService.deleteCreditCard(id);
        return ResponseEntity.noContent().build();
    }

    // endpoint si un número de tarjeta de crédito existe en la base de datos
    @GetMapping("/validate/{cardNumber}")
    public ResponseEntity<Boolean> validateCardNumber(@PathVariable String cardNumber) {
        boolean exists = creditCardService.existsByCardNumber(cardNumber);
        return ResponseEntity.ok(exists);
    }
}
