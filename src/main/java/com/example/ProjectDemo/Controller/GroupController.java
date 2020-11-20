package com.example.ProjectDemo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ProjectDemo.Model.Grp;
import com.example.ProjectDemo.Service.GroupService;

@Controller
public class GroupController {
	
	@Autowired
	private GroupService groupSer;
	
	@GetMapping("/group")
	public String showpage(Model model, @RequestParam(defaultValue = "0") int page) {
		model.addAttribute("data", groupSer.display(page));
		model.addAttribute("currentpage", page);
		return "group";
	}

	@GetMapping("/group/findOne")
	@ResponseBody
	public Optional<Grp> findOne(@RequestParam Integer id) {
		return groupSer.findbyID(id);
	}

	@GetMapping("/group/delete")
	public String deleteCountry(@RequestParam Integer id) {
		groupSer.deletebyID(id);
		return "redirect:/group";
	}

	@PostMapping(path = "/group/save", consumes = "application/x-www-form-urlencoded")
	public String saveCountry(Grp c) {
		groupSer.save(c);
		return "redirect:/group";
	}

}
