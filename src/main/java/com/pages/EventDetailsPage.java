package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.BaseTest;
import com.common.WebTable;
import com.common.XLUtilities;

public class EventDetailsPage {
	
	@FindBy(xpath="//strong[text()='Event Information']")
	public WebElement eventInfo;
	
	@FindBy(xpath="(//span[@id='consignment-response'])[1]")
	public WebElement consignID;
	
	@FindBy(xpath="(//span[@id='consignment-response'])[2]")
	public WebElement consignResponse;
	
	@FindBy(xpath="//span[@id='consignment-pawb-number']")
	public WebElement consignPawbNo;
	
	@FindBy(xpath="//span[@id='consignment-origin']")
	public WebElement consignOrigin;
	
	@FindBy(xpath="//span[@id='consignment-event']")
	public WebElement consignEvent;
	
	@FindBy(xpath="//span[@id='consignment-event-date']")
	public WebElement consignEventDate;
	
	@FindBy(xpath="//span[@id='partner-origin-qualifier']")
	public WebElement partnerQualifier;
	
	@FindBy(xpath="//span[@id='partner-ID-origin-code']")
	public WebElement partnerIDCode;
	
	@FindBy(xpath="//span[@id='partner-ID-origin-name']")
	public WebElement partnerIDName;
	
	@FindBy(xpath="//span[@id='handover-location-code']")
	public WebElement handoverLocCode;
	
	@FindBy(xpath="//span[@id='handover-location-name']")
	public WebElement handoverLocName;
	
	
	
	public EventDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	WebTable wt=new WebTable();
	XLUtilities ul=new XLUtilities();
	
	public void data() {
		//ul.getvalueFromxcell(sFileName, sSheetName, testCaseName, columnId);
	}

	public void getspecificrow(String columnText,String rowText,String columnText2,String columnText3) {
		
		int rowindex = wt.getrowindex(columnText,rowText);
		int headindex1 = wt.getheaderindex(columnText);
		int headindex2 = wt.getheaderindex(columnText2);
		int headindex3 = wt.getheaderindex(columnText3);
		
		WebElement row1 = BaseTest.driver.findElement(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/tbody/tr["+rowindex+"]/td["+headindex1+"]"));
		WebElement row2 = BaseTest.driver.findElement(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/tbody/tr["+rowindex+"]/td["+headindex2+"]"));
		WebElement row3 = BaseTest.driver.findElement(By.xpath("//section/h3[text()='Event Information']/following-sibling::table/tbody/tr["+rowindex+"]/td["+headindex3+"]"));
		System.out.println(row1.getText()+" :row1");
		System.out.println(row2.getText()+" :row2");
		System.out.println(row3.getText()+" :row3");
		if(row1.getText().equals("PRECON(14)")) {
			System.out.println("entered first if");
			if((row2.getText().equals("PRECON"))&&(row3.getText().equals("N/A"))){
				System.out.println("PRECON working validated");
			}
			else {
				System.out.println("PRECON not working properly");
			}
		}else if(row1.getText().contains("CARDIT")) {
			if((row2.getText().equals("CREATED"))&&(row3.getText().equals("N/A"))){
				System.out.println("CARDIT working validated");
			}
			else {
				System.out.println("CARDIT not working properly");
			}
		}else if(row1.getText().contains("En route (31)")) {
			if((row2.getText().equals("ENROUTE"))&&(row3.getText().equals("N/A"))){
				System.out.println("ENROUTE working validated");
			}
			else {
				System.out.println("ENROUTE not working properly");
			}
		}else if(row1.getText().contains("Received (74)")) {
			if((row2.getText().equals("HANDOVER ON TIME"))&&(row3.getText().equals("FULL"))){
				System.out.println("Received working validated");
			}
			else {
				System.out.println("Received not working properly");
			}
		}else if(row1.getText().contains("Delivered (21)")) {
			if((row2.getText().equals("DELIVERED ON TIME"))&&(row3.getText().equals("FULL"))){
				System.out.println("DELIVERED working validated");
			}
			else {
				System.out.println("DELIVERED not working properly");
			}
		}else if(row1.getText().contains("N/A")) {
			if((row2.getText().equals("RECEIVED ON TIME"))&&(row3.getText().equals("FULL"))){
				System.out.println("RECEIVED working validated");
			}
			else {
				System.out.println("RECEIVED not working properly");
			}
		}
		
	}
	
}
