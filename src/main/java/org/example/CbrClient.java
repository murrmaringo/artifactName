package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CbrClient {

    // URL для запроса
    private static final String CB_URL = "https://www.cbr-xml-daily.ru/daily_json.js";

    // Объект для HTTP-запросов
    private final RestTemplate restTemplate;
    // ObjectMapper нужен, если требуется более тонкая настройка маппинга (иначе RestTemplate сам использует его)
    private final ObjectMapper objectMapper;

    public List<CurrencyRateDto> fetchRates() {
        // Отправляем GET-запрос и получаем JSON-ответ
        ResponseEntity<CbrResponse> response = restTemplate.getForEntity(CB_URL, CbrResponse.class);

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new RuntimeException("Ошибка при получении данных от ЦБР");
        }

        CbrResponse cbrResponse = response.getBody();

        // Преобразуем каждую валюту к CurrencyRateDto.
        // При этом можно учитывать свойство Nominal, чтобы курс отражался за 1 единицу валюты.
        Map<String, CurrencyInfo> valuteMap = cbrResponse.getValute();
        return valuteMap.values().stream()
                .map(currencyInfo -> {
                    // Рассчитываем курс на единицу валюты:
                    double ratePerUnit = currencyInfo.getValue() / currencyInfo.getNominal();
                    return new CurrencyRateDto(currencyInfo.getCharCode(), ratePerUnit);
                })
                .collect(Collectors.toList());
    }
}
