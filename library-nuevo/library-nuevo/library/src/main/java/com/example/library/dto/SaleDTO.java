package com.example.library.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDTO {
    private Long id;
    private LocalDateTime saleDate;
    private BigDecimal total;
    private Long customerId;
    private String customerName;
    private List<SaleDetailDTO> details;
}
