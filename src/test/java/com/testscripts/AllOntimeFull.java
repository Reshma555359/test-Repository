package com.testscripts;


import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.common.BaseTest;
import com.common.CommonFunctions;
import com.pages.ConsignmentSummaryPage;
import com.pages.SearchConsignmentPage;

public class AllOntimeFull extends BaseTest {
	SearchConsignmentPage scp;
	CommonFunctions cf;
	String errorMessage="errormessage";
	@BeforeClass
	public void login() throws Exception {
	openURL();
	scp= new SearchConsignmentPage(driver);
	cf= new CommonFunctions();
	}
	@Test
	public void validateCurrentStatus() throws Exception {
		
		scp.navigateToSearchConsignment();
		scp.enterConsignmentNumber(1,0);
		scp.clickFindItem();
		cf.verifyElement_NOTPresent(scp.errorMsg, errorMessage);
		
		/*toSwitchTab(2);
        ConsignmentSummaryPage csp = new ConsignmentSummaryPage(driver);
        String actualcurrentStatus = csp.currentStatus.getText();
        System.out.println(actualcurrentStatus);
        //String expectedCurrentStatus = "HANDOVER LATE";
        String expectedCurrentStatus = csp.getCurrentStatus(1, 0);
        Assert.assertEquals(actualcurrentStatus, expectedCurrentStatus);
		System.out.println("completed");*/	
	}
	
	@Test(enabled=false)
	public void  validatePreconDetails() {
		
	}
	
	@Test(enabled=false)
	public void  validateEventDetails() {
		
	}
	
}
