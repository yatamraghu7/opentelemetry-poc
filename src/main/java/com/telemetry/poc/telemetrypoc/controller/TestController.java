package com.telemetry.poc.telemetrypoc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.telemetry.poc.telemetrypoc.bean.Employee;

@RestController
public class TestController {

	Logger logger = LogManager.getLogger(TestController.class);

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/hello")
	public String hello() {
		logger.info("Calling another service");
		String response = restTemplate.getForObject("http://localhost:8099/another", String.class);
		logger.info("Received response: {}", response);
		return "Hello World!";
	}

	@GetMapping("/another")
	public String another() {
		logger.info("Another service called");
		return "Hello from another service!";
	}

	@PostMapping("/testSampleData")
	public boolean sampleTest(@RequestBody Employee employee) {
		logger.info("Employee Details Test Service");

		boolean employeeVerified = detailsCheck(employee);

		logger.info("Received response: {}", employeeVerified);
		if (employeeVerified == true) {
			return true;
		}
		return false;
	}

	public boolean detailsCheck(Employee employeeDetails) {
		if (employeeDetails.getName().equalsIgnoreCase("raghu")) {
			if (employeeDetails.getId() == 7) {
				return true;
			}
		}
		return false;
	}

}
