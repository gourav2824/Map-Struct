package gourav.example.mapstruct.mapper;

import gourav.example.mapstruct.model.Product;
import gourav.example.mapstruct.model.ProductDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);
}
