package com.paultamayo.transaction.services;

import org.springframework.stereotype.Service;

import com.paultamayo.commons.services.BaseService;
import com.paultamayo.transaction.domains.AccountingMovement;
import com.paultamayo.transaction.repositories.AccountingMovementRepository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountingMovementService extends BaseService<AccountingMovement, Long> {

	private static final long serialVersionUID = 9197039424069122807L;

	@Getter(value = AccessLevel.PROTECTED)
	private final AccountingMovementRepository repository;

}
