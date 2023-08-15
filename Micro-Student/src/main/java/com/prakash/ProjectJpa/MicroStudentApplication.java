package com.prakash.ProjectJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories(basePackages = {"com.prakash.ProjectJpa"})
@EnableDiscoveryClient
public class MicroStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroStudentApplication.class, args);
	}

}
