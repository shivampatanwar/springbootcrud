package org.jsp.springbootcrud.controller;

import java.util.List;

import org.jsp.springbootcrud.dto.Student;
import org.jsp.springbootcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@Autowired
	StudentRepository repository;
	
	@GetMapping("/")
	public String loadHome(ModelMap map) {
		map.put("user", fetchAll(map));
		return "home";
	}

	public List<Student> fetchAll(ModelMap map) {
		List<Student> students = repository.findAll();
		map.put("users", students);
		return students;
	}

	@PostMapping("/save")
	public String save(Student student, ModelMap map) {
		
		repository.save(student);
		
		map.put("users", fetchAll(map));
		map.put("success", student.getName() + " Record added Succesfully");
		
		return "home";
	}

	@GetMapping("/update")
	public String update(int id, ModelMap map) {
		
		Student student=repository.findById(id).get();
		map.put("student", student);
		return "update";
	}
	
	
	@PostMapping("/update")
	public String updates(Student s, ModelMap map) {
		
		Student student=repository.findById(s.getId()).get();
		
		student.setId(s.getId());
		student.setName(s.getName());
		student.setMobile(s.getMobile());
		student.setEmail(s.getEmail());
		student.setPhysics(s.getPhysics());
		student.setChemistry(s.getChemistry());
		student.setMathematics(s.getMathematics());
		
		repository.save(student);
		
		map.put("users", fetchAll(map));
		map.put("success", student.getName() + " Record updated Succesfully");
		return "home";
	}

	@GetMapping("/delete")
	public String delete(int id, ModelMap map) {
		repository.deleteById(id);
		map.put("user", fetchAll(map));
		map.put("success", "Record Deleted Succesfully");
		return "home";
	}

}
