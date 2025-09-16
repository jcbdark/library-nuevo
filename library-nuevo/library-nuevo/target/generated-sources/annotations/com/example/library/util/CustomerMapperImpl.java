package com.example.library.util;

import com.example.library.dto.CustomerDTO;
import com.example.library.entity.Customer;
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
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO.CustomerDTOBuilder customerDTO = CustomerDTO.builder();

        customerDTO.id( customer.getId() );
        customerDTO.name( customer.getName() );
        customerDTO.email( customer.getEmail() );
        customerDTO.phone( customer.getPhone() );
        customerDTO.address( customer.getAddress() );

        return customerDTO.build();
    }

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( customerDTO.getId() );
        customer.name( customerDTO.getName() );
        customer.email( customerDTO.getEmail() );
        customer.phone( customerDTO.getPhone() );
        customer.address( customerDTO.getAddress() );

        return customer.build();
    }

    @Override
    public List<CustomerDTO> toDTOs(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( toDTO( customer ) );
        }

        return list;
    }

    @Override
    public List<Customer> toEntities(List<CustomerDTO> customerDTOs) {
        if ( customerDTOs == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( customerDTOs.size() );
        for ( CustomerDTO customerDTO : customerDTOs ) {
            list.add( toEntity( customerDTO ) );
        }

        return list;
    }
}
