package com.example.ProjectDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homePageController {

	@RequestMapping("/home")
	public String displayHomePage() {
		return "HomePage";
	}

}
