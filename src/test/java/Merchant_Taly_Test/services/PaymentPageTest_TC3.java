package Merchant_Taly_Test.services;

import Data.JsonDataReader;
import Merchant_Taly.dashboard.DashboardPage;
import Merchant_Taly.services.PaymentPage;
import Merchant_Taly.services.PaymentPage;
import Merchant_Taly_Test.TestBase;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.LoggerHelper;

import java.io.IOException;

public class PaymentPageTest_TC3 extends TestBase {
    PaymentPage paymentObject;

    @BeforeClass
    public void setupPaymentPage() throws InterruptedException {
        paymentObject = new PaymentPage(driver);
        // Navigate to Payment page
        driver.navigate().to("https://10.20.73.2:8090/dashboard/payment");
        Thread.sleep(2000);
    }

    // ==================== TC3.1: Verify Payment Page Loads ====================
    @Test(priority = 1, description = "Verify Payment page loads successfully")
    public void TC3_1_VerifyPaymentPageLoads() {
        LoggerHelper.info("Starting Test: Verify Payment Page Loads");
        boolean isLoaded = paymentObject.isPaymentPageLoaded();
        Assert.assertTrue(isLoaded, "Payment page should load successfully");
        LoggerHelper.info("Test Passed: Payment Page Loaded Successfully");
    }

    // ==================== TC3.2: Verify Payment Navigation Active ====================
    @Test(priority = 2, description = "Verify Payment navigation is in active state")
    public void TC3_2_VerifyPaymentNavActive() {
        LoggerHelper.info("Starting Test: Verify Payment Navigation Active");
        Assert.assertTrue(paymentObject.isPaymentNavActive(),
                "Payment navigation should be in active state");
        LoggerHelper.info("Test Passed: Payment Navigation Active");
    }

    // ==================== TC3.3: Verify Single Payment Tab ====================
    @Test(priority = 3, description = "Verify Single Payment tab is active by default")
    public void TC3_3_VerifySinglePaymentTabActive() {
        LoggerHelper.info("Starting Test: Verify Single Payment Tab Active");
        Assert.assertTrue(paymentObject.isSinglePaymentTabActive(),
                "Single Payment tab should be active by default");
        LoggerHelper.info("Test Passed: Single Payment Tab Active");
    }

