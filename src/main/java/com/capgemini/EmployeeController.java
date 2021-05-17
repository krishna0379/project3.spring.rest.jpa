package com.capgemini;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Employee;
import com.capgemini.repository.EmployeeRepository;

//http://localhost:8090/employee
@RestController
@RequestMapping("/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository eR;

	@GetMapping("/create")
	public String create() {
		// logic write here for create

		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();

		System.out.println("Enter the Name:: \n");
		emp.setName(sc.nextLine());

		System.out.println("Enter  Email:: \n");
		emp.setEmail(sc.nextLine());

		System.out.println("Enter Mobile:: \n");
		emp.setMobile(sc.nextLine());
		eR.save(emp);

		System.out.println("Employee data added succesfully..!!");
		sc.close();
		return "Record Added!!";
	}

	@GetMapping("/update")
	public String update() {
		// logic
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID :: \n");
		Employee emp = eR.findById(sc.nextInt()).get();
		if (emp != null) {
			System.out.println("Enter the Name:: ");
			emp.setName(sc.next());
			System.out.println("Enter the Email:: ");
			emp.setEmail(sc.next());

			eR.save(emp);
			sc.close();
		}

		return "Recorded updated..!!>>";
	}

	@GetMapping("/delete")
	public String delete() {
		// logic
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Delete user id :: \n");

		Employee emp = eR.findById(sc.nextInt()).get();
		if (emp != null) {
			eR.deleteById(1);
			System.out.println("database deleted successfully..>>");
		}
		sc.close();

		return "Recorded been deleted ..>>";
	}

}
