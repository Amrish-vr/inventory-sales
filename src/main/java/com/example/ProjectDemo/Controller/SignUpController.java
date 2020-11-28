package com.example.ProjectDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.ProjectDemo.Model.SignUp;
import com.example.ProjectDemo.Service.SignUpService;

@Controller
public class SignUpController {
	
	@Autowired
	private SignUpService signUpSer;
	
	@GetMapping("/signUp")
	public String signUp() {
		return "signUp";
	}
	
	@PostMapping(path = "/saveusers", consumes = "application/x-www-form-urlencoded")
	public String saveuser(SignUp c) {
		signUpSer.saveUsers(c);
		return "redirect:/Login";
	}

}
