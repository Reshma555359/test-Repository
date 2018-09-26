package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.BaseTest;

public class ConsignmentDetailsPage extends BaseTest {
	
	//WebDriver driver;
	
	@FindBy(xpath="//a[text()='Consignment Details']")
	public WebElement consignmentDetails;
	
	@FindBy(xpath="//h3[text()='Receptacle Information']")
	public WebElement receptacleInfo;
	

	@FindBy(xpath="//tbody/tr")
	public WebElement receptacleTableBody;
	
	
	 public ConsignmentDetailsPage(WebDriver driver){
         //This initElements method will create all WebElements
         PageFactory.initElements(driver, this);
     }
	 
	 public void clickConsignDetails() {
		 consignmentDetails.click();
	 }
	 
	 public String getreceptacleInfoText() {
		 return receptacleInfo.getText();
	 }
	 public void clickReceptacleID() {
		/* System.out.println("Total R IDs ");
		 int countRIDs = driver.findElements(By.xpath("//tbody//a")).;
		 System.out.println("size "+countRIDs);
		System.out.println("2");
		  //driver.findElement(By.xpath("//thead//th[1]")).getText();
		//receptacleTableBody.getSize();
		String text=driver.findElement(By.xpath("//thead//th[1]")).getText();
		 System.out.println("size"+text);*/
		 try {
			Thread.sleep(5000);
		//	WebElement element = driver.findElement(By.xpath(".//*[@class='container-fluid']"));

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Print count value");
	java.util.List<WebElement> list = driver.findElements(By.xpath(".//*[@id='tracking-history']/thead/tr"));
	

		System.out.println(list.size());
		
		 System.out.println("dfgdf");
		 //receptacleTableBody[1].getText();
	 }

}
