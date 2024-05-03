package com.paultamayo.transaction.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.paultamayo.transaction.actions.MovementOutput;
import com.paultamayo.transaction.services.ManagerMovementService;
import com.paultamayo.transaction.to.AccountingMovementTo;

@AutoConfigureMockMvc
@WebFluxTest(ManagerMovementController.class)
class ManagerMovementControllerTest {

	@Autowired
	private WebTestClient mvc;

	@MockBean
	private ManagerMovementService service;

	@Test
	void test_generateReport() throws Exception {
		AccountingMovementTo a1 = AccountingMovementTo.builder().created(LocalDate.now())
				.finalBalance(BigDecimal.valueOf(100)).initialBalance(BigDecimal.ZERO).value(BigDecimal.valueOf(100))
				.build();
		MovementOutput m1 = MovementOutput.builder().numberAccount(1l).movements(List.of(a1)).build();

		when(service.generateAccountState(anyLong(), any(), any())).thenReturn(List.of(m1));

		mvc.get().uri(u -> u.path("/movimientos/reportes").queryParam("clientId", "1").queryParam("start", "2024-01-01")
				.queryParam("end", "2024-01-30").build()).exchange().expectStatus().isOk();
	}

}
