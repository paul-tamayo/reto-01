package com.paultamayo.customer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paultamayo.customer.services.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("clientes")
@RequiredArgsConstructor
@RestController
@Slf4j
public class CustomerController {

	private final CustomerService service;

}
