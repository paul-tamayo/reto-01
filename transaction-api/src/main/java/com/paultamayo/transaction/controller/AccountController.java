package com.paultamayo.transaction.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paultamayo.commons.controllers.BaseController;
import com.paultamayo.transaction.domains.Account;
import com.paultamayo.transaction.services.entities.AccountService;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("cuentas")
@RequiredArgsConstructor
@RestController
@Slf4j
public class AccountController extends BaseController<Account, Long> {

	@Getter(value = AccessLevel.PROTECTED)
	private final AccountService service;

	@Override
	public Logger getLogger() {
		return log;
	}
}
