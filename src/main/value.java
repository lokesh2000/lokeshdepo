package main;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class value {
	@DataProvider(name="lead")
	public String[][] getData() throws Exception{
////		public static void main(String[] args) throws Exception {
			File excelFile = new File("C:\\Users\\Lokesh.Khati\\eclipse-workspace\\TataAiaAutomation\\Data\\Datss.xlsx");
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int noOfrows = sheet.getPhysicalNumberOfRows();
			int noOfCols = sheet.getRow(0).getLastCellNum();
			
			String[][] data = new String[noOfrows-1][noOfCols];
				for(int i=0; i<noOfrows-1; i++) {
					for(int j=0; j<noOfCols; j++) {
						DataFormatter df = new DataFormatter();
						data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j)); 
//						for(String[] dataArr : data) {
//					    System.out.println(Arrays.toString(dataArr));}	
//						}
					}
				}
				workbook.close();
				fis.close();
				return data;				
	}
}