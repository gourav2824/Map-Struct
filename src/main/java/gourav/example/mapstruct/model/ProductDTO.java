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
    private String productCode;
    private String color;
    private List<String> material;
}
