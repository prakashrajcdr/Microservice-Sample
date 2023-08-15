package com.prakash.ProjectJpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prakash.ProjectJpa.entity.AddressDetail;
import com.prakash.ProjectJpa.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	public AddressDetail getAddressDetailById(Integer id) {
		System.out.println("Getting address for employee " + id);
		return addressRepository.findById(id).orElse(null);
	}

}
