package com.paultamayo.transaction.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.paultamayo.transaction.domains.AccountingMovement;
import com.paultamayo.transaction.to.AccountingMovementTo;

@Component
public class AccountingMovementMapper {

	public AccountingMovementTo convertTo(AccountingMovement movement) {
		return AccountingMovementTo.builder().accountNumber(movement.getAccountNumber())
				.finalBalance(movement.getFinalBalance()).initialBalance(movement.getInitialBalance())
				.value(movement.getValue()).build();
	}

	public List<AccountingMovementTo> convertToList(List<AccountingMovement> customers) {
		return customers.stream().map(this::convertTo).toList();
	}
}
