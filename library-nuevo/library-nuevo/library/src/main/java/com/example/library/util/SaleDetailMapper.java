package com.example.library.util;

import com.example.library.dto.SaleDetailDTO;
import com.example.library.entity.SaleDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface SaleDetailMapper {

    // Entity -> DTO
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    SaleDetailDTO toDTO(SaleDetail saleDetail);

    // DTO -> Entity
    @Mapping(source = "productId", target = "product.id")
    SaleDetail toEntity(SaleDetailDTO saleDetailDTO);
}
