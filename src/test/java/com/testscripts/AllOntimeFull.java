package com.testscripts;





import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.common.BaseTest;
import com.common.CommonFunctions;
import com.common.XLUtilities;
import com.pages.ConsignmentDetailsPage;
import com.pages.ConsignmentSummaryPage;
import com.pages.SearchConsignmentPage;

public class AllOntimeFull extends BaseTest {
	SearchConsignmentPage scp;
	ConsignmentDetailsPage cdp;
	CommonFunctions cf;
	XLUtilities ul; 
	String errorMessage="errormessage";
	String SheetName="consignmentnumber";
	String ReceptacleID;
	
	@BeforeClass
	public void login() throws Exception {
	openURL();
	scp= new SearchConsignmentPage(driver);
	cf= new CommonFunctions();
	ul=new XLUtilities();
	cdp=new ConsignmentDetailsPage(driver);
	ReceptacleID=ul.getvalueFromxcell(EXCEL_PATH, SheetName, "Reshma", "Ayesha");
	}
	@Test
	public void validateCurrentStatus() throws Exception {
	cf.click(cdp.ReceptacleID(), "working");
		/*scp.navigateToSearchConsignment();
		//scp.enterConsignmentNumber(1,0);
		cf.sendKeys(scp.consignmentNumber, ReceptacleID, "enteredvalue");
		//ul.sendKeysfromXcell(scp.consignmentNumber, EXCEL_PATH, SheetName, "Reshma", "Ayesha", "textentered");
		scp.clickFindItem();*/
		/*cf.verifyElement_NOTPresent(scp.errorMsg, errorMessage);
		
		toSwitchTab(2);
        ConsignmentSummaryPage csp = new ConsignmentSummaryPage(driver);
        String actualcurrentStatus = csp.currentStatus.getText();
        System.out.println(actualcurrentStatus);
        //String expectedCurrentStatus = "HANDOVER LATE";
        String expectedCurrentStatus = csp.getCurrentStatus(1, 0);
        Assert.assertEquals(actualcurrentStatus, expectedCurrentStatus);
		System.out.println("completed");	*/
		//cf.click(element, "");
		
	}
	
	@Test(enabled=false)
	public void  validatePreconDetails() {
		
	}
	
	@Test(enabled=false)
	public void  validateEventDetails() {
		
	}
	
}
