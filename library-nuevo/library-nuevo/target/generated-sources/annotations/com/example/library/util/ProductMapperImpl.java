package com.example.library.util;

import com.example.library.dto.ProductDTO;
import com.example.library.entity.Category;
import com.example.library.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-15T17:09:13-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (OpenLogic)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO.ProductDTOBuilder productDTO = ProductDTO.builder();

        productDTO.categoryId( productCategoryId( product ) );
        productDTO.categoryName( productCategoryName( product ) );
        productDTO.id( product.getId() );
        productDTO.name( product.getName() );
        productDTO.description( product.getDescription() );
        productDTO.price( product.getPrice() );
        productDTO.stock( product.getStock() );

        return productDTO.build();
    }

    @Override
    public Product productDTOtoProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.category( productDTOToCategory( productDTO ) );
        product.id( productDTO.getId() );
        product.name( productDTO.getName() );
        product.description( productDTO.getDescription() );
        product.price( productDTO.getPrice() );
        product.stock( productDTO.getStock() );

        return product.build();
    }

    @Override
    public List<ProductDTO> productsToProductDTOs(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( productToProductDTO( product ) );
        }

        return list;
    }

    @Override
    public List<Product> productDTOsToProducts(List<ProductDTO> productDTOs) {
        if ( productDTOs == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDTOs.size() );
        for ( ProductDTO productDTO : productDTOs ) {
            list.add( productDTOtoProduct( productDTO ) );
        }

        return list;
    }

    private Long productCategoryId(Product product) {
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        return category.getId();
    }

    private String productCategoryName(Product product) {
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        return category.getName();
    }

    protected Category productDTOToCategory(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.id( productDTO.getCategoryId() );

        return category.build();
    }
}
