package org.example;


import org.example.Currency;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
}