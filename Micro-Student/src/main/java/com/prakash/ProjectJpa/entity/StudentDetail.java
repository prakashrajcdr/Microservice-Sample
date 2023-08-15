package com.prakash.ProjectJpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student_detail")
@Data
public class StudentDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stud_id")
	private Integer id;
	
	@Column(name = "stud_name")
	private String name;
	
	@Column(name = "stud_department")
	private String department;
	
}
