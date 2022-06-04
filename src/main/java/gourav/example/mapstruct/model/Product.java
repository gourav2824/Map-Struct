package gourav.example.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String description;
    private int productCode;
    private String color;
    private Price price;
    private City city;
    private Weight weight;
    private Size size;
    private String type;
    private List<String> material;
    private Status status;
}
