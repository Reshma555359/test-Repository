package com.anz.selenium.cobra.pageObjects;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsRegistryException;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {

	private static WebDriver driver;

	private static void killInstances(String browserName)
	{
		browserName = browserName.trim().toLowerCase();
		System.out.println("<<<=============================================================================>>>");
		try
		{
			Process process = Runtime.getRuntime().exec("tasklist.exe");
			Scanner sc = new Scanner(process.getInputStream());
			while(sc.hasNext())
			{
				String processName = sc.nextLine().trim().split(" ")[0].trim();
				try
				{
					if(processName.equals(browserName+"driver.exe") || processName.equals(browserName+".exe"))
					{
						System.out.println("Killing : "+processName);
						WindowsUtils.killByName(processName);
					}
				}
				catch(WindowsRegistryException wre)
				{
					//System.out.println("==> Problem while managing the registry, OS Version '6.1', regVersion1 = null");
				}
			}
			System.out.println("\t==> Killed all "+browserName+" and "+browserName+"driver instances...");
		}
		catch(Exception e)
		{
			System.out.println("\t==> Error while killing the Process...");
		}
		System.out.println("<<<=============================================================================>>>");
	}

	public static WebDriver setup(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			/*killInstances(browserName);	// Killing the particular browser instances
			try
			{
				System.setProperty("webdriver.chrome.driver","D:\\Cobra_regression\\chromedriver.exe"); 
				Map<String, Object> chromeOptions = new HashMap<String, Object>();
				chromeOptions.put("binary", "D:\\Cobra_regression\\Google\\Chrome\\Application\\chrome.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				//WebDriver driver = new ChromeDriver(capabilities);
				Browser.driver = new ChromeDriver(capabilities);
				Browser.driver.manage().window().maximize();
				System.out.println("driver1="+driver);
			}
			catch(Exception e)
			{
				System.out.println("===>>> Error : "+e);*/
				System.setProperty("webdriver.chrome.driver",
						"C:\\NotBackedUp\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
			//}
		} else if (browserName.equalsIgnoreCase("FF")) {
			File pathToBinary = new File(
					"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();

			// /download folder path code**********
			firefoxProfile.setPreference("browser.download.folderList", 2);
			firefoxProfile.setPreference(
					"browser.download.manager.showWhenStarting", false);
			firefoxProfile.setPreference("browser.download.dir",
					"C:\\NotBackedUp\\EclipseWorkspace\\DownloadReports");
			firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force",
					false);
			firefoxProfile
			.setPreference(
					"browser.helperApps.neverAsk.saveToDisk",
					"application/msword,application/csv,text/csv,application/vnd.ms-excel,application/pdf");
			firefoxProfile.setPreference("pdfjs.disabled", true);
			firefoxProfile.setPreference("xlsjs.disabled", true);
			firefoxProfile.setPreference("csvjs.disabled", true);



			driver = new FirefoxDriver(ffBinary, firefoxProfile);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browserName.equalsIgnoreCase("IE")) {
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities
			.setCapability(
					InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					true);
			capabilities.setCapability("requireWindowFocus", true);

			File file = new File(
					"C:\\NotBackedUp\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		return driver;
	}

	public static WebDriver driver() {
		return driver;
	}

	public static void open(String url) throws Exception {
		driver.get(url);
		Thread.sleep(3000);

	}

	public static void close() {
		driver.quit();
	}

	public static void closeAll() {

		String[] browserEXE = { "chromedriver.exe", "firefox.exe",
		"iexplore.exe" };

		for (String s : browserEXE) {

			WindowsUtils.tryToKillByName(s);

		}

	}

}