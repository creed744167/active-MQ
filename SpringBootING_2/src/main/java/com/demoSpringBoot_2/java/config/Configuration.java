package com.demoSpringBoot_2.java.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public RestTemplate restTemp() {
		return new RestTemplate();
	}

	  @JmsListener(destination = "standalone.queue")
	    public void consume(String message) {
	        System.out.println("Received Message: " + message);
	    }
}