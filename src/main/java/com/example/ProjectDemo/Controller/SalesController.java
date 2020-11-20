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

import com.example.ProjectDemo.Excel.SalesExcelGenerator;
import com.example.ProjectDemo.Model.salesDemo;
import com.example.ProjectDemo.Service.SalesService;

@Controller
public class SalesController {

	@Autowired
	private SalesService salesSer;

	@GetMapping("/sales")
	public String DisplayUsers(Model model, @RequestParam(defaultValue = "0") int page) {
		model.addAttribute("sales", salesSer.display(page));
		model.addAttribute("currentpage", page);
		return "sales";
	}

	@GetMapping(value = "/download")
	public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
		List<salesDemo> sales = (List<salesDemo>) salesSer.exportData();

		ByteArrayInputStream in = SalesExcelGenerator.customersToExcel(sales);
		// return IOUtils.toByteArray(in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=sales.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

}
