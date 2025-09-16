package com.example.library.util;

import com.example.library.dto.SaleDTO;
import com.example.library.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, SaleDetailMapper.class})
public interface SaleMapper {

    // Entity -> DTO
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "customer.name", target = "customerName")
    SaleDTO toDTO(Sale sale);

    // DTO -> Entity
    @Mapping(source = "customerId", target = "customer.id")
    Sale toEntity(SaleDTO saleDTO);
}
