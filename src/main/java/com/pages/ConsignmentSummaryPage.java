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
	
	@FindBy(xpath="//strong[text()='Handover Information']")
	public WebElement handoverInfo;
	
	@FindBy(xpath="//a[text()='Consignment Summary']")
	public WebElement consignSummary;
	
	
	@FindBy(xpath="//td[contains(@ng-bind,'handoverOriginCutoffDateTime')]")
	public WebElement handoverOriginCutOffDT;
	
	@FindBy(xpath="//td[contains(@ng-bind, 'handoverDestCutoffDateTime ')]")
	public WebElement handoverDestCutOffDT;
	
	@FindBy(xpath="//strong[text()='Consignment Information']")
	public WebElement consignmentInformation;
	
	@FindBy(xpath="//table[@id='tracking-history']/tbody/tr[@ng-repeat='evtData in data.events']/td[4]")
	public WebElement consignStatusCol;
	
	@FindBy(xpath="(//table[@id='tracking-history']/tbody/tr[@ng-repeat='evtData in data.events']/td[4])[1]")
	public WebElement consignStatusFirst;
	
	
	
	//CARDIT Fields
	@FindBy(xpath="//span[@id='ConsignmentDocumentNumber']")
	public WebElement consignNumber;
	
	@FindBy(xpath="//span[@id='ConsignmentCompletionDate']")
	public WebElement consignCompletionDate;
	
	@FindBy(xpath="//span[@id='ConsignmentCategory']")
	public WebElement consignCategory;
	
	@FindBy(xpath="//span[@id='ConsignmentDestination']")
	public WebElement consignDest;
	
	@FindBy(xpath="//td[contains(@ng-bind,'handoverOriginLocationCode')]")
	public WebElement handoverOriginCode;
	
	@FindBy(xpath="//td[contains(@ng-bind,'handoverDestLocationCode')]")
	public WebElement handoverDestCode;
	
	@FindBy(xpath="(//td[contains(@ng-bind,'mailClassDescription')])[1]")
	public WebElement mailDescriptionFirst;
	
	@FindBy(xpath="(//td[contains(@ng-bind,'mailClassDescription')])[2]")
	public WebElement mailDescriptionSecond;
	
	@FindBy(xpath="(//td[contains(@ng-bind,'count')])[1]")
	public WebElement mailCountFirst;
			
	@FindBy(xpath="(//td[contains(@ng-bind,'count')])[2]")
	public WebElement mailCountSecond;
	
	@FindBy(xpath="(//td[contains(@ng-bind,'receptacleweight ')])[1]")
	public WebElement mailWeightFirst;
	
	@FindBy(xpath="(//td[contains(@ng-bind,'receptacleweight ')])[2]")
	public WebElement mailWeightSecond;
	
	@FindBy(xpath="//td[contains(@ng-bind,'transportStageQualifierDesc ')]")
	public WebElement transportQualifier;
	
	@FindBy(xpath="//td[contains(@ng-bind,'conveyanceReferenceNo')]")
	public WebElement conveyanceReferenceNo;
	
	@FindBy(xpath="//td[contains(@ng-bind,'departureLocationCode')]")
	public WebElement departureLocationCode;
	
	@FindBy(xpath="//td[contains(@ng-bind,'arrivalLocationCode')]")
	public WebElement arrivalLocationCode;
	
	@FindBy(xpath="//td[contains(@ng-bind,'transportDepartureDateTime ')]")
	public WebElement transportDepartureDateTime;
	
	@FindBy(xpath="//td[contains(@ng-bind,'transportArrivalDateTime ')]")
	public WebElement transportArrivalDateTime;
	
	@FindBy(xpath="//a[contains(@ng-bind,'eventDescription ')]")
	public WebElement eventDescription;
	
	@FindBy(xpath="(//a[contains(@ng-bind,'eventDescription ')])[1]")
	public WebElement eventDescriptionFirst;
	
	
	@FindBy(xpath="//td[contains(@ng-bind,'eventDateTime ')]")
	public WebElement eventDateTime;
	
	@FindBy(xpath="//td[contains(@ng-bind,'EventStatus')]")
	public WebElement eventStatus;
	
	@FindBy(xpath="//td[contains(@ng-bind,'eventLocation')]")
	public WebElement eventLocation;
			
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
