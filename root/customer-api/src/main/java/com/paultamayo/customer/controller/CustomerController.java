package com.paultamayo.customer.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paultamayo.commons.controllers.BaseController;
import com.paultamayo.commons.services.BaseService;
import com.paultamayo.customer.domains.Customer;
import com.paultamayo.customer.services.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("clientes")
@RequiredArgsConstructor
@RestController
@Slf4j
public class CustomerController extends BaseController<Customer, Long> {

	
	private final CustomerService service;

	@Override
	public Logger getLogger() {
		return log;
	}
	
	@Override
	protected BaseService<Customer, Long> getService() {	
		return service;
	}

}
