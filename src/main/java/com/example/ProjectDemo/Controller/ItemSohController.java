package com.example.ProjectDemo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ProjectDemo.Model.ItemSoh;
import com.example.ProjectDemo.Service.ItemSohService;

@Controller
public class ItemSohController {
	
	@Autowired
	private ItemSohService itemSohSer;

	@GetMapping("/ItemSoh")
	public String showpage(Model model, @RequestParam(defaultValue = "0") int page) {
		model.addAttribute("data", itemSohSer.display(page));
		model.addAttribute("currentpage", page);
		return "ItemSoh";
	}

	@GetMapping("/ItemSoh/findOne")
	@ResponseBody
	public Optional<ItemSoh> findOne(@RequestParam String id) {
		return itemSohSer.findbyID(id);
	}


	@PostMapping(path = "/ItemSoh/save", consumes = "application/x-www-form-urlencoded")
	public String saveCountry(ItemSoh c) {
		itemSohSer.save(c);
		return "redirect:/ItemSoh";
	}
}
