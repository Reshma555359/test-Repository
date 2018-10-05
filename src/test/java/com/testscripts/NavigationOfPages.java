package com.testscripts;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.common.BaseTest;
import com.common.CommonFunctions;
import com.common.Lib;
import com.common.XLUtilities;
import com.pages.ConsignmentDetailsPage;
import com.pages.ConsignmentSummaryPage;
import com.pages.EventDetailsPage;
import com.pages.PreconDetailsPage;
import com.pages.ReceptacleSummary;
import com.pages.SearchConsignmentPage;
import com.pages.SearchSummaryPage;

import junit.framework.Assert;

public class NavigationOfPages extends BaseTest{
	SearchConsignmentPage scp;
	SearchSummaryPage ssp;
	ConsignmentSummaryPage csp;
	ConsignmentDetailsPage cdp;
	PreconDetailsPage pdp;
	CommonFunctions cf;
	XLUtilities ul;
	ReceptacleSummary rs;
	EventDetailsPage edp;
	String TestData="TestData";
	String CommonTestData="CommonTestData";
	String Colheader1="ConsignmentNO";
	String Colheader2="ReceptacleID";
	String consignoTC01;
	String receptacleID;
	String summarySearch="summarySearch";
	String searchConsignment="searchConsignment";
	@BeforeClass
	public void setup() throws Exception {
			openURL();
			scp = new SearchConsignmentPage(driver);
			ssp = new SearchSummaryPage(driver);
			csp = new ConsignmentSummaryPage(driver);
			cdp = new ConsignmentDetailsPage(driver);
			cf= new CommonFunctions();
			rs = new ReceptacleSummary(driver);
			ul=new XLUtilities();
			pdp=new PreconDetailsPage(driver);
			edp = new EventDetailsPage(driver);
			consignoTC01=ul.getvalueFromxcell(EXCEL_PATH, TestData, CommonTestData, Colheader1);
			receptacleID=ul.getvalueFromxcell(EXCEL_PATH, TestData, CommonTestData, Colheader2);
			//System.out.println(consignoTC01+":consignoTC01");
			//System.out.println(receptacleID+":receptacleID");
	}
	@Test(enabled=false)
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
	@Test(enabled=false)
	public void navigateToEventDetails2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
		cf.click(scp.searchConsignment, searchConsignment);
		cf.verifyElement_IsDisplayed(scp.activeSearch, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignoTC01, "consigno");
		cf.click(scp.findItem, "findItem");
		//toSwitchTab(2);
		driver.get("http://npermg397:8090/CTS/#!/consignments/PREC01048239");
		cf.verifyElement_IsDisplayed(csp.handoverInfo, "handoverInfo");
		cf.click(csp.preconDetails, "preconDetails");
		cf.verifyElement_IsDisplayed(pdp.preconTransInfo, "preconTransInfo");
		cf.click(csp.consignmentDetails, "consignmentDetails");
		cf.verifyElement_IsDisplayed(cdp.receptacleInfo, "receptacleInfo");
		cf.click(cdp.ReceptacleID(receptacleID), "clicking");
		//driver.get("http://npermg397:8090/CTS/#!/receptacle/CARDITRECEPTACLEID00000111201");
		cf.verifyElement_IsDisplayed(rs.receptacleDetails, "receptacleDetails");
		cf.click(rs.event, "event");
		toSwitchTab(2);
		cf.verifyElement_IsDisplayed(edp.eventInfo, "eventInfo");
		toSwitchTab(2);
		cf.verifyElement_IsDisplayed(rs.receptacleDetails, "receptacleDetails");
		cf.click(cdp.consignmentDetails, "consignmentDetails");
		cf.verifyElement_IsDisplayed(cdp.receptacleInfo, "receptacleInfo");
		cf.click(csp.preconDetails, "preconDetails");
		cf.verifyElement_IsDisplayed(pdp.preconTransInfo, "preconTransInfo");
		cf.click(csp.consignSummary, "consignSummary");
		cf.verifyElement_IsDisplayed(csp.handoverInfo, "handoverInfo");
		
		
	}
	
	@Test(enabled=false)
	public void searchNavigation() {
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
		cf.click(scp.searchConsignment, searchConsignment);
		cf.verifyElement_IsDisplayed(scp.activeSearch, "searchConsignment");
		cf.click(ssp.searchSummary, "searchSummary");
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
	}
	
	@Test(enabled=false)
	public void navigateConsignSummaryToEventDetails() {
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
		cf.click(scp.searchConsignment, searchConsignment);
		cf.verifyElement_IsDisplayed(scp.activeSearch, "searchConsignment");
		cf.sendKeys(scp.consignmentNumber, consignoTC01, "consigno");
		cf.click(scp.findItem, "findItem");
		//toSwitchTab(3);
		driver.get("http://npermg397:8090/CTS/#!/consignments/PREC01048239");
		cf.verifyElement_IsDisplayed(csp.handoverInfo, "handoverInfo");
		cf.click(csp.eventDescriptionFirst, "eventDescriptionFirst");
		toSwitchTab(2);
		cf.verifyElement_IsDisplayed(edp.eventInfo, "eventInfo");
		
	}
	
	@Test
	public void navigateToSummaryInfo() throws InterruptedException {
		cf.verifyElement_IsDisplayed(ssp.summarySearch,summarySearch );
		
		cf.click(ssp.carrier, "carrier");
		cf.click(ssp.carrierDropDown, "carrierDropDown");
		Thread.sleep(5000);
		cf.click(ssp.destinationDO, "destinationDO");
		cf.click(ssp.destinationDODropDown, "destinationDODropDown");
		Thread.sleep(5000);
		ssp.getsearchButton();
		Thread.sleep(5000);
		
	
	
	}
	
	

}
