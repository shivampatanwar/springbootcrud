package org.jsp.springbootcrud.repository;

import org.jsp.springbootcrud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
