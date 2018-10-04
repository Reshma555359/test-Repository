package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.IConstantValues;
import com.common.Lib;

public class SearchConsignmentPage implements IConstantValues{
	
	@FindBy(xpath="//a[@href='#!/searchConsign']")
	public WebElement searchConsignment;

    @FindBy(xpath="//input[@id='input-search']")
    public WebElement consignmentNumber;
    
    @FindBy(xpath="//button[@id='find-btn']")
    public WebElement findItem;
    
    @FindBy(xpath="//strong[contains(text(),'Active Search')]")
    public WebElement activeSearch;
    
    @FindBy(xpath="//span[@ng-bind='errorMsg']")
    public WebElement errorMsg;
    
      public SearchConsignmentPage(WebDriver driver){
            //This initElements method will create all WebElements
            PageFactory.initElements(driver, this);
        }
      
      public String getActiveSearchText() {
 		 return activeSearch.getText();
 		  
 	 }
      
      public void navigateToSearchConsignment() {
                      searchConsignment.click();
      }
      
      public void enterConsignmentNumber(int k, int j) {
    	  String consignNo = Lib.getCellValue(EXCEL_PATH,"consignmentnumber",k,j);
    	  consignmentNumber.sendKeys(consignNo);
      }
      
      public void clickFindItem() {
                      findItem.click();
      }
      public String errorMsgText() {
          String text = errorMsg.getText();
          return text;
}
      /*@SuppressWarnings("finally")
	public boolean errorMsgdisplayed() {
    	  boolean displayed = false;
    	  try {
    		  displayed= errorMsg.isDisplayed();
    		  System.out.println("Due to the following error Test case failed: "+errorMsg.getText());
              
		}finally {
			 return displayed;  
			 
		}
    	  
    	  
}*/

}
