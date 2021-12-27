package com.activemq.java.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {

	   @Value("${activemq.broker-url}")//url of activeMQ server
	    private String brokerUrl;

	    @Bean
	    public Queue queue() {
	        return new ActiveMQQueue("standalone.queue");//activeMQ implementation
	    }

	    @Bean
	    public ActiveMQConnectionFactory activeMQConnectionFactory() {//active MQ factory with broker url(going to connect to activeMQinstance running on server)
	        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
	        factory.setBrokerURL(brokerUrl);//url of activeMQ server
	        return factory;
	    }

	    @Bean
	    public JmsTemplate jmsTemplate() {//as we have created our own connection factory 
	        return new JmsTemplate(activeMQConnectionFactory());//to push messages to the broker
	    }
}
