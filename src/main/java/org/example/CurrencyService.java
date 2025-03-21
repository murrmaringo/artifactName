package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class CurrencyService {

    private final List<Currency> currencies = new ArrayList<>();

    public List<Currency> getAllCurrencies() {
        return currencies;
    }

    public void addCurrency(CurrencyRequest currencyRequest) {
        Currency currency = new Currency();
        currency.setId(UUID.randomUUID().toString());
        currency.setName(currencyRequest.getName());
        currency.setBaseCurrency(currencyRequest.getBaseCurrency());
        currency.setPriceChangeRange(currencyRequest.getPriceChangeRange());
        currency.setDescription(currencyRequest.getDescription());
        currencies.add(currency);
    }

    public Currency getCurrencyById(String id) {
        return currencies.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Валюта не найдена"));
    }

    public void updateCurrency(String id, CurrencyRequest currencyRequest) {
        Currency currency = getCurrencyById(id);
        currency.setName(currencyRequest.getName());
        currency.setBaseCurrency(currencyRequest.getBaseCurrency());
        currency.setPriceChangeRange(currencyRequest.getPriceChangeRange());
        currency.setDescription(currencyRequest.getDescription());
    }

    public void deleteCurrency(String id) {
        Currency currency = getCurrencyById(id);
        currencies.remove(currency);
    }
}
