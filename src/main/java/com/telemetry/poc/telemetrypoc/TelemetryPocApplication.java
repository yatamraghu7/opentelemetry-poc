package com.telemetry.poc.telemetrypoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class TelemetryPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelemetryPocApplication.class, args);
	}

}
