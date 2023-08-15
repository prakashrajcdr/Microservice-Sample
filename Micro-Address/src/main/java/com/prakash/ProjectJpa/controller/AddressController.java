package com.prakash.ProjectJpa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.ProjectJpa.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@RequestMapping(value = "/getAddress/{id}", method = RequestMethod.GET)
	ResponseEntity<Map<String, Object>> getStudentById(@PathVariable("id") Integer id) {
		
		Map<String, Object> res = new HashMap<>();
		res.put("address", addressService.getAddressDetailById(id));
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
