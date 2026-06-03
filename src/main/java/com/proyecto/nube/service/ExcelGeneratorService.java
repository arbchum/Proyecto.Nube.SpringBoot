package com.proyecto.nube.service;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.proyecto.nube.model.SantanderReportColumn;
import com.proyecto.nube.model.SantanderReportRow;

@Service
public class ExcelGeneratorService {

	public byte[] generate(List<SantanderReportRow> rows) {
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.createSheet("Reporte Santander");

			createHeader(workbook, sheet);
			fillData(sheet, rows);
			autoSizeColumns(sheet);

			workbook.write(outputStream);
			return outputStream.toByteArray();

		} catch (Exception e) {
			throw new RuntimeException("Error generando Excel Santander", e);
		}
	}

	private void createHeader(Workbook workbook, Sheet sheet) {
		Row headerRow = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);

		SantanderReportColumn[] columns = SantanderReportColumn.values();

		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i].getHeader());
			cell.setCellStyle(style);
		}
	}

	private void fillData(Sheet sheet, List<SantanderReportRow> rows) {
		SantanderReportColumn[] columns = SantanderReportColumn.values();

		for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
			Row excelRow = sheet.createRow(rowIndex + 1);
			SantanderReportRow reportRow = rows.get(rowIndex);

			for (int colIndex = 0; colIndex < columns.length; colIndex++) {
				excelRow.createCell(colIndex).setCellValue(reportRow.get(columns[colIndex]));
			}
		}
	}

	private void autoSizeColumns(Sheet sheet) {
		SantanderReportColumn[] columns = SantanderReportColumn.values();

		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
	}
}
