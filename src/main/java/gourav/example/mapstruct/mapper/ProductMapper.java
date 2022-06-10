package gourav.example.mapstruct.mapper;

import gourav.example.mapstruct.model.City;
import gourav.example.mapstruct.model.Price;
import gourav.example.mapstruct.model.PriceDTO;
import gourav.example.mapstruct.model.Product;
import gourav.example.mapstruct.model.ProductDTO;
import gourav.example.mapstruct.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {
    @Mapping(target = "status", ignore = true)
//    @Mapping(target = "price.countryCode", source = "city.countryCode")
    @Mapping(target = "color", source = "colour")
    @Mapping(target = ".", source = "weight")
    @Mapping(target = "country", source = "city.country")
    @Mapping(target = "size.dimensions", source = "productDimensions")
    ProductDTO productToProductDTO(Product product);

//    @Mapping(target = "countryCode", source = ".city.countryCode")
    @Mapping(target = "countryCode", ignore = true)
    PriceDTO priceToPriceDTO(Price price);

//    @Mapping(target = "amount", ignore = true)
//    @Mapping(target = "currency", ignore = true)
//    PriceDTO cityToPriceDTO(City city);

    @Mapping(target = "code", ignore = true)
    @Mapping(target = "productType", source = ".")
    Type typeToProductType(String type);
}
