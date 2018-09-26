package com.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.common.IConstantValues;

public class BaseTest implements IConstantValues{
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	public static WebDriver driver;
	@BeforeTest
	@Parameters({"browser"})
	public void selectBrowser(String browser){
		
		if (browser.equals("chrome")){
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")){
			driver=new FirefoxDriver();
		}
		//Calling property method to read URL and launch
		String url=Lib.getProperty(CONFIG_PATH, "URL");
		driver.manage().window().maximize();
		driver.get(url);
		
		String ITO=Lib.getProperty(".\\config.properties", "ImplicitTimeOut");
		int timeoutPeriod=Integer.parseInt(ITO);
		driver.manage().timeouts().implicitlyWait(timeoutPeriod, TimeUnit.SECONDS);
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
	
	public void toSwitchTab(int tabs)  {
		Robot robot;
		try {
			for (int i = 0; i < tabs; i++) {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			Set<String> allWh = driver.getWindowHandles();
			for (String wh : allWh) {
	            System.out.println("ParentWindow="+wh);
	            driver.switchTo().window(wh);
	            System.out.println("Child="+driver.getCurrentUrl());
	}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	@AfterClass
	public void closeApplication()  {
		driver.quit();
	}
}
