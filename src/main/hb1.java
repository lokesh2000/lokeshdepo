package main;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Assert;

public class hb1 { 
	String driverPath = "C:\\Users\\Lokesh.Khati\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exe";
	public WebDriver driver;
	
		@Test(dataProvider ="lead", dataProviderClass=value.class)
			public void test(String firstName,String middleName,String lastName, String gender, String dob, String RS, String pin ,String mob, String email,String add1,String add2, String land , String occupation, String AgeProof,String HighestEdu,String income,String PAN,String Nominie,String nomineerel) throws Exception {
			
		 	System.setProperty("webdriver.firefox.driver", "C:\\\\Users\\\\Lokesh.Khati\\\\Downloads\\\\geckodriver-v0.33.0-win-aarch64\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://sellonlineuat.tataaia.com/wps/PA_TATAAIA_SO/CampaignRedirection?campaign=HB1");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Thread.sleep(3000);
			driver.findElement(By.id("N")).click();
			driver.findElement(By.id("firstName")).sendKeys(firstName);
			driver.findElement(By.id("middleName")).sendKeys(middleName);
			driver.findElement(By.id("lastName")).sendKeys(lastName);
			String gend = "Male";
				if(gender.equalsIgnoreCase(gend)) {
					driver.findElement(By.xpath("//*[@id='leadCampaign.custDetailForm']/div[3]/div[1]/div[2]/div[1]/div/div/div[1]/label[1]")).click();
					}
					else driver.findElement(By.xpath("//*[@id='leadCampaign.custDetailForm']/div[3]/div[1]/div[2]/div[1]/div/div/div[1]/label[2]")).click();
					System.out.println(dob);
			String[] dateParts = dob.split("/");
			String day = dateParts[0]; 
			String month = dateParts[1];
			String year = dateParts[2];
			String dash ="-";
			String db = day+dash+month+dash+year;
			System.out.println(db);
			driver.findElement(By.id("dob")).sendKeys(db);
			driver.findElement(By.id("resident")).click();
			WebElement op1 = driver.findElement(By.xpath("//*[@id='resident']/option[1]"));
			WebElement op2 = driver.findElement(By.xpath("//*[@id='resident']/option[2]"));
			WebElement op3 = driver.findElement(By.xpath("//*[@id='resident']/option[3]"));
			WebElement op4 = driver.findElement(By.xpath("//*[@id='resident']/option[4]"));
			
				String op11 = op1.getText();
				String op22 = op2.getText();
				String op33 = op3.getText();
				String op44 = op4.getText();
				System.out.println(RS);
				
				if(RS.equalsIgnoreCase(op11)){op1.click();} 
					else if (RS.equalsIgnoreCase(op22)) { op2.click();}
						else if(RS.equalsIgnoreCase(op33)) {op3.click();}
							else {op4.click();}
		
		driver.findElement((By.id("zip"))).sendKeys(pin);
//		String[] mparts = mob.split(".");  
//		String m = mparts[0];
		driver.findElement(By.id("mobile")).sendKeys(mob);
		driver.findElement(By.id("email")).sendKeys(email);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='leadCampaign.custDetailForm']/div[4]/div[1]/a")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("add1")).sendKeys(add1);
		driver.findElement(By.id("add2")).sendKeys(add2);
		driver.findElement(By.id("landmark")).sendKeys(land);
		driver.findElement(By.xpath("//*[@id=\'SecondaryleadCampaign.custDetailForm\']/div/div/div[7]/div/a")).click();
		Thread.sleep(3000); 
		driver.findElement(By.id("isNotStaffAssist")).click();
		driver.findElement(By.id("staffCD")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#productDashboardC\\.productDashBoardForm > div:nth-child(6) > div.col-md-7.col-md-pull-5 > div > div > input.btn.btn-default.blue.ng-scope.yes")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\'maxtrixPopup\']/div/div/div/div/div/div[2]/div[2]")).click();
		Select drpCountry = new Select(driver.findElement(By.id("revamp-sisperrOccu")));
		drpCountry.selectByVisibleText(occupation);
		Select drpCount = new Select(driver.findElement(By.xpath("//*[@id=\'personal.quoteForm\']/div/div[5]/div/div/div/div[1]/div/div/select")));
		drpCount.selectByVisibleText(AgeProof);
		Select drpCou = new Select(driver.findElement(By.id("revamp-sisperPropEdu")));
		drpCou.selectByVisibleText(HighestEdu);
		driver.findElement(By.id("revamp-sisperPropIncome")).sendKeys(income);
		driver.findElement(By.xpath("//*[@id=\'personal.quoteForm\']/div/div[5]/div/div/div/div[2]/div[3]/div/div/input")).sendKeys(PAN);
		driver.findElement(By.id("revamp-sisperNomineeName")).sendKeys(Nominie);
		Select drpCo = new Select(driver.findElement(By.id("revamp-sisperrelaNominee")));
		drpCo.selectByVisibleText(nomineerel);
		driver.findElement(By.id("revamp-sisperLeatsDothis")).click();
//		//		driver.close();
	}
}
//		
//			@DataProvider(name="lead")
//			public String[][] getDatas() throws Exception{				
//				File excelFiles = new File("C:\\Users\\Lokesh.Khati\\eclipse-workspace\\TataAiaAutomation\\Data\\Datss.xlsx");
//				FileInputStream fiss = new FileInputStream(excelFiles);
//				XSSFWorkbook workbooks = new XSSFWorkbook(fiss);
//				XSSFSheet sheet2 = workbooks.getSheet("Sheet2");
//				int noOfrows1 = sheet2.getPhysicalNumberOfRows();
//				int noOfCols1 = sheet2.getRow(0).getLastCellNum();
//				String[][] datas = new String[noOfrows1-1][noOfCols1];
//				for(int l=0; l<noOfrows1-1; l++) {
//					for(int m=0; m<noOfCols1; m++) {
//						DataFormatter df = new DataFormatter();
//						datas[l][m] = df.formatCellValue(sheet2.getRow(l+1).getCell(m)); 
//						System.out.println(datas[l][m] + datas[l][m].getClass().getSimpleName());
//					}	
//				}
//			return datas;
//			}	
//		}

	
