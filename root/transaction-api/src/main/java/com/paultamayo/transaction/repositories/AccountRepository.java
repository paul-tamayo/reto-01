package com.paultamayo.transaction.repositories;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.paultamayo.transaction.domains.Account;

public interface AccountRepository extends JpaRepository<Account, Long>, Serializable {

	List<Account> findByCustomerId(Long customerId);

	@Modifying
	@Query(value = "UPDATE Account a SET a.balance = :newBalance WHERE a.number = :numberAccount")
	int updateBalance(Long numberAccount, BigDecimal newBalance);
}
