package com.example.library.services;

import com.example.library.dto.SaleDTO;

import java.util.List;

public interface SaleService {

    SaleDTO createSale(SaleDTO saleDTO);

    SaleDTO getSaleById(Long id);

    List<SaleDTO> getAllSales();

    void deleteSale(Long id);
}