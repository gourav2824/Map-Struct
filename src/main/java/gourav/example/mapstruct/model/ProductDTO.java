package gourav.example.mapstruct.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDTO {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    private String description;
    private String entity;
    private String productCode;
    private String color;
    private PriceDTO price;
    private int weightValue;
    private String weightUnit;
    private Label label;
    private int dimensionsCount;
    private Size size;
    private String country;
    private Type type;
    private List<String> material;
    private ProductStatus status;
}
