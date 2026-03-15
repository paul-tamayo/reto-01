package com.paultamayo.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("Ruta original: " + exchange.getRequest().getPath());
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			System.out.println("Respuesta del microservicio: " + exchange.getResponse().getStatusCode());
		}));
	}
}