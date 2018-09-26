package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.IConstantValues;
import com.common.Lib;

public class ConsignmentSummaryPage implements IConstantValues{
	
	@FindBy(xpath="//h3[contains(.,'Current Status: ')]//span")
	public WebElement currentStatus;
	
	@FindBy(xpath="//a[contains(.,'PRECON Details')]")
	public WebElement preconDetails;
	
	@FindBy(xpath="//a[contains(.,'Consignment Details')]")
	public WebElement consignmentDetails;
	
	@FindBy(xpath="//td[contains(@ng-bind,'handoverOriginCutoffDateTime')]")
	public WebElement handoverOriginCutOffDT;
	
	@FindBy(xpath="//td[contains(@ng-bind, 'handoverDestCutoffDateTime ')]")
	public WebElement handoverDestCutOffDT;
	
	@FindBy(xpath="//strong[text()='Consignment Information']")
	public WebElement consignmentInformation;
	
	
	public ConsignmentSummaryPage(WebDriver driver){
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	 public String getConsignmentInfoText() {
 		 return consignmentInformation.getText();
 		  
 	 }
	
	public void clickPreconDetails() {
		preconDetails.click();
	}
	
	public void clickConsignDetails() {
		consignmentDetails.click();
	}
	public String getCurrentStatus(int k, int j) {
  	  String expectedCurrentStatus = Lib.getCellValue(EXCEL_PATH,"consignmentsummary",k,j);
  	  return expectedCurrentStatus;
    }

	
	
}
