package com.example.ProjectDemo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ProjectDemo.Model.Division;
import com.example.ProjectDemo.Service.DivisionSer;

@org.springframework.stereotype.Controller
public class DivisionController {

	@Autowired
	private DivisionSer divisionSer;

	@GetMapping("/")
	public String showpage(Model model, @RequestParam(defaultValue = "0") int page) {
		model.addAttribute("data", divisionSer.display(page));
		model.addAttribute("currentpage", page);
		return "division";
	}

	@GetMapping("/findOne")
	@ResponseBody
	public Optional<Division> findOne(@RequestParam Integer id) {
		return divisionSer.findbyID(id);
	}

	@GetMapping("/delete")
	public String deleteCountry(@RequestParam Integer id) {
		divisionSer.deletebyID(id);
		return "redirect:/";
	}

	@PostMapping(path = "/save", consumes = "application/x-www-form-urlencoded")
	public String saveCountry(Division c) {
		divisionSer.save(c);
		return "redirect:/";
	}

}
