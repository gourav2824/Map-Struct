package gourav.example.mapstruct.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class ProductDTO {
    @NonNull
    private Integer id;
    private String name;
}
