package com.example.ProjectDemo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ProjectDemo.Model.ItemMaster;
import com.example.ProjectDemo.Service.ItemMasterService;

@Controller
public class ItemMasterController {

	@Autowired
	private ItemMasterService itemMasterSer;

	@GetMapping("/itemMaster")
	public String display(Model model, @RequestParam(defaultValue = "0") int page) {
		model.addAttribute("data", itemMasterSer.display(page));
		model.addAttribute("currentpage", page);
		return "itemMaster";
	}
	
	@GetMapping("/itemMaster/findOne")
	@ResponseBody
	public Optional<ItemMaster> findOne(@RequestParam String id) {
		return itemMasterSer.findbyID(id);
	}

	@GetMapping("/itemMaster/delete")
	public String deleteCountry(@RequestParam String id) {
		itemMasterSer.deletebyID(id);
		return "redirect:/itemMaster";
	}

	@PostMapping(path = "/itemMaster/save", consumes = "application/x-www-form-urlencoded")
	public String saveCountry(ItemMaster c) {
		itemMasterSer.save(c);
		return "redirect:/itemMaster";
	}


}
