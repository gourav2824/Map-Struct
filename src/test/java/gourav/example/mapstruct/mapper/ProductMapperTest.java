package gourav.example.mapstruct.mapper;

import gourav.example.mapstruct.model.City;
import gourav.example.mapstruct.model.Price;
import gourav.example.mapstruct.model.Product;
import gourav.example.mapstruct.model.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductMapperTest {

    private ProductMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(ProductMapper.class);
    }

    @Test
    void testProductToProductDtoWithMinimalFields() {
        Product product = getProductWithMinimalFields();

        ProductDTO productDTO = mapper.productToProductDTO(product);

        assertThat(productDTO.getId()).isEqualTo(product.getId());
        assertThat(productDTO.getName()).isEqualTo(product.getName());
    }

    @Test
    void shouldMapPriceAndCityToPriceDTO() {
        Product product = getProductWithMinimalFields();
        product.setPrice(getPrice());
        product.setCity(getCity());

        ProductDTO productDTO = mapper.productToProductDTO(product);

        assertThat(productDTO.getPrice().getAmount()).isEqualTo(product.getPrice().getAmount());
        assertThat(productDTO.getPrice().getCurrency()).isEqualTo(product.getPrice().getCurrency());
        assertThat(productDTO.getPrice().getCountryCode()).isEqualTo(product.getCity().getCountryCode());
    }

    @Test
    void shouldMapProductCode() {
        Product product = getProductWithMinimalFields();
        product.setProductCode(234);

        ProductDTO productDTO = mapper.productToProductDTO(product);

        String expectedProductCode = "100MacBook_Pro234";
        assertThat(productDTO.getProductCode()).isEqualTo(expectedProductCode);
    }

    private Product getProductWithMinimalFields() {
        Product product = new Product();
        product.setId(100);
        product.setName("MacBook_Pro");
        return product;
    }

    private Price getPrice() {
        Price price = new Price();
        price.setAmount(1000);
        price.setCurrency("INR");
        return price;
    }

    private City getCity() {
        City city = new City();
        city.setName("Delhi");
        city.setCountry("India");
        city.setCountryCode("IND");
        return city;
    }
}
