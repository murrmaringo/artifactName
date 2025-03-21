package org.example;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Currency {
    private String id;
    private String name;
    private String baseCurrency = "RUB";
    private String priceChangeRange;
    private String description;
}