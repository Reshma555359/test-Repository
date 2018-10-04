package com.testscripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.common.BaseTest;
import com.common.Lib;
import com.pages.ConsignmentDetailsPage;
import com.pages.ConsignmentSummaryPage;
import com.pages.SearchConsignmentPage;
import com.pages.SearchSummaryPage;

import junit.framework.Assert;

public class NavigationOfPages extends BaseTest{
	SearchConsignmentPage scp;
	SearchSummaryPage ssp;
	ConsignmentSummaryPage csp;
	ConsignmentDetailsPage cdp;
	@BeforeClass
	public void PageObjects() {
		 scp = new SearchConsignmentPage(driver);
		 ssp = new SearchSummaryPage(driver);
		 csp = new ConsignmentSummaryPage(driver);
		 cdp = new ConsignmentDetailsPage(driver);
	}
	@Test
	public void navigateToEventDetails() {
		
	/*	System.out.println("Print text");
		String summarySearchText = ssp.summarySearch.getText();
		
		System.out.println("summarySearchText"+summarySearchText);
		String expectedLP = Lib.getCellValue(EXCEL_PATH, "pagetitle", 0, 0);
		System.out.println(expectedLP+"expectedLP"+"summarySearchText"+summarySearchText);
		Assert.assertEquals(expectedLP, summarySearchText);*/

		scp.navigateToSearchConsignment();
/*		String activeSearchText = scp.getActiveSearchText();
		String expectedSC = Lib.getCellValue(EXCEL_PATH, "pagetitle", 1, 0);
		System.out.println(activeSearchText+"activeSearchText"+"expectedSC"+expectedSC);
		Assert.assertEquals(expectedSC, activeSearchText);*/
		
		/*scp.enterConsignmentNumber(1, 0);
		scp.clickFindItem();
		Assert.assertFalse(scp.errorMsgdisplayed());
		toSwitchTab(2);
		System.out.println(driver.getTitle()+":title "+driver.getCurrentUrl()+"URL ");
		
		String consignInfotxt = csp.getConsignmentInfoText();
		String expectedConsignInfotxt = Lib.getCellValue(EXCEL_PATH, "pagetitle", 2, 0);
		System.out.println("consignInfotxt "+consignInfotxt+"expectedConsignInfotxt "+expectedConsignInfotxt);
		Assert.assertEquals(expectedConsignInfotxt, consignInfotxt);
		
		cdp.clickConsignDetails();
		String receptacleInfotxt = cdp.getreceptacleInfoText();
		String expectedreceptacleInfotxt = Lib.getCellValue(EXCEL_PATH, "pagetitle", 3, 0);
		System.out.println("consignInfotxt "+receptacleInfotxt+"expectedConsignInfotxt "+expectedreceptacleInfotxt);
		Assert.assertEquals(expectedreceptacleInfotxt, receptacleInfotxt);
		*/
		//cdp.clickReceptacleID();
	
		
	}

}
