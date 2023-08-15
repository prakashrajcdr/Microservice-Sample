package com.prakash.ProjectJpa.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prakash.ProjectJpa.FeignClient.AddressDetailAPI;
import com.prakash.ProjectJpa.entity.StudentDetail;
import com.prakash.ProjectJpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressDetailAPI addressDetailAPI;
	
	
	public Map<String, Object> getStudentDetailById(Integer id) {
		
		Map<String, Object> res = new HashMap<>();
		StudentDetail studentDetail = studentRepository.findById(id).orElse(null);
		Map<String, Object> addRes = addressDetailAPI.getAddressDetailById(id);
		
		res.put("studentDetail", studentDetail);
		res.put("addressDetail", addRes);
		
		return res;
	}
}
