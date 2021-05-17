package com.capgemini;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department/")
public class DepartmentController {

	@GetMapping("/create")
	public String create() {
		return "dept created ";
	}

	@GetMapping("/update")
	public String update() {
		return "dept updated";
	}
}
