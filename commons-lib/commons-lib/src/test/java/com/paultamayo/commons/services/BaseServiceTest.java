package com.paultamayo.commons.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import com.paultamayo.commons.Demo;
import com.paultamayo.commons.DemoBaseService;
import com.paultamayo.commons.exception.ServiceException;

@ExtendWith(MockitoExtension.class)
class BaseServiceTest {

	@Mock
	private JpaRepository<Demo, Long> repository;

	@InjectMocks
	private DemoBaseService service;

	@BeforeEach
	void init() {
		service = new DemoBaseService(repository);
	}

	@Test
	void test_existsById() {
		when(repository.existsById(anyLong())).thenReturn(true);

		boolean flag = service.existsById(50L);

		assertTrue(flag);
	}

	@Test
	void test_deleteById() throws ServiceException {
		Long id = 1234567L;

		doNothing().when(repository).deleteById(anyLong());

		long flag0 = service.deleteById(id);

		assertEquals(flag0, id);

		long flag1 = service.deleteMandatoryById(id);
		assertEquals(flag1, id);

	}

	@Test
	void test_findAll() throws ServiceException {
		List<Demo> demos = List.of();

		when(repository.findAll()).thenReturn(demos);

		List<Demo> flag = service.findAll();

		assertNotNull(flag);
	}

	@Test
	void test_findAllByIdWithException() throws ServiceException {
		List<Long> ids = List.of(1l, 2l, 3l, 4l);
		List<Demo> demos = List.of();

		when(repository.findAllById(anyIterable())).thenReturn(demos);

		assertThrows(ServiceException.class, () -> service.findAllById(ids));
	}

	@Test
	void test_findAllById() throws ServiceException {
		List<Long> ids = List.of(1l);
		List<Demo> demos = List.of(new Demo());

		when(repository.findAllById(anyIterable())).thenReturn(demos);

		List<Demo> flag = service.findAllById(ids);

		assertNotNull(flag);
		assertEquals(1, flag.size());
	}

	@Test
	void test_findByIdWithException() throws ServiceException {
		when(repository.findById(anyLong())).thenReturn(Optional.empty());

		assertThrows(ServiceException.class, () -> service.findById(1l));
	}

	@Test
	void test_findById() throws ServiceException {
		Optional<Demo> demos = Optional.of(new Demo());

		when(repository.findById(anyLong())).thenReturn(demos);

		Demo flag = service.findById(1l);

		assertNotNull(flag);
	}

	@Test
	void test_findOptionalById() throws ServiceException {
		Optional<Demo> demos = Optional.of(new Demo());

		when(repository.findById(anyLong())).thenReturn(demos);

		Optional<Demo> flag = service.findOptionalById(1l);

		assertNotNull(flag);
		assertTrue(flag.isPresent());
	}

	@Test
	void test_save() throws ServiceException {
		Demo demos = Demo.builder().id(1l).build();

		when(repository.save(any())).thenReturn(demos);

		Demo flag = service.save(new Demo());

		assertNotNull(flag);
	}

	@Test
	void test_saveMandatory() throws ServiceException {
		Demo demos = Demo.builder().id(1l).build();

		when(repository.save(any())).thenReturn(demos);

		Demo flag = service.saveMandatory(new Demo());

		assertNotNull(flag);
	}

	@Test
	void test_saveMandatoryAll() throws ServiceException {
		Demo demos = Demo.builder().id(1l).build();

		when(repository.saveAll(anyIterable())).thenReturn(List.of(demos));

		List<Demo> flag = service.saveMandatoryAll(List.of(new Demo()));

		assertNotNull(flag);
		assertEquals(1, flag.size());
	}

}
