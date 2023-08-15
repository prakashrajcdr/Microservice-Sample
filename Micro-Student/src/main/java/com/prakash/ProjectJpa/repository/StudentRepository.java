package com.prakash.ProjectJpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prakash.ProjectJpa.entity.StudentDetail;

@Repository
public interface StudentRepository extends CrudRepository<StudentDetail, Integer> {

}
