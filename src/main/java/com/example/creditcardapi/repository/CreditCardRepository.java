package com.example.creditcardapi.repository;
import com.example.creditcardapi.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{
    boolean existsByCardNumber(String cardNumber);

    Optional<CreditCard> findByCardNumberAndHolderNameAndExpirationDateAndCvv(String cardNumber, String holderName, String expirationDate, String cvv);
}
