package org.jsp.springbootcrud.controller;

import java.util.List;

import org.jsp.springbootcrud.dto.Student;
import org.jsp.springbootcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/save")
	public String save(ModelMap map) {
		map.put("users", fetchAll(map));
		map.put("save", "save");
		return "home";
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
		Student student = repository.findById(id).get();
		map.put("student", student);
		map.put("abc", student);
		map.put("users", fetchAll(map));
		return "home";
	}

	@PostMapping("/update")
	public String updates(Student student, ModelMap map) {
		repository.save(student);
		map.put("users", fetchAll(map));
		map.put("success", student.getName() + " Record updated Succesfully");
		return "home";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, ModelMap map) {
		map.put("failure", repository.findById(id).get().getName() + " Record Deleted Succesfully");
		repository.deleteById(id);
		map.put("users", fetchAll(map));
		return "home";
	}

	// Find By Id
	@PostMapping("/findbyid")
	public String findbyid(int id, ModelMap map) {

		try {
			Student student = repository.findById(id).get();
			map.put("users", student);
		} catch (Exception e) {
			map.put("failure", " Record Not Found");
		}

		return "home";
	}

	// Find By Email
	@PostMapping("/findbyemail")
	public String findbyemail(String email, ModelMap map) {

		List<Student> student = repository.findByEmail(email);
		if (student.isEmpty()) {
			map.put("failure", " Record Not Found");
		} else {
			map.put("users", student);
		}

		return "home";
	}

	// Find By mobile
	@PostMapping("/findbymobile")
	public String findbymobile(long mobile, ModelMap map) {

		List<Student> student = repository.findByMobile(mobile);
		if (student.isEmpty()) {
			map.put("failure", " Record Not Found");
		} else {
			map.put("users", student);
		}

		return "home";
	}

	// Find By mobile
	@PostMapping("/findbyname")
	public String findbyname(String name, ModelMap map) {

		List<Student> student = repository.findByName(name);
		if (student.isEmpty()) {
			map.put("failure", " Record Not Found");
		} else {
			map.put("users", student);
		}

		return "home";
	}

	// Find By physics
	@PostMapping("/findbyphysics")
	public String findbyphysics(double physics, ModelMap map) {

		List<Student> student = repository.findByPhysics(physics);
		if (student.isEmpty()) {
			map.put("failure", " Record Not Found");
		} else {
			map.put("users", student);
		}

		return "home";
	}

	// Find By Chemistry
	@PostMapping("/findbychemistry")
	public String findbychemistry(double chemistry, ModelMap map) {

		List<Student> student = repository.findByChemistry(chemistry);
		if (student.isEmpty()) {
			map.put("failure", " Record Not Found");
		} else {
			map.put("users", student);
		}

		return "home";
	}
	
	// Find By Chemistry
		@PostMapping("/findbymathematics")
		public String findbymathematics(double mathematics, ModelMap map) {

			List<Student> student = repository.findByMathematics(mathematics);
			if (student.isEmpty()) {
				map.put("failure", " Record Not Found");
			} else {
				map.put("users", student);
			}

			return "home";
		}

}
