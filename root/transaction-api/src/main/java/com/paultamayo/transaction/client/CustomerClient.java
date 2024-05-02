package com.paultamayo.transaction.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.paultamayo.commons.helpers.ApiModel;
import com.paultamayo.transaction.to.CustomerTo;

@FeignClient(name = "customer-api", url = "http://localhost:8443/customer/api/")
public interface CustomerClient {

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "clientes/{id}")
	public ApiModel<CustomerTo> findBy(@PathVariable("id") Long id);
}
