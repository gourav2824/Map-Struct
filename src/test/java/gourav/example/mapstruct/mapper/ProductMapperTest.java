package gourav.example.mapstruct.mapper;

import gourav.example.mapstruct.model.City;
import gourav.example.mapstruct.model.Dimension;
import gourav.example.mapstruct.model.Price;
import gourav.example.mapstruct.model.Product;
import gourav.example.mapstruct.model.ProductDTO;
import gourav.example.mapstruct.model.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;

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

    @Test
    void shouldMapDimensionsCount() {
        Product product = getProductWithMinimalFields();
        Dimension dim1 = new Dimension(1, "Width", 1920);
        Dimension dim2 = new Dimension(2, "Height", 1080);
        product.setProductDimensions(Arrays.asList(dim1, dim2));

        ProductDTO productDTO = mapper.productToProductDTO(product);

        assertThat(productDTO.getDimensionsCount()).isEqualTo(product.getProductDimensions().size());
    }

    @Test
    void shouldBeAbleToMapOtherProductType() {
        Product product = getProductWithMinimalFields();
        product.setType("Equipment");

        ProductDTO productDTO = mapper.productToProductDTO(product);

        assertThat(productDTO.getType().getProductType()).isEqualTo(ProductType.Other);
        assertThat(productDTO.getType().getCode()).isNull();
    }

    @Test
    void shouldBeAbleToMapHealthCareProductType() {
        Product product = getProductWithMinimalFields();
        product.setType("Health Care");

        ProductDTO productDTO = mapper.productToProductDTO(product);

        assertThat(productDTO.getType().getProductType()).isEqualTo(ProductType.Health_Care);
        assertThat(productDTO.getType().getCode()).isNull();
    }

    private Product getProductWithMinimalFields() {
        Product product = new Product();
        product.setId(100);
        product.setName("MacBook_Pro");
        return product;
    }

    private Price getPrice() {
        Price price = new Price();
        price.setAmount(1_50_000);
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
