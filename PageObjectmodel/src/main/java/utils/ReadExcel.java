package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String[][] readExcel(String fileName) throws IOException {

		XSSFWorkbook wBook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet wSheet = wBook.getSheet("Sheet1");
		int rowCount = wSheet.getLastRowNum();
		int colCount = wSheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow wRow = wSheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell wCell = wRow.getCell(j);
				String value = wCell.getStringCellValue();
				data[i - 1][j] = value;
			}
		}

		return data;

	}

}
