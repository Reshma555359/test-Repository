package CommonLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;


public class TestBase {
	
	public static String EXCEL_PATH=".\\TestData\\Credentials.xlsx";
	static{
		System.setProperty("webdriver.gecko.driver", "D:\\testWorkspace\\HybridFramework\\driver\\geckodriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "D:\\testWorkspace\\HybridFramework\\driver\\chromedriver.exe");
	}

	public static WebDriver driver;
	@BeforeClass
	@Parameters({"browser"})
	public void selectBrowser(String browser){
	
		if (browser.equals("chrome")){
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")){
			driver=new FirefoxDriver();
		}
		ReportLog.getlogger();
		ReportLog.logger.info("Browser launched successfully");
		
		String url=Library.getProperty(".\\config.properties", "URL");
		String ITO=Library.getProperty(".\\config.properties", "ImplicitTimeOut");
		int timeoutPeriod=Integer.parseInt(ITO);
		
		driver.get(url);
		System.out.println("1");
		String UserN = Library.getCellValue(EXCEL_PATH,"Easy Login",2,0);
		driver.manage().timeouts().implicitlyWait(timeoutPeriod, TimeUnit.SECONDS);
		String PassW = Library.getCellValue(EXCEL_PATH,"Easy Login",2,1);
		//int rowCount = Library.getRowCount(EXCEL_PATH,"Easy Login");
		//System.out.println(rowCount);
		System.out.println(UserN);
		System.out.println(PassW);
		driver.findElement(By.id("txtLanId")).sendKeys(UserN);
		driver.findElement(By.id("txtPassword")).sendKeys(PassW);
		//Thread.sleep(2000);
		driver.findElement(By.id("btnlogin")).click();
		System.out.println("3");		
	}
	
	public void takeScreeshot(String testname){
		Date d=new Date();
		String currentdate = d.toString().replaceAll(":", "_");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		File destFile=new File(".\\screenshots\\"+currentdate+"\\"+testname+"_screenshot.png");
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public void closeApplication() throws InterruptedException{
		Thread.sleep(4000);
		driver.quit();
	}

}
