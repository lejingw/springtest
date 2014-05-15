package com.lejingw.apps.poitest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ReadExcelTest {
	@Test
	public void test1() throws InvalidFormatException, IOException {
		InputStream inp = new FileInputStream("test.xlsx");

		Workbook inWorkbook = WorkbookFactory.create(inp);
		Workbook outWorkbook = new XSSFWorkbook();
		
		Sheet inSheet = inWorkbook.getSheetAt(0);
		readContent(inSheet);
		
		Sheet outSheet = outWorkbook.createSheet();
		writeContent(outSheet);

		// Write the output to a file
		File file = new File("output");
		if(!file.exists()){
			file.mkdir();
		}
		FileOutputStream fileOut = new FileOutputStream("output/" + System.nanoTime() + ".xlsx");
		outWorkbook.write(fileOut);
		fileOut.close();
	}

	private void readContent(Sheet sheet) {
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(3);
		System.out.println(cell.getNumericCellValue());
	}

	private void writeContent(Sheet outSheet) {
		Row row = outSheet.getRow(2);
		if(null == row)
			row = outSheet.createRow(2);
		Cell cell = row.getCell(3);
		if (cell == null)
			cell = row.createCell(3);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue("a test");
	}
}
