package com.testscripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.common.BaseTest;
import com.common.CommonFunctions;
import com.common.WebTable;
import com.common.XLUtilities;
import com.pages.ConsignmentDetailsPage;
import com.pages.ConsignmentSummaryPage;
import com.pages.EventDetailsPage;
import com.pages.SearchConsignmentPage;

public class AllOntimeFull extends BaseTest {
	SearchConsignmentPage scp;
	ConsignmentDetailsPage cdp;
	ConsignmentSummaryPage csp;
	CommonFunctions cf;
	XLUtilities ul; 
	WebTable wt;
	EventDetailsPage edp;
	String errorMessage="errormessage";
	String TestData="TestData";
	String AllOntime="AllOntime";
	String Colheader1="ConsignmentNO";
	String Colheader3="Status";
	String consignNo;
	String status1;
	String ReceptacleID2;
	
	@BeforeClass
	public void login() throws Exception {
	openURL();
	scp= new SearchConsignmentPage(driver);
	cf= new CommonFunctions();
	ul=new XLUtilities();
	cdp=new ConsignmentDetailsPage(driver);
	csp = new ConsignmentSummaryPage(driver);
	wt=new WebTable();
	edp=new EventDetailsPage(driver);
	consignNo=ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, Colheader1);
	status1=ul.getvalueFromxcell(EXCEL_PATH, TestData, AllOntime, Colheader3);
	//ReceptacleID2=ul.getvalueFromxcell(EXCEL_PATH, SheetName, "Reshma", "Heena");
	}
	@Test(enabled=false)
	public void validateCurrentStatus() throws Exception {
	//cf.click(cdp.ReceptacleID(ReceptacleID2), "working");
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
	@Test
	public void validateConsignmentStatuses() throws InterruptedException {
		cf.click(scp.searchConsignment, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignNo, "consignmentNumber");
		cf.click(scp.findItem, "findItem");
		//toSwitchTab(2);
		driver.get("http://npermg397:8090/CTS/#!/consignments/PREC01048239");
		Thread.sleep(2000);
		edp.getspecificrow("Event","PRECON(14)","Consignment Status","Count Flag");
		edp.getspecificrow("Event","CARDIT(9)","Consignment Status","Count Flag");
		edp.getspecificrow("Event","En route (31)","Consignment Status","Count Flag");
		edp.getspecificrow("Event","Received (74)","Consignment Status","Count Flag");
		edp.getspecificrow("Event","Delivered (21)","Consignment Status","Count Flag");
		edp.getspecificrow("Event","N/A","Consignment Status","Count Flag");
		/*String statusOne = csp.consignStatusFirst.getText();
		Assert.assertEquals(status1, statusOne);
		System.out.println(statusOne);*/
		
		
		
		
	}
	
	
	@Test(enabled=false)
	public void  validatePreconDetails() {
		
	}
	
	@Test(enabled=false)
	public void  validateEventDetails() {
		
	}
	
}
