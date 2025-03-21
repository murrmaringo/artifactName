package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.example.Currency;
import java.util.List;
import java.util.ArrayList;


@SpringBootApplication
@RestController
public class MyRestController {
    private List<Currency> currencies = new ArrayList<>();
    @Autowired

    private CurrencyService currencyService;


    @GetMapping("/api/currencies")
    public List<Currency> getCurrencies() {
        return currencies;
    }


    @PostMapping("/api/currencies")
    public ResponseEntity<Void> addCurrency(@RequestBody CurrencyRequest currencyRequest) {
        currencyService.addCurrency(currencyRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/currencies/{id}")
    public ResponseEntity<Currency> getCurrency(@PathVariable String id) {
        Currency currency = currencyService.getCurrencyById(id);
        return new ResponseEntity<>(currency, HttpStatus.OK);
    }

    @PutMapping("/api/currencies/{id}")
    public ResponseEntity<Void> updateCurrency(@PathVariable String id, @RequestBody CurrencyRequest currencyRequest) {
        currencyService.updateCurrency(id, currencyRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/currencies/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable String id) {
        currencyService.deleteCurrency(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}