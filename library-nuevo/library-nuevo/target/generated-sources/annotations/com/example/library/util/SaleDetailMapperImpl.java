package com.example.library.util;

import com.example.library.dto.SaleDetailDTO;
import com.example.library.entity.Product;
import com.example.library.entity.SaleDetail;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-15T17:09:13-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (OpenLogic)"
)
@Component
public class SaleDetailMapperImpl implements SaleDetailMapper {

    @Override
    public SaleDetailDTO toDTO(SaleDetail saleDetail) {
        if ( saleDetail == null ) {
            return null;
        }

        SaleDetailDTO.SaleDetailDTOBuilder saleDetailDTO = SaleDetailDTO.builder();

        saleDetailDTO.productId( saleDetailProductId( saleDetail ) );
        saleDetailDTO.productName( saleDetailProductName( saleDetail ) );
        saleDetailDTO.id( saleDetail.getId() );
        saleDetailDTO.quantity( saleDetail.getQuantity() );
        saleDetailDTO.price( saleDetail.getPrice() );
        saleDetailDTO.subtotal( saleDetail.getSubtotal() );

        return saleDetailDTO.build();
    }

    @Override
    public SaleDetail toEntity(SaleDetailDTO saleDetailDTO) {
        if ( saleDetailDTO == null ) {
            return null;
        }

        SaleDetail.SaleDetailBuilder saleDetail = SaleDetail.builder();

        saleDetail.product( saleDetailDTOToProduct( saleDetailDTO ) );
        saleDetail.id( saleDetailDTO.getId() );
        if ( saleDetailDTO.getQuantity() != null ) {
            saleDetail.quantity( saleDetailDTO.getQuantity() );
        }
        saleDetail.price( saleDetailDTO.getPrice() );
        saleDetail.subtotal( saleDetailDTO.getSubtotal() );

        return saleDetail.build();
    }

    private Long saleDetailProductId(SaleDetail saleDetail) {
        Product product = saleDetail.getProduct();
        if ( product == null ) {
            return null;
        }
        return product.getId();
    }

    private String saleDetailProductName(SaleDetail saleDetail) {
        Product product = saleDetail.getProduct();
        if ( product == null ) {
            return null;
        }
        return product.getName();
    }

    protected Product saleDetailDTOToProduct(SaleDetailDTO saleDetailDTO) {
        if ( saleDetailDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( saleDetailDTO.getProductId() );

        return product.build();
    }
}
