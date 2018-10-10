package com.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.common.BaseTest;
import com.common.IConstantValues;
import com.common.Lib;
import com.common.WebTable;
import com.common.XLUtilities;

public class ConsignmentSummaryPage implements IConstantValues{
	
	@FindBy(xpath="//h3[contains(.,'Current Status: ')]/span")
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
	
	@FindBy(xpath="//h3[text()='Event Information']")
	public WebElement eventInfoText;
	
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
	
	WebTable wt=new WebTable();
	XLUtilities ul=new XLUtilities();
	String TestData="TestData";
	String AllOntime="AllOntime";
	String Event_Precon="Event_Precon";
	String Consignment_Status_Precon="Consignment Status_Precon";

	
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
	
public void getspecificrow(String columnText,String columnText2,String columnText3,String rowText1,String rowText2,String rowText3) throws EncryptedDocumentException, InvalidFormatException, IOException {
		boolean result = false;
		int rowindex = wt.getrowindex(columnText,rowText1);
		int headindex1 = wt.getheaderindex(columnText);
		int headindex2 = wt.getheaderindex(columnText2);
		int headindex3 = wt.getheaderindex(columnText3);
		WebElement row1 = BaseTest.driver.findElement(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/tbody/tr["+rowindex+"]/td["+headindex1+"]"));
		WebElement row2 = BaseTest.driver.findElement(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/tbody/tr["+rowindex+"]/td["+headindex2+"]"));
		WebElement row3 = BaseTest.driver.findElement(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/tbody/tr["+rowindex+"]/td["+headindex3+"]"));
		System.out.println(row1.getText()+" :row1");
		System.out.println(row2.getText()+" :row2");
		System.out.println(row3.getText()+" :row3");
		if(row1.getText().equals(rowText1)) {
			System.out.println("entered first if"+rowText1);
			if((row2.getText().equals(rowText2))&&(row3.getText().equals(rowText3))){
				System.out.println(" working validated:"+rowText1);
				result=true;
			}
			else {
				System.out.println("not working properly:"+rowText1);
				//result=false;
			}
		}/*else if(row1.getText().contains(rowText)) {
			if((row2.getText().equals(Consignment_Status_Cardit))&&(row3.getText().equals(Count_Flag_N))){
				System.out.println("CARDIT working validated");
			}
			else {
				System.out.println("CARDIT not working properly");
			}
		}else if(row1.getText().contains(rowText)) {
			if((row2.getText().equals(Consignment_Status_Enroute))&&(row3.getText().equals(Count_Flag_N))){
				System.out.println("ENROUTE working validated");
			}
			else {
				System.out.println("ENROUTE not working properly");
			}
		}else if(row1.getText().contains(rowText)) {
			if((row2.getText().equals(Consignment_Status_Received))&&(row3.getText().equals(Count_Flag_F))){
				System.out.println("Received working validated");
			}
			else {
				System.out.println("Received not working properly");
			}
		}else if(row1.getText().contains(rowText)) {
			if((row2.getText().equals(Consignment_Status_Delivered))&&(row3.getText().equals(Count_Flag_F))){
				System.out.println("DELIVERED working validated");
			}
			else {
				System.out.println("DELIVERED not working properly");
			}
		}else if(row1.getText().contains(rowText)) {
			if((row2.getText().equals(Consignment_Status_NA))&&(row3.getText().equals(Count_Flag_F))){
				System.out.println("RECEIVED working validated");
			}
			else {
				System.out.println("RECEIVED not working properly");
			}
		}*/
		Assert.assertTrue(result);
		
	}
	
}
