package com.example.creditcardapi.service;

import com.example.creditcardapi.entity.CreditCard;
import com.example.creditcardapi.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    public Optional<CreditCard> getCreditCardById(Long id) {
        return creditCardRepository.findById(id);
    }

    public CreditCard addCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public CreditCard updateCreditCard(Long id, CreditCard creditCardDetails) {
        CreditCard creditCard = creditCardRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarjeta de crédito no encontrada"));

        creditCard.setCardNumber(creditCardDetails.getCardNumber());
        creditCard.setHolderName(creditCardDetails.getHolderName());
        creditCard.setExpirationDate(creditCardDetails.getExpirationDate());
        creditCard.setCvv(creditCardDetails.getCvv());

        return creditCardRepository.save(creditCard);
    }

    public void deleteCreditCard(Long id) {

        CreditCard creditCard = creditCardRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarjeta de crédito no encontrada"));
        creditCardRepository.delete(creditCard);
    }

    public boolean existsByCardNumber(String cardNumber) {
        return creditCardRepository.existsByCardNumber(cardNumber);
    }
}
