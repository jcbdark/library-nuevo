package com.example.library.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDetailDTO {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subtotal;

    private Long productId;
    private String productName;  // <- aquí se llena con el nombre del producto
}

