package org.example

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.Currency;

import java.util.UUID;

public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
}