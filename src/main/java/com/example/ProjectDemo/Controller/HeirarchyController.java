package com.example.ProjectDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ProjectDemo.Projection.HMaster;
import com.example.ProjectDemo.Service.DivisionService;

@Controller
public class HeirarchyController {

	@Autowired
	private DivisionService divisionSer;

	@RequestMapping("/hierarchy")
	public String demo(Model model) {
		List<HMaster> master = divisionSer.masterdetails();
		model.addAttribute("master", master);
		return "heirarchy";
	}

	@GetMapping("/Heirarchy/division")
	public List<HMaster> DisplayUsers() {

		return divisionSer.masterdetails();
	}

}
