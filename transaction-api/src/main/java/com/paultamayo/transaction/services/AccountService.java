package com.paultamayo.transaction.services;

import org.springframework.stereotype.Service;

import com.paultamayo.commons.services.BaseService;
import com.paultamayo.transaction.domains.Account;
import com.paultamayo.transaction.repositories.AccountRepository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService extends BaseService<Account, Long> {

	private static final long serialVersionUID = 3423075780800560329L;

	@Getter(value = AccessLevel.PROTECTED)
	private final AccountRepository repository;

}
