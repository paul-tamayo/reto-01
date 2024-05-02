package com.paultamayo.transaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class FeignConfig {
	@Bean
	Decoder decoder() {
		return new JacksonDecoder();
	}

	@Bean
	Encoder encoder() {
		return new JacksonEncoder();
	}
}
