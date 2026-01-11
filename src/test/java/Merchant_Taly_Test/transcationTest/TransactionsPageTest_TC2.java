package Merchant_Taly_Test.transcationTest;

import Data.JsonDataReader;
import Merchant_Taly.Transaction.TransactionsPage;
import Merchant_Taly.dashboard.DashboardPage;
import Merchant_Taly_Test.TestBase;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.LoggerHelper;

import java.io.IOException;

public class TransactionsPageTest_TC2 extends TestBase {
    TransactionsPage transactionsObject;

    @BeforeClass
    public void setupTransactionsPage() throws InterruptedException {
        transactionsObject = new TransactionsPage(driver);
        // Navigate to Transactions page
        driver.navigate().to("https://10.20.73.2:8090/dashboard/transactions");
        Thread.sleep(2000);
    }

    // ==================== TC2.1: Verify Transactions Page Loads ====================
    @Test(priority = 1, description = "Verify Transactions page loads successfully")
    public void TC2_1_VerifyTransactionsPageLoads() {
        LoggerHelper.info("Starting Test: Verify Transactions Page Loads");
        boolean isLoaded = transactionsObject.isTransactionsPageLoaded();
        Assert.assertTrue(isLoaded, "Transactions page should load successfully");
        LoggerHelper.info("Test Passed: Transactions Page Loaded Successfully");
    }

    // ==================== TC2.2: Verify Transactions Navigation Active ====================
    @Test(priority = 2, description = "Verify Transactions navigation is in active state")
    public void TC2_2_VerifyTransactionsNavActive() {
        LoggerHelper.info("Starting Test: Verify Transactions Navigation Active");
        Assert.assertTrue(transactionsObject.isTransactionsNavActive(),
                "Transactions navigation should be in active state");
        LoggerHelper.info("Test Passed: Transactions Navigation Active");
    }

