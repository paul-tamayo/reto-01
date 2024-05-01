package com.paultamayo.customer.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paultamayo.commons.controllers.ControllerUtil;
import com.paultamayo.commons.helpers.ApiModel;
import com.paultamayo.customer.domains.Customer;
import com.paultamayo.customer.services.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("clientes")
@RequiredArgsConstructor
@RestController
@Slf4j
public class CustomerController {

	private final CustomerService service;

	@DeleteMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/{id}")
	public ResponseEntity<ApiModel<Long>> delete(@PathVariable("id") Long id) {
		return ControllerUtil.response(log, () -> service.deleteById(id));
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/findAll")
	public ResponseEntity<ApiModel<List<Customer>>> findAll() {
		return ControllerUtil.response(log, () -> service.findAll());
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/{id}")
	public ResponseEntity<ApiModel<Customer>> findBy(@PathVariable("id") Long id) {
		return ControllerUtil.response(log, () -> service.findById(id));
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel<Customer>> save(@RequestBody Customer entry) {
		return ControllerUtil.response(log, () -> service.save(entry));
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel<Customer>> update(@RequestBody Customer entry) {
		return ControllerUtil.response(log, () -> service.save(entry));
	}

}
