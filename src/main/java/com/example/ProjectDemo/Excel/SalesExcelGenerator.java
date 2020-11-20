package com.example.ProjectDemo.Excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.ProjectDemo.Model.salesDemo;

public class SalesExcelGenerator {

	public static ByteArrayInputStream customersToExcel(List<salesDemo> sales) throws IOException {
		String[] COLUMNs = { "item", "salesQuantity", "salesDate", "availableSoh" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			Sheet sheet = workbook.createSheet("sales");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			CreationHelper creationHelper = workbook.getCreationHelper();

			CellStyle salesDate = workbook.createCellStyle();
			salesDate.setDataFormat(creationHelper.createDataFormat().getFormat("dd-mm-yyyy"));

			int rowIdx = 1;
			for (salesDemo sale : sales) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(sale.getItem());
				row.createCell(1).setCellValue(sale.getSalesQuantity());
				// row.createCell(2).setCellValue(sale.getSalesDate());

				Cell salesdate = row.createCell(2);
				salesdate.setCellValue(sale.getSalesDate());
				salesdate.setCellStyle(salesDate);

				row.createCell(3).setCellValue(sale.getAvailableSoh());

			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}