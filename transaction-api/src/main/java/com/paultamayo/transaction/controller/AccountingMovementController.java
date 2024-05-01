package com.paultamayo.transaction.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paultamayo.commons.controllers.BaseController;
import com.paultamayo.transaction.domains.AccountingMovement;
import com.paultamayo.transaction.services.AccountingMovementService;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("movimentos")
@RequiredArgsConstructor
@RestController
@Slf4j
public class AccountingMovementController extends BaseController<AccountingMovement, Long> {

	@Getter(value = AccessLevel.PROTECTED)
	private final AccountingMovementService service;

	@Override
	public Logger getLogger() {
		return log;
	}
}
