package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchSummaryPage {
	
	@FindBy(xpath="//strong[contains(text(),'Create Summary Search')]")
	public WebElement summarySearch;
	
	 public SearchSummaryPage(WebDriver driver){
         //This initElements method will create all WebElements
         PageFactory.initElements(driver, this);
     }
	 
	 public String getSummarySearchText() {
		 return summarySearch.getText();
		  
	 }

}
