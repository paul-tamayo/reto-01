package com.paultamayo.customer.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.paultamayo.customer.domains.Customer;
import com.paultamayo.customer.tos.CustomerTo;

@Mapper
public interface CustomerMapper {

	@Mapping(source = "address", target = "address")
	@Mapping(source = "fullname", target = "fullname")
	@Mapping(source = "id", target = "id")
	@Mapping(source = "phoneNumber", target = "phoneNumber")
	CustomerTo convertTo(Customer customer);

	List<CustomerTo> convertToList(List<Customer> customers);
}
