package com.paultamayo.transaction.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.paultamayo.transaction.actions.MovementOutput;
import com.paultamayo.transaction.services.ManagerMovementService;
import com.paultamayo.transaction.to.AccountingMovementTo;

@AutoConfigureMockMvc
@WebMvcTest(ManagerMovementController.class)
class ManagerMovementControllerTest {

	@MockBean
	private ManagerMovementService service;

	@Autowired
	private MockMvc mvc;

	@Test
	void test_generateReport() throws Exception {
		AccountingMovementTo a1 = AccountingMovementTo.builder().created(LocalDate.now())
				.finalBalance(BigDecimal.valueOf(100)).initialBalance(BigDecimal.ZERO).value(BigDecimal.valueOf(100))
				.build();
		MovementOutput m1 = MovementOutput.builder().numberAccount(1l).movements(List.of(a1)).build();

		when(service.generateAccountState(anyLong(), any(), any())).thenReturn(List.of(m1));

		mvc.perform(get("/movimientos/reportes").param("clientId", "1").param("start", "2024-01-01").param("end",
				"2024-01-30")).andDo(print()).andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"));
	}

}
