package com.example.library.services;

import com.example.library.dto.SaleDTO;
import com.example.library.dto.SaleDetailDTO;
import com.example.library.entity.Customer;
import com.example.library.entity.Product;
import com.example.library.entity.Sale;
import com.example.library.entity.SaleDetail;
import com.example.library.repository.CustomerRepository;
import com.example.library.repository.ProductRepository;
import com.example.library.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public SaleServiceImpl(SaleRepository saleRepository,
                           CustomerRepository customerRepository,
                           ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        // Buscar cliente
        Customer customer = customerRepository.findById(saleDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Crear la venta
        Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setSaleDate(LocalDateTime.now());

        BigDecimal total = BigDecimal.ZERO;

        List<SaleDetail> details = new ArrayList<>();
        for (SaleDetailDTO detailDTO : saleDTO.getDetails()) {
            Product product = productRepository.findById(detailDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            SaleDetail detail = new SaleDetail();
            detail.setProduct(product);
            detail.setQuantity(detailDTO.getQuantity());
            detail.setPrice(product.getPrice());
            detail.setSale(sale);

            BigDecimal subtotal = product.getPrice().multiply(BigDecimal.valueOf(detailDTO.getQuantity()));
            total = total.add(subtotal);

            details.add(detail);
        }

        sale.setDetails(details);
        sale.setTotal(total);

        Sale saved = saleRepository.save(sale);
        return mapToDTO(saved);
    }

    @Override
    public SaleDTO getSaleById(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con id " + id));
        return mapToDTO(sale);
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return saleRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSale(Long id) {
        if (!saleRepository.existsById(id)) {
            throw new RuntimeException("Venta no encontrada con id " + id);
        }
        saleRepository.deleteById(id);
    }

    // === Mappers internos ===
    private SaleDTO mapToDTO(Sale sale) {
        SaleDTO dto = new SaleDTO();
        dto.setId(sale.getId());
        dto.setSaleDate(sale.getSaleDate());
        dto.setTotal(sale.getTotal());

        // Customer
        if (sale.getCustomer() != null) {
            dto.setCustomerId(sale.getCustomer().getId());
            dto.setCustomerName(sale.getCustomer().getName()); // <- llenamos el name
        }

        // Detalles
        List<SaleDetailDTO> details = sale.getDetails().stream().map(detail -> {
            SaleDetailDTO d = new SaleDetailDTO();
            d.setId(detail.getId());
            d.setQuantity(detail.getQuantity());
            d.setPrice(detail.getPrice());

            // Subtotal
            d.setSubtotal(detail.getPrice().multiply(BigDecimal.valueOf(detail.getQuantity())));

            // Producto
            if (detail.getProduct() != null) {
                d.setProductId(detail.getProduct().getId());
                d.setProductName(detail.getProduct().getName()); // <- llenamos el name
            }
            return d;
        }).toList();

        dto.setDetails(details);
        return dto;
    }
}