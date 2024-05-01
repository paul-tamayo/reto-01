package com.paultamayo.transaction.domains;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name = "accounting_movement")
public class AccountingMovement implements Serializable {

	private static final long serialVersionUID = -8658192018818470058L;

	@Column(name = "account_number")
	private Long accountNumber;

	private Boolean enabled;

	@Column(name = "final_balance")
	private BigDecimal finalBalance;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "initial_balance")
	private BigDecimal initialBalance;

	private BigDecimal value;
}
