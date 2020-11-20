package com.example.ProjectDemo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ProjectDemo.Model.Department;
import com.example.ProjectDemo.Service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptSer;
	
	@GetMapping("/hierarchy/department")
	public String showpage(Model model, @RequestParam(defaultValue = "0") int page) {
		model.addAttribute("data", deptSer.display(page));
		model.addAttribute("currentpage", page);
		return "department";
	}

	@GetMapping("/department/findOne")
	@ResponseBody
	public Optional<Department> findOne(@RequestParam Integer id) {
		return deptSer.findbyID(id);
	}

	@GetMapping("/department/delete")
	public String deleteCountry(@RequestParam Integer id) {
		deptSer.deletebyID(id);
		return "redirect:/";
	}

	@PostMapping(path = "/department/save", consumes = "application/x-www-form-urlencoded")
	public String saveCountry(Department c) {
		deptSer.save(c);
		return "redirect:/";
	}

}
