package com.paultamayo.transaction.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.paultamayo.commons.exception.ServiceException;
import com.paultamayo.transaction.actions.MovementEntry;
import com.paultamayo.transaction.client.CustomerClient;
import com.paultamayo.transaction.domains.Account;
import com.paultamayo.transaction.domains.AccountingMovement;
import com.paultamayo.transaction.mapper.AccountingMovementMapper;
import com.paultamayo.transaction.services.entities.AccountService;
import com.paultamayo.transaction.services.entities.AccountingMovementService;

@ExtendWith(MockitoExtension.class)
class ManagerMovementServiceTest {

	@Mock
	private AccountService accountService;

	@Mock
	private CustomerClient customerClient;

	@Mock
	private AccountingMovementMapper mapper;

	@Mock
	private AccountingMovementService movementService;

	@InjectMocks
	private ManagerMovementService service;

	@BeforeEach
	void init() {
		service = new ManagerMovementService(accountService, customerClient, mapper, movementService);
	}

	@Test
	void test_registerMovement() throws ServiceException {
		Account account = Account.builder().accountTypeId(1L).balance(BigDecimal.ZERO).customerId(1L).enabled("1")
				.number(12l).build();
		AccountingMovement movement = AccountingMovement.builder().id(54l).build();
		MovementEntry entry = MovementEntry.builder().numberAccount(1l).value(BigDecimal.valueOf(1524)).build();

		when(accountService.existsById(anyLong())).thenReturn(true);
		when(accountService.findById(anyLong())).thenReturn(account);
		when(movementService.saveMandatory(any())).thenReturn(movement);

		Long id = service.registerMovement(entry);

		assertNotNull(id);
		assertEquals(54l, id);
	}

	@Test
	void test_registerMovementWithBalance() throws ServiceException {
		Account account = Account.builder().accountTypeId(1L).balance(BigDecimal.ZERO).customerId(1L).enabled("1")
				.number(12l).build();
		MovementEntry entry = MovementEntry.builder().numberAccount(1l).value(BigDecimal.valueOf(-1524)).build();

		when(accountService.existsById(anyLong())).thenReturn(true);
		when(accountService.findById(anyLong())).thenReturn(account);

		assertThrows(ServiceException.class, () -> service.registerMovement(entry));
	}

	@Test
	void test_registerMovementWithoutAccount() {
		MovementEntry entry = MovementEntry.builder().numberAccount(1l).value(BigDecimal.valueOf(1524)).build();

		when(accountService.existsById(anyLong())).thenReturn(false);

		assertThrows(ServiceException.class, () -> service.registerMovement(entry));
	}

}
