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
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 6887662880401010582L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long number;

	@Column(name = "account_type_id")
	private Long accountTypeId;

	@Column(name = "customer_id")
	private Long customerId;

	private BigDecimal balance;

	private Boolean enabled;
}
