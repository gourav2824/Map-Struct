package gourav.example.mapstruct.model;

import lombok.Data;

@Data
public class PriceDTO {
    private int amount;
    private String currency;
    private String countryCode;
}
