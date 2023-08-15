package com.prakash.ProjectJpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class StudentConfiguration {

	@Bean("address-service-webclient")
	public WebClient webClient() {
		return WebClient.builder().build();
	}
	
}
