package org.example;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.example.CurrencyRateDto;
import org.example.CbrClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CurrencyRateJob {

    private final CbrClient cbrClient;

    @Scheduled(cron = "0 0 * * *")
    @PostConstruct
    public void fetchAndPrintRates() {
        List<CurrencyRateDto> rates = cbrClient.fetchRates();
        rates.forEach(System.out::println);
    }
}
