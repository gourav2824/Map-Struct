package gourav.example.mapstruct.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String description;
    private int productCode;
    private String colour;
    private Price price;
    private Weight weight;
    private List<Dimension> productDimensions;
    private City city;
    private String type;
    private List<String> material;
    private Status status;
}
