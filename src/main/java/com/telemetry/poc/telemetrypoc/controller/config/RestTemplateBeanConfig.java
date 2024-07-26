package com.telemetry.poc.telemetrypoc.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBeanConfig {

	@Bean
	RestTemplate restTemplateBean() {
		return new RestTemplate();
	}

}