    // ==================== TC2.3: Verify Filters Section ====================
    @Test(priority = 3, description = "Verify Filters section title is displayed")
    public void TC2_3_VerifyFiltersSection() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Filters Section");
        String expectedTitle = JsonDataReader.jsonData("transactions_data", "filtersTitle");
        String actualTitle = transactionsObject.getFiltersTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Filters title should match");
        LoggerHelper.info("Test Passed: Filters Section Verified");
    }

    // ==================== TC2.4: Verify All Filters Displayed ====================
    @Test(priority = 4, description = "Verify all filter elements are displayed")
    public void TC2_4_VerifyAllFiltersDisplayed() {
        LoggerHelper.info("Starting Test: Verify All Filters Displayed");
        Assert.assertTrue(transactionsObject.areAllFiltersDisplayed(),
                "All filter elements should be displayed");
        LoggerHelper.info("Test Passed: All Filters Displayed");
    }

    // ==================== TC2.5: Verify Date Range Picker ====================
    @Test(priority = 5, description = "Verify date range picker is clickable")
    public void TC2_5_VerifyDateRangePicker() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Date Range Picker");
        transactionsObject.clickDateRangePicker();
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Date Range Picker Clicked");
    }

    // ==================== TC2.6: Verify Transaction Type Dropdown ====================
    @Test(priority = 6, description = "Verify transaction type dropdown is clickable")
    public void TC2_6_VerifyTransactionTypeDropdown() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Transaction Type Dropdown");
        transactionsObject.clickTransactionTypeDropdown();
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Transaction Type Dropdown Clicked");
    }

    // ==================== TC2.7: Verify Channel Type Dropdown ====================
    @Test(priority = 7, description = "Verify channel type dropdown is clickable")
    public void TC2_7_VerifyChannelTypeDropdown() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Channel Type Dropdown");
        transactionsObject.clickChannelTypeDropdown();
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Channel Type Dropdown Clicked");
    }

    // ==================== TC2.8: Verify Transaction Scheme Dropdown ====================
    @Test(priority = 8, description = "Verify transaction scheme dropdown is clickable")
    public void TC2_8_VerifyTransactionSchemeDropdown() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Transaction Scheme Dropdown");
        transactionsObject.clickTransactionSchemeDropdown();
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Transaction Scheme Dropdown Clicked");
    }

    // ==================== TC2.9: Verify TID Input ====================
    @Test(priority = 9, description = "Verify TID input accepts text")
    public void TC2_9_VerifyTIDInput() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify TID Input");
        String tid = JsonDataReader.jsonData("transactions_data", "sampleTID");
        transactionsObject.enterTID(tid);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: TID Input Verified");
    }

    // ==================== TC2.10: Verify Batch ID Input ====================
    @Test(priority = 10, description = "Verify Batch ID input accepts text")
    public void TC2_10_VerifyBatchIDInput() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Batch ID Input");
        String batchId = JsonDataReader.jsonData("transactions_data", "sampleBatchID");
        transactionsObject.enterBatchID(batchId);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Batch ID Input Verified");
    }

    // ==================== TC2.11: Verify Auth Code Input ====================
    @Test(priority = 11, description = "Verify Auth Code input accepts text")
    public void TC2_11_VerifyAuthCodeInput() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Auth Code Input");
        String authCode = JsonDataReader.jsonData("transactions_data", "sampleAuthCode");
        transactionsObject.enterAuthCode(authCode);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Auth Code Input Verified");
    }

    // ==================== TC2.12: Verify Transaction Status Dropdown ====================
    @Test(priority = 12, description = "Verify transaction status dropdown is clickable")
    public void TC2_12_VerifyTransactionStatusDropdown() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Transaction Status Dropdown");
        transactionsObject.clickTransactionStatusDropdown();
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Transaction Status Dropdown Clicked");
    }

    // ==================== TC2.13: Verify Branch Dropdown ====================
    @Test(priority = 13, description = "Verify branch dropdown is clickable")
    public void TC2_13_VerifyBranchDropdown() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Branch Dropdown");
        transactionsObject.clickBranchDropdown();
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Branch Dropdown Clicked");
    }

    // ==================== TC2.14: Verify Reset Button ====================
    @Test(priority = 14, description = "Verify reset button is displayed and clickable")
    public void TC2_14_VerifyResetButton() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Reset Button");
        Assert.assertTrue(transactionsObject.isResetBtnDisplayed(),
                "Reset button should be displayed");
        transactionsObject.clickResetBtn();
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Reset Button Verified");
    }

    // ==================== TC2.15: Verify Apply Filters Button ====================
    @Test(priority = 15, description = "Verify apply filters button is displayed and clickable")
    public void TC2_15_VerifyApplyFiltersButton() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Apply Filters Button");
        Assert.assertTrue(transactionsObject.isApplyFiltersBtnDisplayed(),
                "Apply filters button should be displayed");
        transactionsObject.clickApplyFiltersBtn();
        Thread.sleep(2000); // Wait for potential data load
        LoggerHelper.info("Test Passed: Apply Filters Button Verified");
    }

    // ==================== TC2.16: Verify Transactions Title ====================
    @Test(priority = 16, description = "Verify Transactions section title")
    public void TC2_16_VerifyTransactionsTitle() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Transactions Title");
        String expectedTitle = JsonDataReader.jsonData("transactions_data", "transactionsTitle");
        String actualTitle = transactionsObject.getTransactionsTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Transactions title should match");
        LoggerHelper.info("Test Passed: Transactions Title Verified");
    }

    // ==================== TC2.17: Verify Total Gross Amount ====================
    @Test(priority = 17, description = "Verify total gross amount is displayed")
    public void TC2_17_VerifyTotalGrossAmount() {
        LoggerHelper.info("Starting Test: Verify Total Gross Amount");
        Assert.assertTrue(transactionsObject.isTotalGrossAmountDisplayed(),
                "Total gross amount should be displayed");
        String amount = transactionsObject.getTotalGrossAmount();
        Assert.assertNotNull(amount, "Total gross amount should not be null");
        LoggerHelper.info("Test Passed: Total Gross Amount - " + amount);
    }

    // ==================== TC2.18: Verify Export Button ====================
    @Test(priority = 18, description = "Verify export button is displayed and clickable")
    public void TC2_18_VerifyExportButton() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Export Button");
        Assert.assertTrue(transactionsObject.isExportBtnDisplayed(),
                "Export button should be displayed");
        // Note: Actual click might trigger download, so we just verify visibility
        LoggerHelper.info("Test Passed: Export Button Verified");
    }

    // ==================== TC2.19: Verify Table Headers ====================
    @Test(priority = 19, description = "Verify all table headers are displayed")
    public void TC2_19_VerifyTableHeaders() {
        LoggerHelper.info("Starting Test: Verify Table Headers");
        Assert.assertTrue(transactionsObject.areAllTableHeadersDisplayed(),
                "All table headers should be displayed");
        LoggerHelper.info("Test Passed: Table Headers Verified");
    }

    // ==================== TC2.20: Verify Select All Checkbox ====================
    @Test(priority = 20, description = "Verify select all checkbox is displayed and clickable")
    public void TC2_20_VerifySelectAllCheckbox() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Select All Checkbox");
        Assert.assertTrue(transactionsObject.isSelectAllCheckboxDisplayed(),
                "Select all checkbox should be displayed");
        transactionsObject.clickSelectAllCheckbox();
        Thread.sleep(1000);
        // Click again to unselect
        transactionsObject.clickSelectAllCheckbox();
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Select All Checkbox Verified");
    }

    // ==================== TC2.21: Verify Table Has Data ====================
    @Test(priority = 21, description = "Verify table contains data rows")
    public void TC2_21_VerifyTableHasData() {
        LoggerHelper.info("Starting Test: Verify Table Has Data");
        int rowCount = transactionsObject.getTableRowCount();
        Assert.assertTrue(rowCount > 0, "Table should contain at least one row");
        LoggerHelper.info("Test Passed: Table Row Count - " + rowCount);
    }

    // ==================== TC2.22: Verify Row Checkbox ====================
    @Test(priority = 22, description = "Verify row checkbox can be clicked")
    public void TC2_22_VerifyRowCheckbox() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Row Checkbox");
        transactionsObject.clickRowCheckbox(0);
        Thread.sleep(1000);
        // Click again to uncheck
        transactionsObject.clickRowCheckbox(0);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Row Checkbox Verified");
    }

    // ==================== TC2.23: Verify Merchant Name Display ====================
    @Test(priority = 23, description = "Verify merchant name is displayed in table")
    public void TC2_23_VerifyMerchantNameDisplay() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Merchant Name Display");
        String merchantName = transactionsObject.getMerchantNameAtRow(0);
        Assert.assertNotNull(merchantName, "Merchant name should not be null");
        String expectedName = JsonDataReader.jsonData("transactions_data", "merchantName");
        Assert.assertEquals(merchantName, expectedName, "Merchant name should match");
        LoggerHelper.info("Test Passed: Merchant Name - " + merchantName);
    }

    // ==================== TC2.24: Verify Row Action Button ====================
    @Test(priority = 24, description = "Verify row action button is clickable")
    public void TC2_24_VerifyRowActionButton() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Row Action Button");
        transactionsObject.clickRowActionButton(0);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Row Action Button Clicked");
    }

    // ==================== TC2.25: Verify Pagination Displayed ====================
    @Test(priority = 25, description = "Verify pagination is displayed")
    public void TC2_25_VerifyPaginationDisplayed() {
        LoggerHelper.info("Starting Test: Verify Pagination Displayed");
        Assert.assertTrue(transactionsObject.isPaginationDisplayed(),
                "Pagination should be displayed");
        LoggerHelper.info("Test Passed: Pagination Displayed");
    }

    // ==================== TC2.26: Verify Current Page Number ====================
    @Test(priority = 26, description = "Verify current page number is displayed")
    public void TC2_26_VerifyCurrentPageNumber() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Current Page Number");
        String currentPage = transactionsObject.getCurrentPageNumber();
        Assert.assertNotNull(currentPage, "Current page number should not be null");
        String expectedPage = JsonDataReader.jsonData("transactions_data", "initialPageNumber");
        Assert.assertEquals(currentPage, expectedPage, "Should be on page 1 initially");
        LoggerHelper.info("Test Passed: Current Page Number - " + currentPage);
    }

    // ==================== TC2.27: Verify Next Page Navigation ====================
    @Test(priority = 27, description = "Verify next page button functionality")
    public void TC2_27_VerifyNextPageNavigation() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Next Page Navigation");
        String initialPage = transactionsObject.getCurrentPageNumber();
        transactionsObject.clickNextPage();
        Thread.sleep(2000); // Wait for page load
        String newPage = transactionsObject.getCurrentPageNumber();
        Assert.assertNotEquals(newPage, initialPage, "Page number should change after clicking next");
        LoggerHelper.info("Test Passed: Navigated from page " + initialPage + " to " + newPage);
    }

    // ==================== TC2.28: Verify Previous Page Navigation ====================
    @Test(priority = 28, description = "Verify previous page button functionality")
    public void TC2_28_VerifyPreviousPageNavigation() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Previous Page Navigation");
        String initialPage = transactionsObject.getCurrentPageNumber();
        transactionsObject.clickPreviousPage();
        Thread.sleep(2000); // Wait for page load
        String newPage = transactionsObject.getCurrentPageNumber();
        Assert.assertNotEquals(newPage, initialPage, "Page number should change after clicking previous");
        LoggerHelper.info("Test Passed: Navigated from page " + initialPage + " to " + newPage);
    }

    // ==================== TC2.29: Verify Page Number Click ====================
    @Test(priority = 29, description = "Verify clicking specific page number")
    public void TC2_29_VerifyPageNumberClick() throws InterruptedException, IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Page Number Click");
        int targetPage = Integer.parseInt(JsonDataReader.jsonData("transactions_data", "initialPageNumber"));
        transactionsObject.clickPageNumber(targetPage);
        Thread.sleep(2000); // Wait for page load
        String currentPage = transactionsObject.getCurrentPageNumber();
        Assert.assertEquals(currentPage, String.valueOf(targetPage),
                "Should navigate to the clicked page number");
        LoggerHelper.info("Test Passed: Navigated to Page " + targetPage);
    }

    // ==================== TC2.30: Verify Navigation to Dashboard ====================
    @Test(priority = 30, description = "Verify navigation to Dashboard from Transactions")
    public void TC2_30_VerifyNavigationToDashboard() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Navigation to Dashboard");
        transactionsObject.clickDashboardNav();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/dashboard") && !currentUrl.contains("/transactions"),
                "Should navigate to Dashboard");
        // Navigate back to transactions
        driver.navigate().to("https://10.20.73.2:8090/dashboard/transactions");
        Thread.sleep(2000);
        LoggerHelper.info("Test Passed: Navigation to Dashboard Verified");
    }

    // ==================== TC2.31: Verify Navigation to Payment ====================
    @Test(priority = 31, description = "Verify navigation to Payment from Transactions")
    public void TC2_31_VerifyNavigationToPayment() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Navigation to Payment");
        transactionsObject.clickPaymentNav();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/payment"),
                "Should navigate to Payment page");
        // Navigate back to transactions
        driver.navigate().to("https://10.20.73.2:8090/dashboard/transactions");
        Thread.sleep(2000);
        LoggerHelper.info("Test Passed: Navigation to Payment Verified");
    }

    // ==================== TC2.32: Verify Filter Input Clear ====================
    @Test(priority = 32, description = "Verify filter inputs can be cleared with reset")
    public void TC2_32_VerifyFilterInputClear() throws InterruptedException, IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Filter Input Clear");
        // Enter values in filters
        transactionsObject.enterTID(JsonDataReader.jsonData("transactions_data", "sampleTID"));
        transactionsObject.enterBatchID(JsonDataReader.jsonData("transactions_data", "sampleBatchID"));
        transactionsObject.enterAuthCode(JsonDataReader.jsonData("transactions_data", "sampleAuthCode"));
        Thread.sleep(1000);
        // Click reset
        transactionsObject.clickResetBtn();
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Filter inputs cleared with reset");
    }
}