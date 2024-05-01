package com.paultamayo.commons.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import com.paultamayo.commons.Demo;
import com.paultamayo.commons.DemoBaseService;

@ExtendWith(MockitoExtension.class)
class BaseServiceTest {

	@Mock
	private JpaRepository<Demo, Long> repository;

	@InjectMocks
	private DemoBaseService service;

	@BeforeEach
	public void init() {
		service = new DemoBaseService(repository);
	}

	@Test
	void test_existsById() {
		when(repository.existsById(anyLong())).thenReturn(true);

		boolean flag = service.existsById(50L);

		assertTrue(flag);
	}

}
