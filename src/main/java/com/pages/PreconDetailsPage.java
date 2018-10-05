package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreconDetailsPage {

	@FindBy(xpath="//h3[text()='Transport Information']")
	public WebElement preconTransInfo;
	
	@FindBy(xpath="//span[@id='consignment-Number']")
	public WebElement preconConsignNo;
	
	@FindBy(xpath="//span[contains(@id,'ConsignmentCompletionDate')]")
	public WebElement preconConsignCompletionDate;
	
	@FindBy(xpath="//span[contains(@id,'consignment-Category')]")
	public WebElement preconConsignCategory;
	
	@FindBy(xpath="//td[contains(@ng-bind,'transportModeDesc')]")
	public WebElement transportModeDesc;
	
	@FindBy(xpath="//td[contains(@ng-bind,'conveyanceReferenceNo')]")
	public WebElement preconConveyanceReferenceNo;
	
	@FindBy(xpath="//td[contains(@ng-bind,'carrierCode')]")
	public WebElement preconCarrierCode;
	
	@FindBy(xpath="//td[contains(@ng-bind,'departureLocationCode')]")
	public WebElement preconDepartureLocationCode;
	
	@FindBy(xpath="//td[contains(@ng-bind,'arrivalLocationCode')]")
	public WebElement preconArrivalLocationCode;
	
	@FindBy(xpath="//td[contains(@ng-bind,'transportDepartureDateTime')]")
	public WebElement preconTransportDepartureDT;
	
	@FindBy(xpath="//td[contains(@ng-bind,'transportArrivalDateTime')]")
	public WebElement preconTransportArrivalDT;
	
	
	public PreconDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
