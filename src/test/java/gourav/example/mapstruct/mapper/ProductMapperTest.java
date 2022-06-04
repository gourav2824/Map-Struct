package gourav.example.mapstruct.mapper;

import gourav.example.mapstruct.model.Product;
import gourav.example.mapstruct.model.ProductDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductMapperTest {

    @Test
    void testProductToProductDTO() {
        ProductMapper mapper = Mappers.getMapper(ProductMapper.class);
        Product product = new Product();
        product.setId(1);
        product.setName("MacBook Pro");

        ProductDTO productDTO = mapper.productToProductDTO(product);

        System.out.println(productDTO);
        assertThat(productDTO.getId()).isEqualTo(product.getId());
        assertThat(productDTO.getName()).isEqualTo(product.getName());
    }
}
