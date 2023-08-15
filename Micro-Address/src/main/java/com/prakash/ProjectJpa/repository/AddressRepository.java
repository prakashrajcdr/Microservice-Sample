package com.prakash.ProjectJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prakash.ProjectJpa.entity.AddressDetail;

public interface AddressRepository extends JpaRepository<AddressDetail, Integer> {

}
