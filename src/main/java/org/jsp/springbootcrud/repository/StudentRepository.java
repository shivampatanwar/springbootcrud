package org.jsp.springbootcrud.repository;

import java.util.List;

import org.jsp.springbootcrud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	List<Student> findByEmail(String email);
	
	List<Student> findByMobile(long mobile);
	
	List<Student> findByPhysics(double physics);
	
	List<Student> findByChemistry(double chemistry);
	
	List<Student> findByMathematics(double mathematics);
	
	List<Student> findByName(String name);
	
}
