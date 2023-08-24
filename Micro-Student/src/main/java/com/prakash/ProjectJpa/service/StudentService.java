package com.prakash.ProjectJpa.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.prakash.ProjectJpa.FeignClient.AddressDetailAPI;
import com.prakash.ProjectJpa.entity.StudentDetail;
import com.prakash.ProjectJpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressDetailAPI addressDetailAPI;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	@Qualifier(value = "address-service-webclient")
	WebClient webClient;
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getStudentDetailById(Integer id) {
		
		
		Map<String, Object> res = new HashMap<>();
		StudentDetail studentDetail = studentRepository.findById(id).orElse(null);
		
//		Map<String, Object> addRes = addressDetailAPI.getAddressDetailById(id);
		
		// we can get the service instance manually -  loadbalancer provide service Instance by round robin 
		ServiceInstance serviceInstance = loadBalancerClient.choose("address-service"); // should be an address-service application name
		String uri = serviceInstance.getUri().toString();
		String contextPath = serviceInstance.getMetadata().get("contextPath");
		System.out.println("serviceInstance uri + contextPath - " + uri + contextPath);

		Map<String, Object> addRes = null;
		
		// using web client
//		addRes = webClient
//					.get()
//					.uri(uri + contextPath + "/getAddress/" + id)
//					.retrieve()
//					.bodyToMono(HashMap.class)
//					.block();
		
		// using feign client - eureka has loadbalancer inside
		addRes = addressDetailAPI.getAddressDetailById(id);
		
		res.put("studentDetail", studentDetail);
		res.put("addressDetail", addRes);
		
		return res;
	}
}
