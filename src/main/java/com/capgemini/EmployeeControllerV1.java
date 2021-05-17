package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Employee;
import com.capgemini.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee/v1/")
public class EmployeeControllerV1 {

	@Autowired
	private EmployeeRepository eR;

	@GetMapping("/create")
	public String create(String name, String email, String mobile) {
		Employee e = new Employee();
		e.setName(name);
		e.setEmail(email);
		e.setMobile(mobile);

		eR.save(e);
		return "Employee v1 is created";
	}
	
	@GetMapping("/create2")
	public String create2(Employee e) {
		eR.save(e);
		return "Employee v1 is Created2";
	}
	
	@GetMapping("find/{id}")
	public Employee findById(@PathVariable int id) {
		Employee e = eR.findById(id).get();
		return e;
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Employee iD) {
		
		Employee emp = eR.findById(id).get();
		if(emp != null) {
			emp.setEmail(iD.getEmail());
			emp.setName(iD.getName());
			
			eR.save(emp);
		}
		return "Employee v1 is updated";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Employee e = eR.findById(id).get();
		eR.delete(e);
		return "employee v1 is deleted";
	}
}