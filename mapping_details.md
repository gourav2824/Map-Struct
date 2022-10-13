### ProductDTO Attributes Mapping Details from Product Attributes:

<hr>

1. `Integer id`
    * Non-Null
    * Source = `id`
    * Default Value = 0


2. `String name`
    * Non-Null
    * Source = `name`
    * Default Value = Undefined


3. `String description`
    * Source = `description`


4. `String entity`
    * Source = No mapping
    * Constant Value = Product


5. `String productCode`
    * Source = id, name and productCode
    * Value = `id + name + productCode`


6. `String color`
    * Source = `colour`


7. `PriceDTO price`
    1. `int amount`
        * Source = `Price.amount`
    2. `String currency`
        * Source = `Price.currency`
    3. `String countryCode`
        * Source = `City.countryCode`


8. `int weightValue`
    * Source = `Weight.weightValue`


9. `String weightUnit`
    * Source = `Weight.weightUnit`


10. `Label label`
    1. `String labelName`
       * Source = `labelName`
    2. `String labelType`
       * Source = `labelType`


11. `int dimensionsCount`
    * Source = `productDimensions`
    * Value = Size of the `productDimensions` list


12. `Size size`
    1. `List<Dimension> dimensions`
        * Source = `productDimensions`


13. `String country`
    * Source = `City.country`


14. `Type type`
    1. `ProductType productType` (Enum)
        * Source = `String type`
        * Enum mapping details (from `String` type to `Enum` productType)
            1. *Clothing           ->          Clothing*
            2. *Electronics        ->          Electronics*
            3. *Appliances         ->          Appliances*
            4. *Health Care        ->          Health_Care*
            5. *Furniture          ->          Furniture*
            6. *Footwear           ->          Footwear*
            7. *Any other value    ->          Other*
    2. `String code`
        * Source = No mapping


15. `List<String> material`
    * Source = `material`


16. `ProductStatus status` (Enum)
    * Source = `Status status` (Enum)
    * Enum mapping details (from `Status` status to `ProductStatus` status)
        1. *AVAILABLE         ->        AVAILABLE*
        2. *OUT_OF_STOCK      ->        OUT_OF_STOCK*
        3. *UNDEFINED         ->        UNKNOWN*
