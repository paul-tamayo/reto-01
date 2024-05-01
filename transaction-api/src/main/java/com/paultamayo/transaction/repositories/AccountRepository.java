package com.paultamayo.transaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paultamayo.transaction.domains.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
