package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class CbrResponse {
    @JsonProperty("Date")
    private String date;

    @JsonProperty("PreviousDate")
    private String previousDate;

    @JsonProperty("PreviousURL")
    private String previousURL;

    @JsonProperty("Timestamp")
    private String timestamp;

    // Здесь ключ — код валюты, значение — информация о валюте
    @JsonProperty("Valute")
    private Map<String, CurrencyInfo> valute;
}
