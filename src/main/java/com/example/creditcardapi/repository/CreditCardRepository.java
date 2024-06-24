package com.example.creditcardapi.repository;
import com.example.creditcardapi.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{
}
