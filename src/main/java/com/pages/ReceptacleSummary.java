package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReceptacleSummary {
	
	@FindBy(xpath="//strong[text()='Receptacle Details']")
	public WebElement receptacleDetails;
	
	@FindBy(xpath="//tbody/tr[1]/td/a")
	public WebElement event;
	
	//PRECON Information fields
	@FindBy(xpath="//span[contains(@id,'Receptacle-type')]")
	public WebElement preconReceptacleType;
	
	@FindBy(xpath="//span[contains(@id,'Receptacle-ID')]")
	public WebElement preconReceptacleID;
	
	@FindBy(xpath="//span[contains(@id,'receptacle-serial-no')]")
	public WebElement preconReceptacleSerialNo;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-sub-class')])[1]")
	public WebElement preconReceptacleSubClass;
	
	@FindBy(xpath="(//span[contains(@id,'despatch-document-indicator')])[1]")
	public WebElement preconDespatchDocIndi;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-dangerous-goods-indicator')])[1]")
	public WebElement preconRecepDangerGoodsIndi;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-format-of-contents')])[1]")
	public WebElement preconRecepFormatOfContents;
	
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-handling-class')])[1]")
	public WebElement preconRecepHandlingClass;
	
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-express-indicator')])[1]")
	public WebElement preconRecepExpressIndi;
	
	@FindBy(xpath="(//span[contains(@id,'exempt-items-indicator')])[1]")
	public WebElement preconExemptItemsIndi;
	
	@FindBy(xpath="(//span[contains(@id,'receptacle-weight-type')])[1]")
	public WebElement preconRecepWeightType;
	
	@FindBy(xpath="//span[@id='receptacle-weight']")
	public WebElement preconRecepWeight;
	
	@FindBy(xpath="(//span[@id='receptacle-items'])[1]")
	public WebElement preconRecepItems;
	
	@FindBy(xpath="(//span[@id='Despatch-ID'])[1]")
	public WebElement preconDespatchID;
	
	//RESCON information fields
	public ReceptacleSummary(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
