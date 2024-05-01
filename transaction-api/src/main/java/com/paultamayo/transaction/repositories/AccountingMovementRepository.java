package com.paultamayo.transaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paultamayo.transaction.domains.AccountingMovement;

public interface AccountingMovementRepository extends JpaRepository<AccountingMovement, Long> {

}
