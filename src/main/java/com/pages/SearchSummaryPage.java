package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.BaseTest;

public class SearchSummaryPage {
	
	@FindBy(xpath="//strong[contains(text(),'Create Summary Search')]")
	public WebElement summarySearch;
	
	@FindBy(xpath="//a[text()=' Search Summary']")
	public WebElement searchSummary;
	
	
	@FindBy(xpath="//section/label[text()='Carrier']/following-sibling::span/div/div/div/button[@class='dropdown-toggle ng-binding ng-scope btn btn-default']/span")
	public WebElement carrier;
	
	@FindBy(xpath="//section/label[text()='Destination DO']/following-sibling::span/div/div/div/button[@class='dropdown-toggle ng-binding ng-scope btn btn-default']/span")
	public WebElement destinationDO;
	
	@FindBy(xpath="//section/label[text()='Destination DO']/following-sibling::span/div/div/ul/li/a[text()=' Select All']")
	public WebElement destinationDODropDown;
	
	@FindBy(xpath="//section/label[text()='Carrier']/following-sibling::span/div/div/ul/li/a[text()=' Select All']")
	public WebElement carrierDropDown;
	
	@FindBy(xpath="//button[text()='Search']")
	public WebElement searchButton;
	
	
	
	 public SearchSummaryPage(WebDriver driver){
         //This initElements method will create all WebElements
         PageFactory.initElements(driver, this);
     }
	 
	 public void getsearchButton() {
		  new Actions(BaseTest.driver()).moveToElement(searchButton).click().perform();
		  
	 }

}
