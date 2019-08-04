package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelHelper {
	public static Object[][] exelHelper(int index) throws IOException {
		Object obj[][] = null;
		File fil = new File("D:\\AUTOMATION\\Maven Project\\FreeCRM\\src\\main\\java\\testdata\\crmtestdata.xlsx");
		FileInputStream fis = new FileInputStream(fil);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(index);
		String sheetname = sh.getSheetName();
		System.out.println("Sheet Name :--> "+sheetname);
		int rowcount = sh.getLastRowNum();
		System.out.println("total number of row :--> " + rowcount);
		int columncount = sh.getRow(0).getLastCellNum();
		System.out.println("total number of column :--> " + columncount);
		
		obj= new Object[rowcount][columncount];
		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < columncount; j++) {
				obj[i][j] = sh.getRow(i+1).getCell(j).toString();
			}
		}

		return obj;
	}

	public static void main(String args[]) throws IOException {
		exelHelper(0);
	}
}
