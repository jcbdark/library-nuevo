package com.example.library.util;

import com.example.library.dto.ProductDTO;
import com.example.library.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    // Entity -> DTO (mapear category)
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")


    ProductDTO productToProductDTO(Product product);

    // DTO -> Entity (mapear categoryId)
    @Mapping(source = "categoryId", target = "category.id")
    Product productDTOtoProduct(ProductDTO productDTO);

    // Lista Entity -> Lista DTO
    List<ProductDTO> productsToProductDTOs(List<Product> products);

    // Lista DTO -> Lista Entity
    List<Product> productDTOsToProducts(List<ProductDTO> productDTOs);
}


