package com.example.library.util;

import com.example.library.dto.SaleDTO;
import com.example.library.dto.SaleDetailDTO;
import com.example.library.entity.Customer;
import com.example.library.entity.Sale;
import com.example.library.entity.SaleDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-15T17:09:13-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (OpenLogic)"
)
@Component
public class SaleMapperImpl implements SaleMapper {

    @Autowired
    private SaleDetailMapper saleDetailMapper;

    @Override
    public SaleDTO toDTO(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        SaleDTO.SaleDTOBuilder saleDTO = SaleDTO.builder();

        saleDTO.customerId( saleCustomerId( sale ) );
        saleDTO.customerName( saleCustomerName( sale ) );
        saleDTO.id( sale.getId() );
        saleDTO.saleDate( sale.getSaleDate() );
        saleDTO.total( sale.getTotal() );
        saleDTO.details( saleDetailListToSaleDetailDTOList( sale.getDetails() ) );

        return saleDTO.build();
    }

    @Override
    public Sale toEntity(SaleDTO saleDTO) {
        if ( saleDTO == null ) {
            return null;
        }

        Sale.SaleBuilder sale = Sale.builder();

        sale.customer( saleDTOToCustomer( saleDTO ) );
        sale.id( saleDTO.getId() );
        sale.saleDate( saleDTO.getSaleDate() );
        sale.total( saleDTO.getTotal() );
        sale.details( saleDetailDTOListToSaleDetailList( saleDTO.getDetails() ) );

        return sale.build();
    }

    private Long saleCustomerId(Sale sale) {
        Customer customer = sale.getCustomer();
        if ( customer == null ) {
            return null;
        }
        return customer.getId();
    }

    private String saleCustomerName(Sale sale) {
        Customer customer = sale.getCustomer();
        if ( customer == null ) {
            return null;
        }
        return customer.getName();
    }

    protected List<SaleDetailDTO> saleDetailListToSaleDetailDTOList(List<SaleDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<SaleDetailDTO> list1 = new ArrayList<SaleDetailDTO>( list.size() );
        for ( SaleDetail saleDetail : list ) {
            list1.add( saleDetailMapper.toDTO( saleDetail ) );
        }

        return list1;
    }

    protected Customer saleDTOToCustomer(SaleDTO saleDTO) {
        if ( saleDTO == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( saleDTO.getCustomerId() );

        return customer.build();
    }

    protected List<SaleDetail> saleDetailDTOListToSaleDetailList(List<SaleDetailDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<SaleDetail> list1 = new ArrayList<SaleDetail>( list.size() );
        for ( SaleDetailDTO saleDetailDTO : list ) {
            list1.add( saleDetailMapper.toEntity( saleDetailDTO ) );
        }

        return list1;
    }
}
