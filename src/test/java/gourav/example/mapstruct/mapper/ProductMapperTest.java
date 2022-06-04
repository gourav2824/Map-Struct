package gourav.example.mapstruct.mapper;

import gourav.example.mapstruct.model.Product;
import gourav.example.mapstruct.model.ProductDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductMapperTest {

    @Test
    void testProductToProductDtoWithMinimalFields() {
        ProductMapper mapper = Mappers.getMapper(ProductMapper.class);
        Product product = new Product();
        product.setId(100);
        product.setName("MacBook Pro");

        ProductDTO productDTO = mapper.productToProductDTO(product);

        assertThat(productDTO.getId()).isEqualTo(product.getId());
        assertThat(productDTO.getName()).isEqualTo(product.getName());
    }
}
