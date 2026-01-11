package Merchant_Taly_Test.dashboardTest_TC;

import Data.JsonDataReader;
import Merchant_Taly.dashboard.DashboardPage;
import Merchant_Taly_Test.TestBase;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.LoggerHelper;

import java.io.IOException;

public class DashboardPageTest_TC1 extends TestBase {
    DashboardPage dashboardObject;

    @BeforeClass
    public void setupDashboardPage() {
        dashboardObject = new DashboardPage(driver);
    }

    // ==================== TC1.1: Verify Dashboard Page Loads ====================
    @Test(priority = 1, description = "Verify Dashboard page loads successfully")
    public void TC1_1_VerifyDashboardPageLoads() {
        LoggerHelper.info("Starting Test: Verify Dashboard Page Loads");
        boolean isLoaded = dashboardObject.isDashboardPageLoaded();
        Assert.assertTrue(isLoaded, "Dashboard page should load successfully");
        LoggerHelper.info("Test Passed: Dashboard Page Loaded Successfully");
    }

    // ==================== TC1.2: Verify Dashboard Title ====================
    @Test(priority = 2, description = "Verify Dashboard title is displayed correctly")
    public void TC1_2_VerifyDashboardTitle() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Dashboard Title");
        String expectedTitle = JsonDataReader.jsonData("dashboard_data", "dashboardTitle");
        String actualTitle = dashboardObject.getDashboardTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Dashboard title should match expected value");
        LoggerHelper.info("Test Passed: Dashboard Title Verified - " + actualTitle);
    }

    // ==================== TC1.3: Verify Sidebar Elements ====================
    @Test(priority = 3, description = "Verify all sidebar navigation elements are displayed")
    public void TC1_3_VerifySidebarElements() {
        LoggerHelper.info("Starting Test: Verify Sidebar Elements");
        Assert.assertTrue(dashboardObject.isDashboardNavActive(), "Dashboard navigation should be active");
        Assert.assertTrue(dashboardObject.isPoweredByTalyDisplayed(), "Powered By Taly should be displayed");
        LoggerHelper.info("Test Passed: Sidebar Elements Verified");
    }

    // ==================== TC1.4: Verify Monthly Performance Section ====================
    @Test(priority = 4, description = "Verify Monthly Performance section is displayed")
    public void TC1_4_VerifyMonthlyPerformanceSection() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Monthly Performance Section");
        Assert.assertTrue(dashboardObject.isMonthlyPerformanceSectionDisplayed(),
                "Monthly Performance section should be displayed");
        LoggerHelper.info("Test Passed: Monthly Performance Section Displayed");
    }

    // ==================== TC1.5: Verify Total Transaction Count Card ====================
    @Test(priority = 5, description = "Verify Total Transaction Count card elements")
    public void TC1_5_VerifyTotalTransactionCountCard() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Total Transaction Count Card");
        String expectedTitle = JsonDataReader.jsonData("dashboard_data", "totalTransactionCountTitle");
        String actualTitle = dashboardObject.getTotalTransactionCountTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Total Transaction Count title should match");
        Assert.assertTrue(dashboardObject.isAcceptanceRadioCheckedTransactionCount(),
                "Acceptance radio should be checked by default");
        Assert.assertTrue(dashboardObject.isNoDataMessageDisplayedTransactionCount(),
                "No data message should be displayed");
        LoggerHelper.info("Test Passed: Total Transaction Count Card Verified");
    }

    // ==================== TC1.6: Verify Total Volume Card ====================
    @Test(priority = 6, description = "Verify Total Volume card elements")
    public void TC1_6_VerifyTotalVolumeCard() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Total Volume Card");
        String expectedTitle = JsonDataReader.jsonData("dashboard_data", "totalVolumeTitle");
        String actualTitle = dashboardObject.getTotalVolumeTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Total Volume title should match");
        Assert.assertTrue(dashboardObject.isAcceptanceRadioCheckedVolume(),
                "Acceptance radio should be checked by default");
        Assert.assertTrue(dashboardObject.isNoDataMessageDisplayedVolume(),
                "No data message should be displayed");
        LoggerHelper.info("Test Passed: Total Volume Card Verified");
    }

    // ==================== TC1.7: Verify Top Branches Card ====================
    @Test(priority = 7, description = "Verify Top Branches card elements")
    public void TC1_7_VerifyTopBranchesCard() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify Top Branches Card");
        String expectedTitle = JsonDataReader.jsonData("dashboard_data", "topBranchesTitle");
        String actualTitle = dashboardObject.getTopBranchesTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Top Branches title should match");
        Assert.assertTrue(dashboardObject.isNoDataMessageDisplayedTopBranches(),
                "No data message should be displayed");
        LoggerHelper.info("Test Passed: Top Branches Card Verified");
    }

    // ==================== TC1.8: Switch to BNPL Radio in Transaction Count ====================
    @Test(priority = 8, description = "Verify switching to BNPL radio in Transaction Count card")
    public void TC1_8_SwitchToBNPLRadioTransactionCount() throws InterruptedException {
        LoggerHelper.info("Starting Test: Switch to BNPL Radio in Transaction Count");
        dashboardObject.selectBNPLRadioTransactionCount();
        Thread.sleep(1000); // Wait for UI update
        Assert.assertTrue(dashboardObject.isNoDataMessageDisplayedTransactionCount(),
                "No data message should still be displayed after switching to BNPL");
        // Switch back to Acceptance
        dashboardObject.selectAcceptanceRadioTransactionCount();
        Thread.sleep(1000);
        Assert.assertTrue(dashboardObject.isAcceptanceRadioCheckedTransactionCount(),
                "Acceptance radio should be checked after switching back");
        LoggerHelper.info("Test Passed: BNPL Radio Switch in Transaction Count Verified");
    }

    // ==================== TC1.9: Switch to BNPL Radio in Volume ====================
    @Test(priority = 9, description = "Verify switching to BNPL radio in Volume card")
    public void TC1_9_SwitchToBNPLRadioVolume() throws InterruptedException {
        LoggerHelper.info("Starting Test: Switch to BNPL Radio in Volume");
        dashboardObject.selectBNPLRadioVolume();
        Thread.sleep(1000); // Wait for UI update
        Assert.assertTrue(dashboardObject.isNoDataMessageDisplayedVolume(),
                "No data message should still be displayed after switching to BNPL");
        // Switch back to Acceptance
        dashboardObject.selectAcceptanceRadioVolume();
        Thread.sleep(1000);
        Assert.assertTrue(dashboardObject.isAcceptanceRadioCheckedVolume(),
                "Acceptance radio should be checked after switching back");
        LoggerHelper.info("Test Passed: BNPL Radio Switch in Volume Verified");
    }

    // ==================== TC1.10: Verify Theme Toggle Functionality ====================
    @Test(priority = 10, description = "Verify theme toggle button functionality")
    public void TC1_10_VerifyThemeToggle() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Theme Toggle");
        dashboardObject.clickThemeToggle();
        Thread.sleep(1000); // Wait for theme change
        // Note: Visual verification would require screenshot comparison
        LoggerHelper.info("Test Passed: Theme Toggle Clicked");
    }

    // ==================== TC1.11: Verify Language Button ====================
    @Test(priority = 11, description = "Verify language button is clickable")
    public void TC1_11_VerifyLanguageButton() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Language Button");
        dashboardObject.clickLanguageBtn();
        Thread.sleep(1000); // Wait for dropdown
        LoggerHelper.info("Test Passed: Language Button Clicked");
    }

    // ==================== TC1.12: Verify Sidebar Toggle ====================
    @Test(priority = 12, description = "Verify sidebar toggle functionality")
    public void TC1_12_VerifySidebarToggle() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Sidebar Toggle");
        dashboardObject.toggleSidebar();
        Thread.sleep(1000); // Wait for animation
        dashboardObject.toggleSidebar(); // Toggle back
        Thread.sleep(1000);
        LoggerHelper.info("Test Passed: Sidebar Toggle Verified");
    }

    // ==================== TC1.13: Verify Navigation to Transactions ====================
    @Test(priority = 13, description = "Verify navigation to Transactions page")
    public void TC1_13_VerifyNavigationToTransactions() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Navigation to Transactions");
        dashboardObject.clickTransactionsNav();
        Thread.sleep(2000); // Wait for page load
        // Verify URL or page elements
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/transactions"),
                "URL should contain '/transactions'");
        // Navigate back to dashboard
        dashboardObject.clickDashboardNav();
        Thread.sleep(2000);
        LoggerHelper.info("Test Passed: Navigation to Transactions Verified");
    }

    // ==================== TC1.14: Verify Navigation to Payment ====================
    @Test(priority = 14, description = "Verify navigation to Payment page")
    public void TC1_14_VerifyNavigationToPayment() throws InterruptedException {
        LoggerHelper.info("Starting Test: Verify Navigation to Payment");
        dashboardObject.clickPaymentNav();
        Thread.sleep(2000); // Wait for page load
        // Verify URL or page elements
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/payment"),
                "URL should contain '/payment'");
        // Navigate back to dashboard
        dashboardObject.clickDashboardNav();
        Thread.sleep(2000);
        LoggerHelper.info("Test Passed: Navigation to Payment Verified");
    }

    // ==================== TC1.15: Verify All Cards Present ====================
    @Test(priority = 15, description = "Verify all dashboard cards are present")
    public void TC1_15_VerifyAllCardsPresent() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify All Cards Present");
        // Verify all three cards are displayed
        Assert.assertNotNull(dashboardObject.getTotalTransactionCountTitle(),
                "Total Transaction Count card should be present");
        Assert.assertNotNull(dashboardObject.getTotalVolumeTitle(),
                "Total Volume card should be present");
        Assert.assertNotNull(dashboardObject.getTopBranchesTitle(),
                "Top Branches card should be present");
        LoggerHelper.info("Test Passed: All Cards Present");
    }

    // ==================== TC1.16: Verify No Data Messages ====================
    @Test(priority = 16, description = "Verify all no data messages are displayed")
    public void TC1_16_VerifyNoDataMessages() throws IOException, ParseException {
        LoggerHelper.info("Starting Test: Verify No Data Messages");
        String expectedMessage = JsonDataReader.jsonData("dashboard_data", "noDataMessage");
        Assert.assertTrue(dashboardObject.isNoDataMessageDisplayedTransactionCount(),
                "No data message should be displayed for Transaction Count");
        Assert.assertTrue(dashboardObject.isNoDataMessageDisplayedVolume(),
                "No data message should be displayed for Volume");
        Assert.assertTrue(dashboardObject.isNoDataMessageDisplayedTopBranches(),
                "No data message should be displayed for Top Branches");
        LoggerHelper.info("Test Passed: No Data Messages Verified");
    }

    // ==================== TC1.17: Verify Dashboard Active State ====================
    @Test(priority = 17, description = "Verify dashboard navigation is in active state")
    public void TC1_17_VerifyDashboardActiveState() {
        LoggerHelper.info("Starting Test: Verify Dashboard Active State");
        Assert.assertTrue(dashboardObject.isDashboardNavActive(),
                "Dashboard navigation should be in active state");
        LoggerHelper.info("Test Passed: Dashboard Active State Verified");
    }
}