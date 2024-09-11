package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.Status;


public class ReadExcel extends BaseClass{
	 private String filePath;
	    private XSSFWorkbook workbook;
	    private XSSFSheet sheet;

	    public ReadExcel() {
	        this.filePath = System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\Book1.xlsx";
	        try {
	            FileInputStream fis = new FileInputStream(new File(filePath));
	            workbook = new XSSFWorkbook(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Get total number of rows
	    public int getRowCount(String sheetName) {
	        sheet = workbook.getSheet(sheetName);
	        return sheet.getPhysicalNumberOfRows();
	    }

	    // Get data from a specific cell
	    public String getCellData(String sheetName, int rowNum, int colNum) {
	        sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNum);
	        Cell cell = row.getCell(colNum);
	        DataFormatter formatter = new DataFormatter();  // Format cell as string
	        return formatter.formatCellValue(cell);
	    }

	    // Close the workbook
	    public void closeWorkbook() {
	        try {
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
