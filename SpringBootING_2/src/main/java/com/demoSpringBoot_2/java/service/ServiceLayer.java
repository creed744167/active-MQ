package com.demoSpringBoot_2.java.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceLayer {


	private final RestTemplate restTemp;
	
	public ServiceLayer(RestTemplate restTemp) {
		this.restTemp=restTemp;
	}
	
    
	public String useAPI() {
		return restTemp.getForObject("http://localhost:9091/menue", String.class);
	}
	
}

