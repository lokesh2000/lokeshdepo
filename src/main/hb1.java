package main;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Assert;

public class hb1 { 
//	String driverPath = "C:\\Users\\Lokesh.Khati\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exe";
	public WebDriver driver;
	
		@Test(dataProvider ="lead", dataProviderClass=value.class)
			public void test(String firstName,String middleName,String lastName, String gender, String dob, String RS, String pin ,String mob, String email,String add1,String add2, String land , String occupation, String AgeProof,String HighestEdu,String income,String PAN,String Nominie,String nomineerel,String ifsc,String Branch, String reltype, String acc,String fathername,String motherName,String weight,String org,String now,String dobb) throws Exception {
			
//		 	System.setProperty("webdriver.firefox.driver", "C:\\\\Users\\\\Lokesh.Khati\\\\Downloads\\\\geckodriver-v0.33.0-win-aarch64\\\\geckodriver.exe");
//			driver = new FirefoxDriver();
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Lokesh.Khati\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://sellonline.tataaia.com/wps/PA_TATAAIA_SO/CampaignRedirection?campaign=HB1");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Thread.sleep(1000);
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
		
//		driver.findElement((By.id("zip"))).sendKeys(pin);
		Thread.sleep(1000);
		TakesScreenshot scrshot = ((TakesScreenshot)driver);
		File src = scrshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\1.png");
		FileHandler.copy(src, dest);
		Thread.sleep(5000);
		 driver.findElement(By.id("zip")).sendKeys(pin);
//		String[] mparts = mob.split(".");  
//		String m = mparts[0]; 
		driver.findElement(By.id("mobile")).sendKeys(mob);
		driver.findElement(By.id("email")).sendKeys(email);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='leadCampaign.custDetailForm']/div[4]/div[1]/a")).click();
		Thread.sleep(4000);
		try {
			Boolean a = true;
			Boolean t =driver.findElement(By.cssSelector("#alert-box-oldOneinside > p.alert-box-title")).isDisplayed();
			
			if(t.equals(a)) {
				driver.findElement(By.cssSelector("#alert-box-oldOneinside > div > a")).click();
				driver.findElement(By.xpath("//*[@id='leadCampaign.custDetailForm']/div[4]/div[1]/a")).click();
			}
			else {
				System.out.println("no alert occured in sis lead generation page");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		try {
			
		Boolean b = true;
		Boolean r = driver.findElement(By.cssSelector("body > div.alert-wrapper.oldOne > div.alert-box")).isDisplayed();
		if(r.equals(b)) {
					driver.findElement(By.cssSelector("body > div.alert-wrapper.oldOne > div.alert-box > div > a")).click();
					driver.findElement(By.xpath("//*[@id='leadCampaign.custDetailForm']/div[4]/div[1]/a")).click();
			}
		else {
			System.out.println("no alert occured in sis lead generation page");
		}
		}
		catch(Exception e){
			System.out.println(e);
			
		}
//		driver.findElement(By.cssSelector("body > div.alert-wrapper.oldOne > div.alert-box > div > a")).click();
//		driver.findElement(By.xpath("//*[@id='leadCampaign.custDetailForm']/div[4]/div[1]/a")).click();
//		Thread.sleep(3000);
//		if(String a = driver.findElement(By.id("alert-box-oldOneinside"))equals())
//		driver.findElement(By.xpath("//*[@id=\"alert-box-oldOneinside\"]/div/a")).click();
//		if(isAlertPresent(driver)){
//	        Alert alert = driver.switchTo().alert();
//	        System.out.println(alert.getText());
//	        alert.accept();
//	        driver.findElement(By.id("zip")).sendKeys(pin);
//	    }	
//	     try {
//	            driver.findElement(By.id("timerAlertButton")).click();
//	            WebDriverWait wait = new WebDriverWait(driver ,10);
//	            wait.until(ExpectedConditions.alertIsPresent());
//	            Alert simpleAlert = driver.switchTo().alert();
//	            simpleAlert.accept();
//	            System.out.println("Unexpected alert accepted");
//	        } catch (Exception e) {
//	            System.out.println("unexpected alert not present");
//	        }
		
		Thread.sleep(5000);
		//lead extra details
		driver.findElement(By.id("add1")).sendKeys(add1);
		driver.findElement(By.id("add2")).sendKeys(add2);
		driver.findElement(By.id("landmark")).sendKeys(land);
		Thread.sleep(1000);
		TakesScreenshot scrshot1 = ((TakesScreenshot)driver);
		File src1 = scrshot1.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\2.png");
		FileHandler.copy(src1, dest1);
		driver.findElement(By.xpath("//*[@id=\'SecondaryleadCampaign.custDetailForm\']/div/div/div[7]/div/a")).click();
		Thread.sleep(3000); 
		//Product Dashboard
		driver.findElement(By.id("isNotStaffAssist")).click();
		driver.findElement(By.id("staffCD")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#productDashboardC\\.productDashBoardForm > div:nth-child(6) > div.col-md-7.col-md-pull-5 > div > div > input.btn.btn-default.blue.ng-scope.yes")).click();
		Thread.sleep(1000);
		Thread.sleep(1000);
		TakesScreenshot scrshot2 = ((TakesScreenshot)driver);
		File src2 = scrshot2.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\3.png");
		FileHandler.copy(src2, dest2);
		driver.findElement(By.xpath("//*[@id=\'maxtrixPopup\']/div/div/div/div/div/div[2]/div[2]")).click();
		
		//SISPersonal
		
		Select drpCountry = new Select(driver.findElement(By.name("PROPOSER_OCCUPATION")));
		drpCountry.selectByVisibleText(occupation);
		Select drpCount = new Select(driver.findElement(By.name("AGEPROF_DOC_TYPE_PR")));
		drpCount.selectByVisibleText(AgeProof);
		Select drpCou = new Select(driver.findElement(By.name("PRO_EDU_QUALIFICATION")));
		drpCou.selectByVisibleText(HighestEdu);
		driver.findElement(By.name("PROPOSER_ANN_INCOME")).sendKeys(income);
		driver.findElement(By.name("PROPOSER_PAN")).sendKeys(PAN);
		driver.findElement(By.name("PROPOSER_NOMINEE_NAME")).sendKeys(Nominie);
		Select drpCo = new Select(driver.findElement(By.name("PROPOSER_NOMINEE_RELATION")));
		drpCo.selectByVisibleText(nomineerel);
		Thread.sleep(1000);
		TakesScreenshot scrshot3 = ((TakesScreenshot)driver);
		File src3 = scrshot3.getScreenshotAs(OutputType.FILE);
		File dest3 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\4.png");
		FileHandler.copy(src3, dest3);
		driver.findElement(By.cssSelector("#personal\\.quoteForm > div > div.MT50 > a")).click();
		//*[@id="personal.quoteForm"]/div/div[11]/a
		Thread.sleep(10000); 
		
		//SIS calculation Button
		try {
			driver.findElement(By.cssSelector("#indexmaindiv > div > div.primary-sis.ng-scope > form > div > a")).click();
		}
		finally{
		Thread.sleep(1000);
		TakesScreenshot scrshot4 = ((TakesScreenshot)driver);
		File src4 = scrshot4.getScreenshotAs(OutputType.FILE);
		File dest4 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\5.png");
		FileHandler.copy(src4, dest4);
		driver.findElement(By.cssSelector("#main-content > div.sidebar-menu > div.life-cover-box.scrollMenu.displayBlock > p > button")).click();
		//SIS rider buttons
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#indexmaindiv > div > div.primary-sis.ng-scope > form > section > div > div.ques-answer.hospicare-ques-answer.ng-scope > div > div.opt > div > label:nth-child(4)")).click();
		driver.findElement(By.id("skip1")).click();
		//SIS Summary 
		Thread.sleep(1000);
		TakesScreenshot scrshot5 = ((TakesScreenshot)driver);
		File src5 = scrshot5.getScreenshotAs(OutputType.FILE);
		File dest5 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\6.png");
		FileHandler.copy(src5, dest5);
		driver.findElement(By.cssSelector("#indexmaindiv > div > div.primary-sis.ng-scope > section > div > div > div.row.policy-row > div.col-md-6.col-md-push-6.pq-box > p.pq-btn-box > a.btn.btn-default.blue.ng-scope")).click();
		Thread.sleep(4000);
//		driver.findElement(By.cssSelector("body > div.alert-wrapper.oldOne > div.alert-box > div > a")).click();
//		driver.findElement(By.cssSelector("#indexmaindiv > div > div.primary-sis.ng-scope > section > div > div > div.row.policy-row > div.col-md-6.col-md-push-6.pq-box > p.pq-btn-box > a.btn.btn-default.blue.ng-scope")).click();
		
		//policy output
		Thread.sleep(1000);
		TakesScreenshot scrshot6 = ((TakesScreenshot)driver);
		File src6 = scrshot6.getScreenshotAs(OutputType.FILE);
		File dest6 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\7.png");
		FileHandler.copy(src6, dest6);
		driver.findElement(By.cssSelector("#indexmaindiv > section > form > div > div > div > div > div.ng-scope > div.labletxt > label")).click();
		driver.findElement(By.cssSelector("#indexmaindiv > section > form > div > div > div > div > div:nth-child(11) > input")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("body > div.alert-wrapper.oldOne > div.alert-box > div > a")).click();
		Thread.sleep(2000);
		//Payment initial
		driver.findElement(By.cssSelector("#indexmaindiv > div:nth-child(3) > section > div.container-fluid > div.playment-option > ul > li:nth-child(3) > a")).click();
		Thread.sleep(1000);
		TakesScreenshot scrshot7 = ((TakesScreenshot)driver);
		File src7 = scrshot7.getScreenshotAs(OutputType.FILE);
		File dest7 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\8.png");
		FileHandler.copy(src7, dest7);
		driver.findElement(By.cssSelector("#payViaEmail > form > div.tnc-payment.ng-scope > p:nth-child(1) > label > input")).click();
		driver.findElement(By.name("hdfcDisc")).click();
		driver.findElement(By.xpath("//*[@id=\"payViaEmail\"]/form/div[4]/div/a")).click();
		//POlicy Setup
		Thread.sleep(1000);
		TakesScreenshot scrshot8 = ((TakesScreenshot)driver);
		File src8 = scrshot8.getScreenshotAs(OutputType.FILE);
		File dest8 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\9.png");
		FileHandler.copy(src8, dest8);
		driver.findElement(By.id("IfscCode")).sendKeys(ifsc);
		driver.findElement(By.name("branchName")).sendKeys(Branch);
		driver.findElement(By.id("BankAccNo")).sendKeys(acc);
		driver.findElement(By.xpath("//*[@id=\"indexmaindiv\"]/div[2]/section/section/div/div/div/div[2]/form/div/div/div/a")).click();
		driver.findElement(By.cssSelector("body > div.alert-wrapper.oldOne > div.alert-box > div > a")).click();
		//renewal
		Thread.sleep(1000);
		TakesScreenshot scrshot9 = ((TakesScreenshot)driver);
		File src9 = scrshot9.getScreenshotAs(OutputType.FILE);
		File dest9 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\10.png");
		FileHandler.copy(src9, dest9);
		driver.findElement(By.cssSelector("#indexmaindiv > div:nth-child(3) > section > div:nth-child(2) > div.playment-option.ng-scope > ul > li:nth-child(2) > a")).click();
		Select drpCo1 = new Select(driver.findElement(By.name("relType")));
		drpCo1.selectByVisibleText(reltype);//self
		driver.findElement(By.cssSelector("#emailEsi > form > div > div.tnc-payment > p > label > input")).click();
		driver.findElement(By.cssSelector("#emailEsi > form > div > div:nth-child(2) > div > a")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("body > div.alert-wrapper.oldOne > div.alert-box > div > a")).click();
		//PERSONALiNFO
		driver.findElement(By.name("fathHusbName")).sendKeys(fathername);
		driver.findElement(By.name("motherName")).sendKeys(motherName);
		driver.findElement(By.cssSelector("#personalInfo > fieldset > div.ng-scope > div:nth-child(3) > div:nth-child(2) > div.bottom-btn > button")).click();
		Thread.sleep(15000);
		driver.findElement(By.name("Insweight")).sendKeys(weight);
		Thread.sleep(1000);
		TakesScreenshot scrshot10 = ((TakesScreenshot)driver);
		File src10 = scrshot10.getScreenshotAs(OutputType.FILE);
		File dest10 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\11.png");
		FileHandler.copy(src10, dest10);
		driver.findElement(By.id("pscweb")).click();
		driver.findElement(By.cssSelector("#personalInfo > div > div > div > div > button")).click();
		//communication
		Thread.sleep(1000);
		TakesScreenshot scrshot11 = ((TakesScreenshot)driver);
		File src11 = scrshot11.getScreenshotAs(OutputType.FILE);
		File dest11 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\12.png");
		FileHandler.copy(src11, dest11);
		driver.findElement(By.cssSelector("#communication > div > div > div > button.btn.btn-primary")).click();
		//occupation details
		Thread.sleep(1000);
		TakesScreenshot scrshot12 = ((TakesScreenshot)driver);
		File src12 = scrshot12.getScreenshotAs(OutputType.FILE);
		File dest12 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\13.png");
		FileHandler.copy(src12, dest12);
		Select drpCoe = new Select(driver.findElement(By.id("dropdownMenu1")));
		drpCoe.selectByVisibleText(org);
		Select drpCoes = new Select(driver.findElement(By.name("natureOfWork")));
		drpCoes.selectByVisibleText(now);
		driver.findElement(By.cssSelector("#occupationIns > form.ng-pristine.ng-invalid.ng-invalid-required.ng-valid-pattern.ng-valid-maxlength > div > div > div > div > button.btn.btn-primary")).click();
		Thread.sleep(7000);
		//nominee details
		driver.findElement(By.cssSelector("body > div.alert-wrapper.oldOne > div.alert-box > div > a")).click();
		String[] dateParts1 = dobb.split("/");
		String day1 = dateParts[0]; 
		String month1 = dateParts[1];
		String year1 = dateParts[2];
		String dash1 ="-";
		String db1 = day+dash+month+dash+year;
		driver.findElement(By.id("dob0")).sendKeys(db1);
		Thread.sleep(1000);
		TakesScreenshot scrshot13 = ((TakesScreenshot)driver);
		File src13 = scrshot13.getScreenshotAs(OutputType.FILE);
		File dest13 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\14.png");
		FileHandler.copy(src13, dest13);
		driver.findElement(By.cssSelector("#nomineeForm > div > div > div > button.btn.btn-primary")).click();
		Thread.sleep(8000);
		//health1
		Thread.sleep(1000);
		TakesScreenshot scrshot14 = ((TakesScreenshot)driver);
		File src14 = scrshot14.getScreenshotAs(OutputType.FILE);
		File dest14 = new File("C:\\Users\\Lokesh.Khati\\Pictures\\Screenshots\\hb1\\15.png");
		FileHandler.copy(src14, dest14);
		driver.findElement(By.cssSelector("#health-section-1 > div > div > div > button.btn.btn-primary")).click();
		Thread.sleep(12000);
		driver.findElement(By.cssSelector("#health-section-2 > fieldset > div:nth-child(1) > div > div > ul > li > label > span > b:nth-child(1)")).click();
		//driver.close();
		}
		}
//		//		driver.close();

//		private boolean isAlertPresent(WebDriver driver2) {
//			// TODO Auto-generated method stub
//			return false;
//		}
	
		//alert function
		public static boolean isAlertPresent(WebDriver driver){
		      try{
		          driver.switchTo().alert();
		          return true;
		      }catch(NoAlertPresentException ex){
		          return false;
		      }
		}
//		
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

	
