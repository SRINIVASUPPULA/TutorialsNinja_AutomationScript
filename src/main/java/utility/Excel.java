package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excel {

	// This method will read and return Excel data into a double array
	@DataProvider(name = "account-test-data")
	public static HashMap<String, String> get() throws IOException, InvalidFormatException {
		File filename = new File(
				System.getProperty("user.dir") + "\\resources\\testdata\\TutorialsNinjaAccountCreationData.xlsx");

		// Create a file input stream to read Excel workbook and worksheet
		FileInputStream xlfile = new FileInputStream(filename);
		HSSFWorkbook xlwb = new HSSFWorkbook(xlfile);
		HSSFSheet xlSheet = xlwb.getSheetAt(0);

		// Get the number of rows and columns
		int numRows = xlSheet.getLastRowNum() + 1;
		int numCols = xlSheet.getRow(0).getLastCellNum();

		XSSFWorkbook wb = new XSSFWorkbook(filename);
		XSSFSheet sh = wb.getSheet("ValidData");

		HashMap<String, String> dataMap = new HashMap<String, String>();

		for (int r = 0; r <= sh.getLastRowNum(); r++) {
			String column = sh.getRow(r).getCell(0).getStringCellValue();
			String value = sh.getRow(r).getCell(1).getStringCellValue();
			dataMap.put(column, value);
		}

		for (String name : dataMap.keySet()) {
			String key = name.toString();
			String value = dataMap.get(name).toString();
			System.out.println(key + " " + value);
		}

		return dataMap;
	}
}