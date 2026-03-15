package com.paultamayo.customer.services;

import org.springframework.stereotype.Service;

import com.paultamayo.commons.services.BaseService;
import com.paultamayo.customer.domains.Customer;
import com.paultamayo.customer.repositories.CustomerRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerService extends BaseService<Customer, Long> {

	private static final long serialVersionUID = 2275533959341234672L;

	@Getter
	private final CustomerRepository repository;

}
