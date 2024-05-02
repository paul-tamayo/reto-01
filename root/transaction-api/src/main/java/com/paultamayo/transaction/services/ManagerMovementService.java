package com.paultamayo.transaction.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.paultamayo.commons.exception.ServiceException;
import com.paultamayo.transaction.actions.MovementEntry;
import com.paultamayo.transaction.actions.MovementOutput;
import com.paultamayo.transaction.client.CustomerClient;
import com.paultamayo.transaction.domains.Account;
import com.paultamayo.transaction.domains.AccountingMovement;
import com.paultamayo.transaction.mapper.AccountingMovementMapper;
import com.paultamayo.transaction.services.entities.AccountService;
import com.paultamayo.transaction.services.entities.AccountingMovementService;
import com.paultamayo.transaction.to.CustomerTo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ManagerMovementService {

	private final AccountService accountService;

	private final CustomerClient customerClient;

	private final AccountingMovementMapper mapper;

	private final AccountingMovementService movementService;

	public List<MovementOutput> generateAccountState(Long clientId, LocalDate start, LocalDate end)
			throws ServiceException {
		CustomerTo customer = customerClient.findBy(clientId).data();

		if (Objects.isNull(customer)) {
			throw new ServiceException("No se ha podido identificar el cliente ingresado.");
		} else if ("1".compareTo(customer.getEnabled()) != 0) {
			throw new ServiceException("El cliente no esta activo.");
		}

		List<Account> accounts = accountService.findByCustomerId(clientId);
		List<MovementOutput> movements = new ArrayList<>(accounts.size());

		for (Account account : accounts) {
			if (accountService.existsById(account.getNumber())) {
				List<AccountingMovement> movs = movementService
						.findByAccountNumberAndBetweenCreated(account.getNumber(), start.minusDays(1), end.plusDays(1));
				if (Objects.nonNull(movs) && !movs.isEmpty()) {
					movements.add(MovementOutput.builder().numberAccount(account.getNumber())
							.movements(mapper.convertToList(movs)).build());
				}
			}
		}

		return movements;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = ServiceException.class)
	public Long registerMovement(MovementEntry entry) throws ServiceException {
		Long movementId = null;

		if (accountService.existsById(entry.numberAccount())) {
			Account account = accountService.findById(entry.numberAccount());

			BigDecimal balance = account.getBalance().add(entry.value());
			if (balance.compareTo(BigDecimal.ZERO) >= 0) {
				accountService.updateBalance(entry.numberAccount(), balance);

				AccountingMovement movement = AccountingMovement.builder().accountNumber(entry.numberAccount())
						.created(LocalDate.now()).enabled("1").finalBalance(balance)
						.initialBalance(account.getBalance()).value(entry.value()).build();
				movementService.saveMandatory(movement);
				movementId = movement.getId();
			} else {
				throw new ServiceException("SALDO NO DISPOINIBLE.");
			}
		} else {
			throw new ServiceException("LA CUENTA NO EXISTE.");
		}

		return movementId;
	}
}
