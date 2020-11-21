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

import com.example.ProjectDemo.Model.Receiving;

public class ReceivingExcelGenerator {
	
	public static ByteArrayInputStream customersToExcel(List<Receiving> receive) throws IOException {
		String[] COLUMNs = { "item", "ReceivedQty", "ReceivedDate", "availableSoh" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			Sheet sheet = workbook.createSheet("received");

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

			CellStyle receivedDate = workbook.createCellStyle();
			receivedDate.setDataFormat(creationHelper.createDataFormat().getFormat("dd-mm-yyyy"));

			int rowIdx = 1;
			for (Receiving rec : receive) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(rec.getItem());
				row.createCell(1).setCellValue(rec.getReceivedQty());
				// row.createCell(2).setCellValue(sale.getSalesDate());

				Cell salesdate = row.createCell(2);
				salesdate.setCellValue(rec.getReceivedDate());
				salesdate.setCellStyle(receivedDate);

				row.createCell(3).setCellValue(rec.getAvailableSoh());

			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

}
