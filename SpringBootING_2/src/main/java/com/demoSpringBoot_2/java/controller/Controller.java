package com.demoSpringBoot_2.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demoSpringBoot_2.java.service.ServiceLayer;

@RestController
public class Controller {

	private final ServiceLayer service;

	public Controller(ServiceLayer service) {
		this.service = service;
	}

	@GetMapping("/info")
	public String getData() {
		return service.useAPI();
	}
}
