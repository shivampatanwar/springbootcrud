package org.jsp.springbootcrud.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Student {

	
	@Id
	@GeneratedValue(generator = "x")
	@SequenceGenerator(initialValue = 1001, allocationSize = 1, name = "x")
	private int id;
	
	
	private String name;
	private long mobile;
	private String email;
	private double physics;
	private double chemistry;
	private double mathematics;
	
	

}
