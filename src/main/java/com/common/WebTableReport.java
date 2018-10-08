package com.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

//import com.anz.python.pageObjects.Browser_PO;



public class WebTableReport {

	private WebElement _webTableReport;

	public WebTableReport() {
		super();
	}

	public WebTableReport(WebElement webTableReport) {
		set_webTableReport(webTableReport);
	}

	public WebElement get_webTableReport() {
		return _webTableReport;
	}

	public void set_webTableReport(WebElement _webTableReport) {
		this._webTableReport = _webTableReport;
	}
	
	public int getSearchAccountPopupRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("#div-account-search div.slick-viewport div.grid-canvas div.ui-widget-content"));
		return tableRows.size();
	}
	
	public int getSearchAccountPopupColCount() {
		List<WebElement> tableCols = _webTableReport
				.findElements(By
						.xpath("//*[@id='5020c1ee-272e-33a6-9787-b9bf44cd2683']/div[2]/div/div"));		
		return tableCols.size();
	}
	
	public int getRowCountReport() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public int getRowCountReportResourse() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'label-column')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public int getRowCountReportHeader() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'slick-header-columns ui-sortable')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public int getRowCountReportAppAssignSection() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@style,'padding:0px;')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public int getRowCountReportAuditHistory() {
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'row fluid')]"));
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public int getColumnCountReport() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement headerRow = tableRows.get(0);
		List<WebElement> tableCols = headerRow.findElements(By
				.cssSelector("div.ui-widget-content div.slick-cell"));
		return tableCols.size();
	}

	public String getCellDataReport(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'slick-header-columns ui-sortable')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.xpath("//div[contains(@class,'ui-state-default slick-header-column slick-header-sortable')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	/*
	 * public String getCellDataReportResourseLabel(int rowIdx) {
	 * List<WebElement> tableRows = _webTableReport.findElements(By.cssSelector(
	 * "div#resInfo-group div#resId-section.data-container div.row"));
	 * WebElement currentRow = tableRows.get(rowIdx-1); List<WebElement>
	 * tableCols =
	 * currentRow.findElements(By.xpath("//div[contains(@class,'label-column')]"
	 * )); WebElement cell = tableCols.get(colIdx-1); return cell.getText(); }
	 */

	public String getCellDataReportRemoveApplication(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.cssSelector("div.ui-widget-content div.slick-cell"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String getCellDataReportAssignApp(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@style,'padding:0px;')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#da-userapplications-section.form-section div.linkDiv div.appSections table tbody tr td div.row div.data-column"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public WebElement getCellEditorReport(int rowIdx, int colIdx, int editorIdx)
			throws NoSuchElementException {
		try {

			List<WebElement> tableRows = _webTableReport
					.findElements(By
							.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
			WebElement currentRow = tableRows.get(rowIdx - 1);
			List<WebElement> tableCols = currentRow.findElements(By
					.cssSelector("div.ui-widget-content div.slick-cell"));
			WebElement cell = tableCols.get(colIdx - 1);
			WebElement cellEditor = cell.findElements(By.tagName("input")).get(
					editorIdx);
			return cellEditor;

		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get cell editor");
		}
	}

	public WebElement selectCellReport(int rowIdx, int colIdx, int selectIdx)
			throws NoSuchElementException {
		try {

			List<WebElement> tableRows = _webTableReport
					.findElements(By
							.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
			WebElement currentRow = tableRows.get(rowIdx - 1);
			List<WebElement> tableCols = currentRow.findElements(By
					.cssSelector("div.ui-widget-content div.slick-cell"));
			WebElement cell = tableCols.get(colIdx - 1);
			WebElement cellChecker = cell.findElements(
					By.xpath("//input[@type='checkbox']")).get(selectIdx);
			return cellChecker;

		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get cell editor");
		}

	}

	// report details table
	public String getCellDataReportDetails(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.cssSelector("div.label-column"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String getCellDataReportDetailsRemoveApp(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.tagName("tr"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String PasswordGenerateSection(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'data-column')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getRowCountReportDetails() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		return tableRows.size();
	}

	// select a particular row
	public void selectRowReport(int rowIdx) throws NoSuchElementException {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		currentRow.click();
	}

	public int getRowCountReport1() {
	  //  List<WebElement> tableRows = _webTableReport.findElements(By.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
	   // List<WebElement> tableRows = _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		List<WebElement> irows=_webTableReport.findElements(By.cssSelector(".ui-widget-content.slick-row"));
	    return irows.size();
	}
	public int getColumnCountReport1() {
		List<WebElement> irows=_webTableReport.findElements(By.cssSelector(".ui-widget-content.slick-row"));
		List<WebElement> icols=irows.get(0).findElements(By.cssSelector(".slick-cell"));
		return icols.size();
	}
	
	public int getRowCountReport2() {
		  //  List<WebElement> tableRows = _webTableReport.findElements(By.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		   // List<WebElement> tableRows = _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
			List<WebElement> irows=_webTableReport.findElements(By.cssSelector(".data-table-row"));
		    return irows.size();
		}
		public int getColumnCountReport2() {
			List<WebElement> irows=_webTableReport.findElements(By.cssSelector(".data-table-row"));
			List<WebElement> icols=irows.get(0).findElements(By.cssSelector(".data-table-cell"));
			return icols.size();
		}
	public String getCellDataReport1(int rowIdx, int colIdx) {
		List<WebElement> irows=_webTableReport.findElements(By.cssSelector(".ui-widget-content.slick-row"));
		WebElement currentRow = irows.get(rowIdx);
		List<WebElement> icols=currentRow.findElements(By.cssSelector(".slick-cell"));
		WebElement cell = icols.get(colIdx);
		return cell.getText();		
	}
	
	public String getCellDataReport2(int rowIdx, int colIdx) {
		List<WebElement> irows=_webTableReport.findElements(By.cssSelector(".data-table-row"));
		WebElement currentRow = irows.get(rowIdx);
		List<WebElement> icols=currentRow.findElements(By.cssSelector(".data-table-cell"));
		WebElement cell = icols.get(colIdx);
		return cell.getText();		
	}
	
	
	public int getRowTextReport(String rowText) {
		int nRow = 0;
		// get the row count
		int iRow = getRowCountReport();

		// iterate for loop
		for (int i = 1; i <= iRow; i++) {
			String s = getCellDataReport(i, 3);
			if (rowText.trim().equals(s)) {
				nRow = i;
				break;
			}
			// return nRow;

		}
		return nRow;
	}

	public String getCellDataReportAddAccount(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'grid-canvas')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.cssSelector("div.label-column"));
		int s = tableCols.size();
		System.out.println(s);
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getAddFavoriteRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		return tableRows.size();
	}

	// to multiselect rows - need to include in multiselect
	public void multiSelectRow(String rowData) {

		String[] s = rowData.split(",");
		// get length
		int i = s.length;
		ArrayList<String> al = new ArrayList<String>();
		for (int j = 0; j < i; j++) {
			al.add(s[j]);
		}
		// multiSelectCurrency(al);

	}

	// ////need to be inclused in multiple currency select
	/*
	 * public void multiSelectCurrency(List<String> strList){
	 * 
	 * WebTableReport eReport = new
	 * WebTableReport(Browser.driver().findElement(By
	 * .cssSelector("div.slick-viewport")));
	 * 
	 * for(int i =0;i<strList.size();i++){ String s = strList.get(i); int nRow =
	 * eReport.getRowTextReport(s); int k =i+1; WebElement cell =
	 * eReport.selectCellReport(k, 2, nRow); cell.click(); }
	 */

	// ////////
	// returns nth Column by passing parameter as Column value, returns 0 if
	// there is no column found
	public int getColumnTextReport(String colText) {
		int nCol = 0;
		// get the row count
		int iCol = getColumnCountReport();

		// iterate for loop
		for (int i = 1; i <= iCol; i++) {
			String s = getColNameCellDataReport(i);
			if (colText.trim().equals(s)) {
				nCol = i;
				break;
			}

		}
		return nCol;
	}

	public String getColNameCellDataReport(int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'slick-header ui-state-default')]"));

		WebElement currentRow = tableRows.get(0);
		List<WebElement> tableCols = currentRow.findElements(By
				.cssSelector("span.slick-column-name"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getDownloadRowCountReport() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'slick-header')]"));
		return tableRows.size();
	}

	public int getRowCountReportProfiles() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		return tableRows.size();
	}

	public String getCellDataTransactionLabelDetails(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.cssSelector("div.label-column"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String getCellDataTransactionDataDetails(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.cssSelector("div.data-column"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

/*	public void selectRowReportTable() throws NoSuchElementException {

		Browser_PO.driver().findElement(By.className("slick-cell l1 r1")).click();

	}*/

	/*public void selectfirstrowReport() throws NoSuchElementException {
		try {

			Browser_PO.driver()
					.findElement(
							By.xpath(".//*[@id='1571c550-de40-3533-b587-38d25e8e2e49']/div[5]/div/div[4]/div[3]"))
					.click();
			
			 * List<WebElement> tableRows =
			 * _webTableReport.findElements(By.xpath
			 * ("//div[contains(@class,'ui-widget-content slick-row')]"));
			 * WebElement currentRow = tableRows.get(rowIdx-1); List<WebElement>
			 * tableCols = currentRow.findElements(By.cssSelector(
			 * "div.ui-widget-content div.slick-cell"));
			 * tableCols.get(colIdx-1).click();
			 
			// WebElement cellChecker =
			// cell.findElements(By.xpath("//div[contains@class='slick-cell']")).get(selectIdx);
			// cellChecker.click();

		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get cell editor");
		}

	}*/

	public String auditHistoryDataTable(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#da-full-audit-history-section.data-section div.row div"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String DAEditUserDetails(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#da-view-user-section.data-section div.row div.data-column"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getApplicationRowCountReport() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();

	}

	public String DAViewApplicationSection(int rowIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		return currentRow.getText();
	}

	public int getRowCountSecurityCredentials() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#security-device-details-section div.data-entry div.data-section div.row"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();

	}

	public int getColumnCountSecurityCredentials() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#security-device-details-section div.data-entry div.data-section div.row"));
		WebElement headerRow = tableRows.get(0);
		List<WebElement> tableCols = headerRow
				.findElements(By
						.cssSelector("div#security-device-details-section div.data-entry div.data-section div.row div.label-column"));
		return tableCols.size();
	}

	public String getCellDataSecurityCredentials(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#security-device-details-section div.data-entry div.data-section div.row"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#security-device-details-section div.data-entry div.data-section div.row div.label-column"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getRowCountViewAllAuditHistory() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@style,'border-bottom:1px solid #C4D1E3;')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();

	}

	public String getCellDataViewAllAuditHistory(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@style,'border-bottom:1px solid #C4D1E3;')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#da-full-audit-history-section.data-section div.row div div.data-column"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String getCellDataReportPreviewMode(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div.slick-cell div.cell-main div.cell-inner div.cell-detail"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String DaEditUserDetails(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'data-column')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String DaGetAuditHistory(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'fav-row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'fav-data-col')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getRowCountAuditHistory() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'fav-row')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();

	}

	public String CreateUserDetails(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'data-column')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String CreateUserTopSectionDetails(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'leftcontent')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'headertext')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String CreateUserTopRightSide(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'rightcontent')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//td[contains(@class,'datafield')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getCustomerDetailsRowCount() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'label-column')]"));

		return tableRows.size();
	}

	public int getResourseDataRowCount() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'data-column')]"));

		return tableRows.size();
	}
	
	public int getBankUSerDetailsRowCount() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'label-column')]"));

		return tableRows.size();
	}

	public int getCustomerDetailsRowCountDataColumn() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'data-column')]"));

		return tableRows.size();
	}

	public String getCustomerDetailsUi(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'label-column')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}
	
	
	public String getCustomerDetailsUiData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'data-text')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	

	public String getResourceDataUi(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'data-column')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}
	
	public String getBankUsersDetailDataUi(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'data-column')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String getCustomerDetails(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'data-column')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String getCellDataCobraSearch(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'slick-cell')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getCustomerDivisionRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector(" div#customers-custDivisionTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public String GetDivisionData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector(" div#customers-custDivisionTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#customers-custDivisionTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content div.slick-cell"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String GetCustomerUserDataUi(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#customers-custUsersTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#customers-custUsersTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content div.slick-cell"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public String getCustomerUserPractice(int rowIdx, int colIdx, int i, int j) {
		WebElement cell = null;
		if ((i == 1) && (j == 1)) {
			List<WebElement> tableRows = _webTableReport
					.findElements(By
							.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/ul/li[3]/div/div/div[2]/div/div/div/div[5]/div/div"));
			WebElement currentRow = tableRows.get(rowIdx - 1);
			List<WebElement> tableCols = currentRow
					.findElements(By
							.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/ul/li[3]/div/div/div[2]/div/div/div/div[5]/div/div/div"));
			cell = tableCols.get(colIdx - 1);

		}
		if ((i == 1) && (j > 1)) {

			List<WebElement> tableRows = _webTableReport
					.findElements(By
							.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/ul/li[3]/div/div/div[2]/div/div/div/div[5]/div/div"));
			WebElement currentRow = tableRows.get(rowIdx - 1);
			List<WebElement> tableCols = currentRow
					.findElements(By
							.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/ul/li[3]/div/div/div[2]/div/div/div/div[5]/div/div/div["
									+ j + "]"));
			cell = tableCols.get(colIdx - 1);

		}
		if ((i > 1) && (j > 1)) {
			List<WebElement> tableRows = _webTableReport
					.findElements(By
							.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/ul/li[3]/div/div/div[2]/div/div/div/div[5]/div/div["
									+ i + "]"));
			WebElement currentRow = tableRows.get(rowIdx - 1);
			List<WebElement> tableCols = currentRow
					.findElements(By
							.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/ul/li[3]/div/div/div[2]/div/div/div/div[5]/div/div/div["
									+ j + "]"));
			cell = tableCols.get(colIdx - 1);
		}

		return cell.getText();
	}

	public int getCustomerUserRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#customers-custUsersTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public int getResourceRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public int getManageSaveSearchRowCount() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'editable-list-item')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public String getManageSavedData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'editable-list-item')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#manageSavedSearches.saved-searches ul#sortable.editable-list li div.editable-list-item input"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getManageSaveSearchDropDownRowCount() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.tagName("li"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public int getDivisionUserRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#divisions-divDtlUsr-grid_wrap div#divisions-divDtlUsr-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public String GetDivisionUserData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#divisions-divDtlUsr-grid_wrap div#divisions-divDtlUsr-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#divisions-divDtlUsr-grid_wrap div#divisions-divDtlUsr-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content div.slick-cell"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getRowCountReportCustomer() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public String DivisionDetails(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'data-column')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getRowCountDivAddress() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'data-text')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public String getDivisionAddressUI(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'data-text')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By
				.xpath("//div[contains(@class,'data-text')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int GetDivisionResourseRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#divisions-divDtlRes-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public String getDivisionResourseData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#divisions-divDtlRes-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#divisions-divDtlRes-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content div.slick-cell"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int GetCreateCustomerRowCount() {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'row fluid')]"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
		// List<WebElement> tableRows =
		// _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
		return tableRows.size();
	}

	public String getErrorMessages(int rowIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//div[contains(@class,'data-error')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);

		return currentRow.getText();
	}

	public int GetUserEntitlementRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#users-userEntitlementsTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));

		return tableRows.size();
	}

	public String getUserEntitlementData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#users-userEntitlementsTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#users-userEntitlementsTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content div.slick-cell"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getApplicationAssignRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#userApplicationsTab-section.tab-panel div div.tab-content div#divInfo-group div#resId-section.data-table div.data-table-row"));

		return tableRows.size();
	}

	public String getApplicationAssignedData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#userApplicationsTab-section.tab-panel div div.tab-content div#divInfo-group div#resId-section.data-table div.data-table-row"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#divInfo-group div#resId-section.data-table div.data-table-row div.data-table-cell"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getEntitlementDetailsRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#usrEntitlementPopup.dialog-container div.dialog-body div div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row"));

		return tableRows.size();
	}

	public String getEntitlementDetailsdata(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#usrEntitlementPopup.dialog-container div.dialog-body div div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.cssSelector("div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row div.label-column"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}

	public int getCashManagementProdustRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#usrEntitlementPopup.dialog-container div.dialog-body div div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row"));

		return tableRows.size();
	}

	public String getCashManagementProdusts(int rowIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By
				.xpath("//span[contains(@class,'label')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		// List<WebElement> tableCols =
		// currentRow.findElements(By.cssSelector("div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row div.label-column"));
		// WebElement cell = tableCols.get(colIdx-1);
		return currentRow.getText();
	}

	public int getAccountANZRowCountResourceTypeSection() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obResourceType-group div#obResourceType-section.data-container div.row"));

		return tableRows.size();
	}

	public String GetAccountANZFieldsResourceTypeSection(int rowIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obResourceType-section.data-container div.row div.label-column"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		// List<WebElement> tableCols =
		// currentRow.findElements(By.cssSelector("div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row div.label-column"));
		// WebElement cell = tableCols.get(colIdx-1);
		return currentRow.getText();
	}

	public int getAccountANZRowCountFindAnAccountSection() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obResourceAccountANZ-section.data-container div.row"));

		return tableRows.size();
	}

	public String GetAccountANZFieldsFindAnAccountSection(int rowIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obResourceAccountANZ-section.data-container div.row div.label-column"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		// List<WebElement> tableCols =
		// currentRow.findElements(By.cssSelector("div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row div.label-column"));
		// WebElement cell = tableCols.get(colIdx-1);
		return currentRow.getText();
	}

	public int getAccountANZRowCountAccountDetailsSection() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obResourceAccDetails-section.data-container div.row"));

		return tableRows.size();
	}

	public String GetAccountANZFieldsAccountDetailsSection(int rowIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obResourceAccDetails-group div#obResourceAccDetails-section.data-container div.row div.label-column"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		// List<WebElement> tableCols =
		// currentRow.findElements(By.cssSelector("div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row div.label-column"));
		// WebElement cell = tableCols.get(colIdx-1);
		return currentRow.getText();
	}

	public int getresourceBillingEntityRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obResourceBillingDetails-group div#obResourceBillingDetails-section.data-container div.row"));

		return tableRows.size();
	}
	public String GetResourceBillingEntityUIData(int rowIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obResourceBillingDetails-section.data-container div.row div.label-column"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		// List<WebElement> tableCols =
		// currentRow.findElements(By.cssSelector("div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row div.label-column"));
		// WebElement cell = tableCols.get(colIdx-1);
		return currentRow.getText();
	}
	

	public String Get_Cust_Summ_QuickFilter(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport.findElements(By.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement currentRow = tableRows.get(rowIdx-1);
		List<WebElement> tableCols = currentRow.findElements(By.xpath("//div[contains(@class,'slick-cell')]"));
		WebElement cell = tableCols.get(colIdx-1);
		return cell.getText();		
	}
	
		
	
	public int Get_Cust_Summ_QuickFilter_Rowcount() {
	    List<WebElement> tableRows = _webTableReport.findElements(By.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
	    //List<WebElement> tableRows = _webTableReport.findElements(By.xpath("//*[@id='da-audit-history-section']/div/div"));
	   // List<WebElement> tableRows = _webTableReport.findElements(By.xpath("//div[contains(@class,'slick-cell-checkboxsel')]"));
	    return tableRows.size();
	}
	
	
		

	public String GetErrorMessage(int rowIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'data-error')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		// List<WebElement> tableCols =
		// currentRow.findElements(By.cssSelector("div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row div.label-column"));
		// WebElement cell = tableCols.get(colIdx-1);
		return currentRow.getText();
	}

	
	public int getDivisionAddressRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obDivisionDivision-section.data-container div.row"));

		return tableRows.size();
	}
	public String GetAddressDivisionSameAsCustomer(int rowIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obDivisionDivision-section.data-container div.row div.data-column"));
		WebElement currentRow = tableRows.get(rowIdx-1);
		// List<WebElement> tableCols =
		// currentRow.findElements(By.cssSelector("div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row div.label-column"));
		// WebElement cell = tableCols.get(colIdx-1);
		return currentRow.getText();
	}
	
	public int getDivisionContactRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obDivisionContact-section.data-container div.row"));

		return tableRows.size();
	}
	public int getAccountMDZRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#obResourceAccDetails-section.data-container div.row"));

		return tableRows.size();
	}
	public String getMDZAccountDetails(int rowIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'data-text')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		// List<WebElement> tableCols =
		// currentRow.findElements(By.cssSelector("div#usrEntitlementPopup-section div#popupFilter div.dialog-content div div.data-container div.row div.label-column"));
		// WebElement cell = tableCols.get(colIdx-1);
		return currentRow.getText();
	}
	public int getAccountClientIdRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'data-text')]"));

		return tableRows.size();
	}
	
	public String getResourseTermDepositData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'ui-widget-content slick-row')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow
				.findElements(By
						.xpath("//div[contains(@class,'slick-cell')]"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}
	
	public int getUserDetailsRowCount() {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.cssSelector("div#userDetailTab-section.tab-panel div div.tab-content div#resInfo-group div#resId-section.data-container div.row"));

		return tableRows.size();
	}
	
	public String getUserDetailsData(int rowIdx) {
		List<WebElement> tableRows = _webTableReport
				.findElements(By
						.xpath("//div[contains(@class,'data-text')]"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		/*List<WebElement> tableCols = currentRow
				.findElements(By
						.xpath("//div[contains(@class,'slick-cell')]"));
		WebElement cell = tableCols.get(colIdx - 1);*/
		return currentRow.getText();
	}
	
	/*public int getCustAuditRowCount() {
		WebElement parenttable=Browser_PO.driver().findElement(By.cssSelector("#customers-custAuditTab-grid"));
				
		WebElement table=parenttable.findElement(By.cssSelector("div.slick-viewport"));
		List<WebElement> irows=table.findElements(By.cssSelector(".ui-widget-content.slick-row"));
		//System.out.println(irows.size());
		for(int i=0;i<irows.size();i++){
			List<WebElement> icols=irows.get(i).findElements(By.cssSelector(".slick-cell"));
			//System.out.println(irows.get(i).findElements(By.cssSelector(".slick-cell")).size());
			
			for(int j=0;j<icols.size();j++){
				System.out.println(icols.get(j).getText());
			}
		}
		
//		List<WebElement> tableRows = _webTableReport1.findElements(By
//						.cssSelector("div div#customers-custAuditTab-grid_wrap div#customers-custAuditTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
 
		return irows.size();
	
		}*/
	
	
	/*public int getCustAuditdatapopup() {
		//WebElement parenttable=Browser_PO.driver().findElement(By.cssSelector("#auditEntryDetails-popup"));
				
		WebElement table=Browser_PO.driver().findElement(By.cssSelector("div.auditEntryGrid.data-container"));
		List<WebElement> irows=table.findElements(By.cssSelector(".data-table-row"));
		//System.out.println(irows.size());
		for(int i=1;i<irows.size();i++){
			List<WebElement> icols=irows.get(i).findElements(By.cssSelector(".data-table-cell"));
			//System.out.println(irows.get(i).findElements(By.cssSelector(".slick-cell")).size());
			
			for(int j=0;j<icols.size();j++){
				System.out.println(icols.get(j).getText());
			}
		}
		
//		List<WebElement> tableRows = _webTableReport1.findElements(By
//						.cssSelector("div div#customers-custAuditTab-grid_wrap div#customers-custAuditTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content"));
 
		return irows.size();
	
		}*/

	
	
/*public int getCustAuditColCount() {
		
		
		List<WebElement> tableCols = Browser_PO.driver().findElements(By
						.cssSelector("div#customers-custAuditTab-grid.data-container div.slick-viewport div.grid-canvas div.ui-widget-content div.slick-cell"));
 
		return tableCols.size();
	
		}*/


	
	
}
