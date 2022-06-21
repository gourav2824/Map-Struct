package gourav.example.mapstruct.model;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class ProductDTO {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    private String description;
    private String productCode;
    private String color;
    private PriceDTO price;
    private int weightValue;
    private String weightUnit;
    private int dimensionsCount;
    private Size size;
    private String country;
    private Type type;
    private List<String> material;
    private ProductStatus status;
}
