package com.prakash.ProjectJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // creates the Marker Bean
public class MicroDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroDiscoveryServiceApplication.class, args);
	}

}
