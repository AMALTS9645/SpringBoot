package newDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestC {
	
	@GetMapping("/hello")
	public String getString() {
		return "hello";
	}
	
	@GetMapping("/helloo")
	public String getString2() {
		return "hello2";
	}

}
