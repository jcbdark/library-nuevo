package com.example.library.util;

import com.example.library.dto.CustomerDTO;
import com.example.library.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);

    List<CustomerDTO> toDTOs(List<Customer> customers);
    List<Customer> toEntities(List<CustomerDTO> customerDTOs);
}
