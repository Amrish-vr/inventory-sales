package com.example.ProjectDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReplenishmentController {

	@GetMapping("/Replenishment")
	public String replenishment () {
		return "Replenishment";
	}
}
