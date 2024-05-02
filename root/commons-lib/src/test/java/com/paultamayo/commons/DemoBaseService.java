package com.paultamayo.commons;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paultamayo.commons.services.BaseService;

import lombok.Generated;
import lombok.Getter;

@Generated
public class DemoBaseService extends BaseService<Demo, Long> {

	private static final long serialVersionUID = 6841993321242043062L;

	@Getter
	public JpaRepository<Demo, Long> repository;

	public DemoBaseService(JpaRepository<Demo, Long> repository) {
		this.repository = repository;
	}

}