    // ==================== TC3.4: Verify Form Title ====================
    @Test(priority = 4, description = "Verify payment form title is displayed")
    public void TC3_4_VerifyFormTitle() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Form Title");
        String expectedTitle = JsonDataReader.jsonData("payment_data", "formTitle");
        String actualTitle = paymentObject.getFormTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Form title should match");
        LoggerHelper.info("Test Passed: Form Title Verified - " + actualTitle);
    }

    // ==================== TC3.5: Verify All Form Fields Displayed ====================
    @Test(priority = 5, description = "Verify all payment form fields are displayed")
    public void TC3_5_VerifyAllFormFieldsDisplayed() {
        LoggerHelper.info("Starting Test: Verify All Form Fields Displayed");
        Assert.assertTrue(paymentObject.areAllFormFieldsDisplayed(),
                "All form fields should be displayed");
        LoggerHelper.info("Test Passed: All Form Fields Displayed");
    }

    // ==================== TC3.6: Verify Mobile Number Field ====================
    @Test(priority = 6, description = "Verify mobile number field accepts input")
    public void TC3_6_VerifyMobileNumberField() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Mobile Number Field");
        String mobileNumber = JsonDataReader.jsonData("payment_data", "sampleMobileNumber");
        paymentObject.enterMobileNumber(mobileNumber);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Mobile Number Field Verified");
    }

    // ==================== TC3.7: Verify Amount Field ====================
    @Test(priority = 7, description = "Verify amount field accepts input")
    public void TC3_7_VerifyAmountField() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Amount Field");
        String amount = JsonDataReader.jsonData("payment_data", "sampleAmount");
        paymentObject.enterAmount(amount);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Amount Field Verified");
    }

    // ==================== TC3.8: Verify Fee Field ====================
    @Test(priority = 8, description = "Verify fee field accepts input")
    public void TC3_8_VerifyFeeField() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Fee Field");
        String fee = JsonDataReader.jsonData("payment_data", "sampleFee");
        paymentObject.enterFee(fee);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Fee Field Verified");
    }

    // ==================== TC3.9: Verify Discount Field ====================
    @Test(priority = 9, description = "Verify discount field accepts input")
    public void TC3_9_VerifyDiscountField() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Discount Field");
        String discount = JsonDataReader.jsonData("payment_data", "sampleDiscount");
        paymentObject.enterDiscount(discount);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Discount Field Verified");
    }

    // ==================== TC3.10: Verify Order Number Field ====================
    @Test(priority = 10, description = "Verify order number field accepts input")
    public void TC3_10_VerifyOrderNumberField() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Order Number Field");
        String orderNumber = JsonDataReader.jsonData("payment_data", "sampleOrderNumber");
        paymentObject.enterOrderNumber(orderNumber);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Order Number Field Verified");
    }

    // ==================== TC3.11: Verify Description Field ====================
    @Test(priority = 11, description = "Verify description field accepts input")
    public void TC3_11_VerifyDescriptionField() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Description Field");
        String description = JsonDataReader.jsonData("payment_data", "sampleDescription");
        paymentObject.enterDescription(description);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Description Field Verified");
    }

    // ==================== TC3.12: Verify Customer Name Field ====================
    @Test(priority = 12, description = "Verify customer name field accepts input")
    public void TC3_12_VerifyCustomerNameField() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Customer Name Field");
        String customerName = JsonDataReader.jsonData("payment_data", "sampleCustomerName");
        paymentObject.enterCustomerName(customerName);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Customer Name Field Verified");
    }

    // ==================== TC3.13: Verify Item Name Field ====================
    @Test(priority = 13, description = "Verify item name field accepts input")
    public void TC3_13_VerifyItemNameField() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Item Name Field");
        String itemName = JsonDataReader.jsonData("payment_data", "sampleItemName");
        paymentObject.enterItemName(itemName);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Item Name Field Verified");
    }

    // ==================== TC3.14: Verify Session Timeout Field ====================
    @Test(priority = 14, description = "Verify session timeout field accepts input")
    public void TC3_14_VerifySessionTimeoutField() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Session Timeout Field");
        String sessionTimeout = JsonDataReader.jsonData("payment_data", "sampleSessionTimeout");
        paymentObject.enterSessionTimeout(sessionTimeout);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Session Timeout Field Verified");
    }

    // ==================== TC3.15: Verify Merchant URL Field ====================
    @Test(priority = 15, description = "Verify merchant URL field accepts input")
    public void TC3_15_VerifyMerchantUrlField() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Merchant URL Field");
        String merchantUrl = JsonDataReader.jsonData("payment_data", "sampleMerchantUrl");
        paymentObject.enterMerchantUrl(merchantUrl);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Merchant URL Field Verified");
    }

    // ==================== TC3.16: Verify Submit Button ====================
    @Test(priority = 16, description = "Verify submit button is displayed")
    public void TC3_16_VerifySubmitButton() {
        LoggerHelper.info("Starting Test: Verify Submit Button");
        Assert.assertTrue(paymentObject.isSubmitBtnDisplayed(),
                "Submit button should be displayed");
        LoggerHelper.info("Test Passed: Submit Button Displayed");
    }

    // ==================== TC3.17: Verify Complete Form Fill ====================
    @Test(priority = 17, description = "Verify filling complete payment form")
    public void TC3_17_VerifyCompleteFormFill() throws IOException, ParseException, InterruptedException {
        LoggerHelper.info("Starting Test: Verify Complete Form Fill");
        // Refresh page to clear previous inputs
        driver.navigate().refresh();
        Thread.sleep(2000);

        String mobileNumber = JsonDataReader.jsonData("payment_data", "sampleMobileNumber");
        String amount = JsonDataReader.jsonData("payment_data", "sampleAmount");
        String fee = JsonDataReader.jsonData("payment_data", "sampleFee");
        String discount = JsonDataReader.jsonData("payment_data", "sampleDiscount");
        String orderNumber = JsonDataReader.jsonData("payment_data", "sampleOrderNumber");
        String description = JsonDataReader.jsonData("payment_data", "sampleDescription");
        String customerName = JsonDataReader.jsonData("payment_data", "sampleCustomerName");
        String itemName = JsonDataReader.jsonData("payment_data", "sampleItemName");
        String sessionTimeout = JsonDataReader.jsonData("payment_data", "sampleSessionTimeout");
        String merchantUrl = JsonDataReader.jsonData("payment_data", "sampleMerchantUrl");

        paymentObject.fillPaymentForm(mobileNumber, amount, fee, discount, orderNumber,
                description, customerName, itemName, sessionTimeout, merchantUrl);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Complete Form Filled Successfully");
    }

    // ==================== TC3.18: Verify Mobile Number Placeholder ====================
    @Test(priority = 18, description = "Verify mobile number field placeholder")
    public void TC3_18_VerifyMobileNumberPlaceholder() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Mobile Number Placeholder");
        String expectedPlaceholder = JsonDataReader.jsonData("payment_data", "mobileNumberPlaceholder");
        String actualPlaceholder = paymentObject.getMobileNumberPlaceholder();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Mobile number placeholder should match");
        LoggerHelper.info("Test Passed: Mobile Number Placeholder Verified");
    }

    // ==================== TC3.19: Verify Mobile Number Max Length ====================
    @Test(priority = 19, description = "Verify mobile number field max length")
    public void TC3_19_VerifyMobileNumberMaxLength() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Mobile Number Max Length");
        String expectedMaxLength = JsonDataReader.jsonData("payment_data", "mobileNumberMaxLength");
        String actualMaxLength = paymentObject.getMaxLengthMobileNumber();
        Assert.assertEquals(actualMaxLength, expectedMaxLength, "Mobile number max length should match");
        LoggerHelper.info("Test Passed: Mobile Number Max Length - " + actualMaxLength);
    }

    // ==================== TC3.20: Verify Payment History Title ====================
    @Test(priority = 20, description = "Verify payment history section title")
    public void TC3_20_VerifyPaymentHistoryTitle() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Payment History Title");
        String expectedTitle = JsonDataReader.jsonData("payment_data", "paymentHistoryTitle");
        String actualTitle = paymentObject.getPaymentHistoryTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Payment history title should match");
        LoggerHelper.info("Test Passed: Payment History Title Verified");
    }

    // ==================== TC3.21: Verify Table Headers ====================
    @Test(priority = 21, description = "Verify all table headers are displayed")
    public void TC3_21_VerifyTableHeaders() {
        LoggerHelper.info("Starting Test: Verify Table Headers");
        Assert.assertTrue(paymentObject.areAllTableHeadersDisplayed(),
                "All table headers should be displayed");
        LoggerHelper.info("Test Passed: Table Headers Verified");
    }

    // ==================== TC3.22: Verify Table Has Data ====================
    @Test(priority = 22, description = "Verify table contains payment history data")
    public void TC3_22_VerifyTableHasData() {
        LoggerHelper.info("Starting Test: Verify Table Has Data");
        int rowCount = paymentObject.getTableRowCount();
        Assert.assertTrue(rowCount > 0, "Table should contain at least one row");
        LoggerHelper.info("Test Passed: Table Row Count - " + rowCount);
    }

    // ==================== TC3.23: Verify Select All Checkbox ====================
    @Test(priority = 23, description = "Verify select all checkbox functionality")
    public void TC3_23_VerifySelectAllCheckbox() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Select All Checkbox");
        paymentObject.clickSelectAllCheckbox();
        Thread.sleep(1000);
        // Click again to unselect
        paymentObject.clickSelectAllCheckbox();
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Select All Checkbox Verified");
    }

    // ==================== TC3.24: Verify Row Checkbox ====================
    @Test(priority = 24, description = "Verify row checkbox can be clicked")
    public void TC3_24_VerifyRowCheckbox() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Row Checkbox");
        paymentObject.clickRowCheckbox(0);
        Thread.sleep(1000);
        // Click again to uncheck
        paymentObject.clickRowCheckbox(0);
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Row Checkbox Verified");
    }

    // ==================== TC3.25: Verify MSISDN Display ====================
    @Test(priority = 25, description = "Verify MSISDN is displayed in table")
    public void TC3_25_VerifyMSISDNDisplay() {
        LoggerHelper.info("Starting Test: Verify MSISDN Display");
        String msisdn = paymentObject.getMSISDNAtRow(0);
        Assert.assertNotNull(msisdn, "MSISDN should not be null");
        Assert.assertTrue(msisdn.length() > 0, "MSISDN should have value");
        LoggerHelper.info("Test Passed: MSISDN - " + msisdn);
    }

    // ==================== TC3.26: Verify Amount Display ====================
    @Test(priority = 26, description = "Verify amount is displayed in table")
    public void TC3_26_VerifyAmountDisplay() {
        LoggerHelper.info("Starting Test: Verify Amount Display");
        String amount = paymentObject.getAmountAtRow(0);
        Assert.assertNotNull(amount, "Amount should not be null");
        LoggerHelper.info("Test Passed: Amount - " + amount);
    }

    // ==================== TC3.27: Verify Status Display ====================
    @Test(priority = 27, description = "Verify status is displayed in table")
    public void TC3_27_VerifyStatusDisplay() {
        LoggerHelper.info("Starting Test: Verify Status Display");
        String status = paymentObject.getStatusAtRow(0);
        Assert.assertNotNull(status, "Status should not be null");
        LoggerHelper.info("Test Passed: Status - " + status);
    }

    // ==================== TC3.28: Verify Pagination Displayed ====================
    @Test(priority = 28, description = "Verify pagination is displayed")
    public void TC3_28_VerifyPaginationDisplayed() {
        LoggerHelper.info("Starting Test: Verify Pagination Displayed");
        Assert.assertTrue(paymentObject.isPaginationDisplayed(),
                "Pagination should be displayed");
        LoggerHelper.info("Test Passed: Pagination Displayed");
    }

    // ==================== TC3.29: Verify Current Page Number ====================
    @Test(priority = 29, description = "Verify current page number is displayed")
    public void TC3_29_VerifyCurrentPageNumber() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Current Page Number");
        String currentPage = paymentObject.getCurrentPageNumber();
        Assert.assertNotNull(currentPage, "Current page number should not be null");
        String expectedPage = JsonDataReader.jsonData("payment_data", "initialPageNumber");
        Assert.assertEquals(currentPage, expectedPage, "Should be on page 1 initially");
        LoggerHelper.info("Test Passed: Current Page Number - " + currentPage);
    }

    // ==================== TC3.30: Verify Next Page Navigation ====================
    @Test(priority = 30, description = "Verify next page button functionality")
    public void TC3_30_VerifyNextPageNavigation() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Next Page Navigation");
        String initialPage = paymentObject.getCurrentPageNumber();
        paymentObject.clickNextPage();
        Thread.sleep(2000); // Wait for page load
        String newPage = paymentObject.getCurrentPageNumber();
        Assert.assertNotEquals(newPage, initialPage, "Page number should change after clicking next");
        LoggerHelper.info("Test Passed: Navigated from page " + initialPage + " to " + newPage);
    }

    // ==================== TC3.31: Verify Previous Page Navigation ====================
    @Test(priority = 31, description = "Verify previous page button functionality")
    public void TC3_31_VerifyPreviousPageNavigation() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Previous Page Navigation");
        String initialPage = paymentObject.getCurrentPageNumber();
        paymentObject.clickPreviousPage();
        Thread.sleep(2000); // Wait for page load
        String newPage = paymentObject.getCurrentPageNumber();
        Assert.assertNotEquals(newPage, initialPage, "Page number should change after clicking previous");
        LoggerHelper.info("Test Passed: Navigated from page " + initialPage + " to " + newPage);
    }

    // ==================== TC3.32: Verify Page Number Click ====================
    @Test(priority = 32, description = "Verify clicking specific page number")
    public void TC3_32_VerifyPageNumberClick() throws InterruptedException, IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Page Number Click");
        int targetPage = Integer.parseInt(JsonDataReader.jsonData("payment_data", "initialPageNumber"));
        paymentObject.clickPageNumber(targetPage);
        Thread.sleep(2000); // Wait for page load
        String currentPage = paymentObject.getCurrentPageNumber();
        Assert.assertEquals(currentPage, String.valueOf(targetPage),
                "Should navigate to the clicked page number");
        LoggerHelper.info("Test Passed: Navigated to Page " + targetPage);
    }

    // ==================== TC3.33: Verify Bulk Payment Tab ====================
    @Test(priority = 33, description = "Verify bulk payment tab is clickable")
    public void TC3_33_VerifyBulkPaymentTab() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Bulk Payment Tab");
        paymentObject.clickBulkPaymentTab();
        Thread.sleep(1000);
        // Click back to single payment
        paymentObject.clickSinglePaymentTab();
        Thread.sleep(1000);
        Assert.assertTrue(paymentObject.isSinglePaymentTabActive(),
                "Single payment tab should be active after clicking back");
        LoggerHelper.info("Test Passed: Bulk Payment Tab Verified");
    }

    // ==================== TC3.34: Verify Navigation to Dashboard ====================
    @Test(priority = 34, description = "Verify navigation to Dashboard from Payment")
    public void TC3_34_VerifyNavigationToDashboard() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Navigation to Dashboard");
        paymentObject.clickDashboardNav();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/dashboard") && !currentUrl.contains("/payment"),
                "Should navigate to Dashboard");
        // Navigate back to payment
        driver.navigate().to("https://10.20.73.2:8090/dashboard/payment");
        Thread.sleep(2000);
        LoggerHelper.info("Test Passed: Navigation to Dashboard Verified");
    }

    // ==================== TC3.35: Verify Navigation to Transactions ====================
    @Test(priority = 35, description = "Verify navigation to Transactions from Payment")
    public void TC3_35_VerifyNavigationToTransactions() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Navigation to Transactions");
        paymentObject.clickTransactionsNav();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/transactions"),
                "Should navigate to Transactions page");
        // Navigate back to payment
        driver.navigate().to("https://10.20.73.2:8090/dashboard/payment");
        Thread.sleep(2000);
        LoggerHelper.info("Test Passed: Navigation to Transactions Verified");
    }
}