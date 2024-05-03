package com.paultamayo.transaction.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.paultamayo.commons.exception.ServiceException;
import com.paultamayo.commons.helpers.ApiModel;
import com.paultamayo.transaction.actions.MovementOutput;
import com.paultamayo.transaction.services.ManagerMovementService;
import com.paultamayo.transaction.to.AccountingMovementTo;

@ExtendWith(MockitoExtension.class)
class ManagerMovementControllerTest {

	@Mock
	private ManagerMovementService service;

	@InjectMocks
	private ManagerMovementController controller;

	@Test
	void test_generateReport() throws ServiceException {
		AccountingMovementTo a1 = AccountingMovementTo.builder().created(LocalDate.now())
				.finalBalance(BigDecimal.valueOf(100)).initialBalance(BigDecimal.ZERO).value(BigDecimal.valueOf(100))
				.build();
		MovementOutput m1 = MovementOutput.builder().numberAccount(1l).movements(List.of(a1)).build();

		when(service.generateAccountState(anyLong(), any(), any())).thenReturn(List.of(m1));

		ResponseEntity<ApiModel<List<MovementOutput>>> response = controller.generateReport(anyLong(), any(), any());

		assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(200));
	}

}
