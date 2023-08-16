package main;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class value2 {


	@DataProvider(name="2ndpage")
//	public String[][] getDatas() throws Exception{
		public static void main(String[] args) throws Exception {
				
		File excelFiles = new File("C:\\Users\\Lokesh.Khati\\eclipse-workspace\\TataAiaAutomation\\Data\\Datss.xlsx");
		FileInputStream fiss = new FileInputStream(excelFiles);
		XSSFWorkbook workbooks = new XSSFWorkbook(fiss);
		XSSFSheet sheet2 = workbooks.getSheet("Sheet2");
		int noOfrows1 = sheet2.getPhysicalNumberOfRows();
		int noOfCols1 = sheet2.getRow(0).getLastCellNum();
		String[][] datas = new String[noOfrows1-1][noOfCols1];
		for(int l=0; l<noOfrows1-1; l++) {
			for(int m=0; m<noOfCols1; m++) {
				DataFormatter df = new DataFormatter();
				datas[l][m] = df.formatCellValue(sheet2.getRow(l+1).getCell(m)); 
	//			for(String[] dataArrs : datas) {
	//		    System.out.println(Arrays.toString(dataArrs));}	
				System.out.println(datas[l][m] + datas[l][m].getClass().getSimpleName());
	
			}	
		}
//	return datas;
	}
}

