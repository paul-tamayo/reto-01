package com.paultamayo.customer.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

	@GetMapping(value = "/")
	public ResponseEntity<Map<String, String>> index() {
		return ResponseEntity.ok(Map.of("UP", "HomeController - Index"));
	}
}
