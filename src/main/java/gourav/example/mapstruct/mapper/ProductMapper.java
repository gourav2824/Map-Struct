package gourav.example.mapstruct.mapper;

import gourav.example.mapstruct.model.Product;
import gourav.example.mapstruct.model.ProductDTO;
import gourav.example.mapstruct.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {
    @Mapping(target = "status", ignore = true)
    ProductDTO productToProductDTO(Product product);

    Type typeToProductType(String type);
}
