package com.pages;


import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.common.BaseTest;
import com.common.XLUtilities;

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
	 
	 //need to optimize webtable xpath
	 public WebElement ReceptacleID(String ReceptacleID2) throws EncryptedDocumentException, InvalidFormatException, IOException {
		 System.out.println("ReceptacleID:"+ReceptacleID2);
		  WebElement element=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+ReceptacleID2+"']"));	
		  System.out.println("entered");
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  System.out.println("inside");
		  wait.until(ExpectedConditions.stalenessOf(element));
		  return element;
	 }

}
