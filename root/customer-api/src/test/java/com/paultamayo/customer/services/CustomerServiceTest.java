package com.paultamayo.customer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.paultamayo.commons.exception.ServiceException;
import com.paultamayo.customer.domains.Customer;
import com.paultamayo.customer.repositories.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@Mock
	private CustomerRepository repository;

	@InjectMocks
	private CustomerService service;

	@BeforeEach
	void init() {
		service = new CustomerService(repository);
	}

	@Test
	void test_existsById() {
		when(repository.existsById(anyLong())).thenReturn(true);

		boolean flag = service.existsById(50L);

		assertTrue(flag);
	}

	@Test
	void test_findAll() throws ServiceException {
		List<Customer> demos = List.of();

		when(repository.findAll()).thenReturn(demos);

		List<Customer> flag = service.findAll();

		assertNotNull(flag);
	}

	@Test
	void test_findAllById() throws ServiceException {
		List<Long> ids = List.of(1l);
		List<Customer> demos = List.of(new Customer());

		when(repository.findAllById(anyIterable())).thenReturn(demos);

		List<Customer> flag = service.findAllById(ids);

		assertNotNull(flag);
		assertEquals(1, flag.size());
	}

	@Test
	void test_findAllByIdWithException() throws ServiceException {
		List<Long> ids = List.of(1l, 2l, 3l, 4l);
		List<Customer> demos = List.of();

		when(repository.findAllById(anyIterable())).thenReturn(demos);

		assertThrows(ServiceException.class, () -> service.findAllById(ids));
	}

	@Test
	void test_findById() throws ServiceException {
		Optional<Customer> demos = Optional.of(new Customer());

		when(repository.findById(anyLong())).thenReturn(demos);

		Customer flag = service.findById(1l);

		assertNotNull(flag);
	}

	@Test
	void test_findByIdWithException() throws ServiceException {
		when(repository.findById(anyLong())).thenReturn(Optional.empty());

		assertThrows(ServiceException.class, () -> service.findById(1l));
	}

	@Test
	void test_findOptionalById() throws ServiceException {
		Optional<Customer> demos = Optional.of(new Customer());

		when(repository.findById(anyLong())).thenReturn(demos);

		Optional<Customer> flag = service.findOptionalById(1l);

		assertNotNull(flag);
		assertTrue(flag.isPresent());
	}

	@Test
	void test_save() throws ServiceException {
		Customer demos = Customer.builder().id(1l).build();

		when(repository.save(any())).thenReturn(demos);

		Customer flag = service.save(new Customer());

		assertNotNull(flag);
	}

	@Test
	void test_saveMandatory() throws ServiceException {
		Customer demos = Customer.builder().id(1l).build();

		when(repository.save(any())).thenReturn(demos);

		Customer flag = service.saveMandatory(new Customer());

		assertNotNull(flag);
	}

	@Test
	void test_saveMandatoryAll() throws ServiceException {
		Customer demos = Customer.builder().id(1l).build();

		when(repository.saveAll(anyIterable())).thenReturn(List.of(demos));

		List<Customer> flag = service.saveMandatoryAll(List.of(new Customer()));

		assertNotNull(flag);
		assertEquals(1, flag.size());
	}

}
