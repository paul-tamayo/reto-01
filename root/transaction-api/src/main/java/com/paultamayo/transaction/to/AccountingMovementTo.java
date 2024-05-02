package com.paultamayo.transaction.to;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class AccountingMovementTo implements Serializable {

	private static final long serialVersionUID = -5051603903701558115L;

	private Long accountNumber;

	private BigDecimal finalBalance;

	private BigDecimal initialBalance;

	private BigDecimal value;
}
