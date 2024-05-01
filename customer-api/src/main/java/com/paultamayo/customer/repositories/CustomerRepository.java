package com.paultamayo.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paultamayo.customer.domains.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
