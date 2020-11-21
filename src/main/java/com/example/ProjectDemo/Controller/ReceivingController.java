package com.example.ProjectDemo.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProjectDemo.Excel.ReceivingExcelGenerator;
import com.example.ProjectDemo.Model.Receiving;
import com.example.ProjectDemo.Service.ReceivingService;

@Controller
public class ReceivingController {
	
	@Autowired
	private ReceivingService ReceivingSer;

	@GetMapping("/receiving")
	public String DisplayUsers(Model model, @RequestParam(defaultValue = "0") int page) {
		model.addAttribute("receiving", ReceivingSer.display(page));
		model.addAttribute("currentpage", page);
		return "receiving";
	}

	@GetMapping(value = "/receiving/download")
	public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
		List<Receiving> receiving = (List<Receiving>) ReceivingSer.exportData();

		ByteArrayInputStream in = ReceivingExcelGenerator.customersToExcel(receiving);
		// return IOUtils.toByteArray(in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=receiving.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

}
