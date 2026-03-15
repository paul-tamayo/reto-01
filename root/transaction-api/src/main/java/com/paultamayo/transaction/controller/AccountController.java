package com.paultamayo.transaction.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paultamayo.transaction.services.entities.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("cuentas")
@RequiredArgsConstructor
@RestController
@Slf4j
public class AccountController {

	private final AccountService service;

}
