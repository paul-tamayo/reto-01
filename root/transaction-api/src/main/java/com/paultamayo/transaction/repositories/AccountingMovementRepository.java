package com.paultamayo.transaction.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paultamayo.transaction.domains.AccountingMovement;

public interface AccountingMovementRepository extends JpaRepository<AccountingMovement, Long>, Serializable {

	List<AccountingMovement> findByCreatedBetweenAndAccountNumber(LocalDate start, LocalDate end, Long accountNumber);
}
