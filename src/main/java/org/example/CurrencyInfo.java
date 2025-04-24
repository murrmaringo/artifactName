package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrencyInfo {
    @JsonProperty("CharCode")
    private String charCode;

    @JsonProperty("Nominal")
    private int nominal;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Value")
    private double value;

    @JsonProperty("Previous")
    private double previous;
}
