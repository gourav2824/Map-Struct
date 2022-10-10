package gourav.example.mapstruct.mapper;

import gourav.example.mapstruct.model.City;
import gourav.example.mapstruct.model.Dimension;
import gourav.example.mapstruct.model.Price;
import gourav.example.mapstruct.model.PriceDTO;
import gourav.example.mapstruct.model.Product;
import gourav.example.mapstruct.model.ProductDTO;
import gourav.example.mapstruct.model.ProductStatus;
import gourav.example.mapstruct.model.ProductType;
import gourav.example.mapstruct.model.Status;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.ValueMapping;

import java.util.List;
import java.util.Objects;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    @Mapping(target = "id", source = "id", defaultValue = "0")
    @Mapping(target = "name", source = "name", defaultValue = "Undefined")
    @Mapping(target = "entity", constant = "Product")
    @Mapping(target = "color", source = "colour")
    @Mapping(target = ".", source = "weight")
    @Mapping(target = "label", source = ".")
    @Mapping(target = "country", source = "city.country")
    @Mapping(target = "size.dimensions", source = "productDimensions")
    @Mapping(target = "type.productType", source = "type")
    @Mapping(target = "productCode", expression = "java(product.getId() + product.getName() + product.getProductCode())")
    @Mapping(target = "dimensionsCount", source = "productDimensions", qualifiedByName = "countDimensions")
    @Mapping(target = "price", ignore = true)
    ProductDTO productToProductDTO(Product product);

    @ValueMapping(source = "Health Care", target = "Health_Care")
    @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "Other")
    ProductType typeToProductType(String type);

    @ValueMapping(source = "UNDEFINED", target = "UNKNOWN")
    ProductStatus statusToProductStatus(Status status);

    PriceDTO mapPriceDtoFromPriceAndCity(Price price, City city);

    @Named("countDimensions")
    default int getDimensionsCount(List<Dimension> productDimensions) {
        return Objects.nonNull(productDimensions) ? productDimensions.size() : 0;
    }

    @AfterMapping
    default void removeWhitespacesFromProductCode(@MappingTarget ProductDTO productDTO) {
        String productCode = productDTO.getProductCode().replaceAll("\\s", "");
        productDTO.setProductCode(productCode);
    }

    @AfterMapping
    default void mapPriceDTO(@MappingTarget ProductDTO productDTO, Product product) {
        productDTO.setPrice(mapPriceDtoFromPriceAndCity(product.getPrice(), product.getCity()));
    }
}
