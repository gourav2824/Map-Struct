package gourav.example.mapstruct.mapper;

import gourav.example.mapstruct.model.City;
import gourav.example.mapstruct.model.Price;
import gourav.example.mapstruct.model.PriceDTO;
import gourav.example.mapstruct.model.Product;
import gourav.example.mapstruct.model.ProductDTO;
import gourav.example.mapstruct.model.ProductStatus;
import gourav.example.mapstruct.model.Status;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.ValueMapping;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    @Mapping(target = "color", source = "colour")
    @Mapping(target = ".", source = "weight")
    @Mapping(target = "country", source = "city.country")
    @Mapping(target = "size.dimensions", source = "productDimensions")
    @Mapping(target = "type.productType", source = "type")
    @Mapping(target = "productCode", expression = "java(product.getId() + product.getName() + product.getProductCode())")
    @Mapping(target = "price", ignore = true)
    ProductDTO productToProductDTO(Product product);

    PriceDTO mapPriceDtoFromPriceAndCity(Price price, City city);

    @ValueMapping(source = "UNDEFINED", target = "UNKNOWN")
    ProductStatus statusToProductStatus(Status status);

    @AfterMapping
    default void setPriceDTO(@MappingTarget ProductDTO productDTO, Product product) {
        productDTO.setPrice(mapPriceDtoFromPriceAndCity(product.getPrice(), product.getCity()));
    }
}
