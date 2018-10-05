package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
