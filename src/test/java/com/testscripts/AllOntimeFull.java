package com.testscripts;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.BaseTest;
import com.pages.ConsignmentSummaryPage;
import com.pages.SearchConsignmentPage;

public class AllOntimeFull extends BaseTest {
	//SearchConsignmentPage scp = new SearchConsignmentPage(driver);
	
	@Test
	public void validateCurrentStatus() {
		SearchConsignmentPage scp = new SearchConsignmentPage(driver);
		scp.navigateToSearchConsignment();
		scp.enterConsignmentNumber(1,0);
		scp.clickFindItem();
		//Thread.sleep(2000);
		Assert.assertFalse(scp.errorMsgdisplayed());
		toSwitchTab(2);
        ConsignmentSummaryPage csp = new ConsignmentSummaryPage(driver);
        String actualcurrentStatus = csp.currentStatus.getText();
        System.out.println(actualcurrentStatus);
        //String expectedCurrentStatus = "HANDOVER LATE";
        String expectedCurrentStatus = csp.getCurrentStatus(1, 0);
        Assert.assertEquals(actualcurrentStatus, expectedCurrentStatus);
		System.out.println("completed");	
	}
	
	@Test(enabled=false)
	public void  validatePreconDetails() {
		
	}
	
	@Test(enabled=false)
	public void  validateEventDetails() {
		
	}
	
}
