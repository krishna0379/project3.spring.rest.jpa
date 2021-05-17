package com.capgemini;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	// http://localhost:8090/hello/1
	@GetMapping("/1")
	public String sayHello() {
		return "hello wolrd>>>!!1<<<<";
	}
}
