package com.paultamayo.transaction.actions;

import java.io.Serializable;
import java.util.List;

import com.paultamayo.transaction.to.AccountingMovementTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class MovementOutput implements Serializable {

	private static final long serialVersionUID = -1359440657124707746L;

	private Long numberAccount;

	private List<AccountingMovementTo> movements;
}
