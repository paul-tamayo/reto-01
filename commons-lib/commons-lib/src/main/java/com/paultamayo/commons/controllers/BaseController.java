package com.paultamayo.commons.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.paultamayo.commons.helpers.ApiModel;
import com.paultamayo.commons.services.BaseService;

public abstract class BaseController<T, K> {

	protected abstract Logger getLogger();

	protected abstract BaseService<T, K> getService();

	@DeleteMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/{id}")
	public ResponseEntity<ApiModel<K>> delete(@PathVariable("id") K id) {
		return ControllerUtil.response(getLogger(), () -> getService().deleteById(id));
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/findAll")
	public ResponseEntity<ApiModel<List<T>>> findAll() {
		return ControllerUtil.response(getLogger(), () -> getService().findAll());
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/{id}")
	public ResponseEntity<ApiModel<T>> findBy(@PathVariable("id") K id) {
		return ControllerUtil.response(getLogger(), () -> getService().findById(id));
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel<T>> save(@RequestBody T entry) {
		return ControllerUtil.response(getLogger(), () -> getService().save(entry));
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel<T>> update(@RequestBody T entry) {
		return ControllerUtil.response(getLogger(), () -> getService().save(entry));
	}
}
