
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootApplication
@RestController
public class MyRestController {
    @GetMapping("/currencies")
    public ResponseEntity<List<Currency>> getCurrencies() {
        List<Currency> currencies = currencyService.getAllCurrencies();
        return new ResponseEntity<>(currencies, HttpStatus.OK);
    }

    @PostMapping("/currencies")
    public ResponseEntity<Void> addCurrency(@RequestBody CurrencyRequest currencyRequest) {
        currencyService.addCurrency(currencyRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/currencies/{id}")
    public ResponseEntity<Currency> getCurrency(@PathVariable String id) {
        Currency currency = currencyService.getCurrencyById(id);
        return new ResponseEntity<>(currency, HttpStatus.OK);
    }

    @PutMapping("/currencies/{id}")
    public ResponseEntity<Void> updateCurrency(@PathVariable String id, @RequestBody CurrencyRequest currencyRequest) {
        currencyService.updateCurrency(id, currencyRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/currencies/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable String id) {
        currencyService.deleteCurrency(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}