package com.paultamayo.transaction.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paultamayo.transaction.services.entities.AccountingMovementService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("movimentos")
@RequiredArgsConstructor
@RestController
@Slf4j
public class AccountingMovementController {

	private final AccountingMovementService service;

}
