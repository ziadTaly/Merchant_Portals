package Merchant_Taly.dashboard;

import Merchant_Taly.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.LoggerHelper;

import java.util.List;

public class DashboardPage extends PageBase {

        public DashboardPage(WebDriver driver) {
                super(driver);
                PageFactory.initElements(driver, this);
        }

        // ==================== Header Elements ====================
        @FindBy(xpath = "//h2[normalize-space()='Dashboard']")
        WebElement dashboardTitle;

        @FindBy(xpath = "//button[@id='radix-«r5»']")
        WebElement themeToggleBtn;

        @FindBy(xpath = "//button[@id='radix-«r7»']")
        WebElement languageBtn;

        @FindBy(xpath = "//button[contains(@class,'hover:text-red-500')]//svg[contains(@class,'lucide-log-out')]")
        WebElement logoutBtn;

        // ==================== Sidebar Navigation ====================
        @FindBy(xpath = "//a[@href='/dashboard' and @aria-current='page']")
        WebElement dashboardNavActive;

        @FindBy(xpath = "//a[@href='/dashboard/transactions']")
        WebElement transactionsNav;

        @FindBy(xpath = "//a[@href='/dashboard/payment']")
        WebElement paymentNav;

        @FindBy(xpath = "//button[contains(@class,'group-hover:opacity-100')]//svg[contains(@class,'lucide-move-horizontal')]")
        WebElement sidebarToggleBtn;

        @FindBy(xpath = "//img[@alt='']")
        WebElement companyLogo;

        @FindBy(xpath = "//span[normalize-space()='Powered By Taly']")
        WebElement poweredByTalyText;

        // ==================== Monthly Performance Section ====================
        @FindBy(xpath = "//h3[normalize-space()='Monthly Performance']")
        WebElement monthlyPerformanceTitle;

        // Total Transaction Count Card
        @FindBy(xpath = "//h5[normalize-space()='Total Transaction Count']")
        WebElement totalTransactionCountTitle;

        @FindBy(xpath = "//h5[normalize-space()='Total Transaction Count']/ancestor::div[contains(@class,'bg-white')]//button[@value='Acceptance' and @aria-checked='true']")
        WebElement acceptanceRadioTransactionCount;

        @FindBy(xpath = "//h5[normalize-space()='Total Transaction Count']/ancestor::div[contains(@class,'bg-white')]//button[@value='BNPL']")
        WebElement bnplRadioTransactionCount;

        @FindBy(xpath = "//h5[normalize-space()='Total Transaction Count']/ancestor::div[contains(@class,'bg-white')]//div[normalize-space()='No data here, try another filter']")
        WebElement noDataMessageTransactionCount;

        // Total Volume Card
        @FindBy(xpath = "//h5[normalize-space()='Total Volume']")
        WebElement totalVolumeTitle;

        @FindBy(xpath = "//h5[normalize-space()='Total Volume']/ancestor::div[contains(@class,'bg-white')]//button[@value='Acceptance' and @aria-checked='true']")
        WebElement acceptanceRadioVolume;

        @FindBy(xpath = "//h5[normalize-space()='Total Volume']/ancestor::div[contains(@class,'bg-white')]//button[@value='BNPL']")
        WebElement bnplRadioVolume;

        @FindBy(xpath = "//h5[normalize-space()='Total Volume']/ancestor::div[contains(@class,'bg-white')]//div[normalize-space()='No data here, try another filter']")
        WebElement noDataMessageVolume;

        // Top Branches Card
        @FindBy(xpath = "//h4[normalize-space()='Top Branches']")
        WebElement topBranchesTitle;

        @FindBy(xpath = "//h4[normalize-space()='Top Branches']/ancestor::div[contains(@class,'bg-white')]//div[normalize-space()='No data here, try another filter']")
        WebElement noDataMessageTopBranches;

        // ==================== Methods ====================

        // Verify Dashboard Page Loaded
        public boolean isDashboardPageLoaded() {
                try {
                        wait.until(driver -> dashboardTitle.isDisplayed());
                        LoggerHelper.info("Dashboard page loaded successfully");
                        return true;
                } catch (Exception e) {
                        LoggerHelper.error("Dashboard page failed to load", e);
                        return false;
                }
        }

        // Verify Dashboard Title
        public String getDashboardTitle() {
                try {
                        String title = dashboardTitle.getText();
                        LoggerHelper.info("Dashboard title: " + title);
                        return title;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to get dashboard title", e);
                        return null;
                }
        }

        // Theme Toggle
        public void clickThemeToggle() {
                try {
                        clickButton(themeToggleBtn);
                        LoggerHelper.info("Theme toggle button clicked");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to click theme toggle", e);
                }
        }

        // Language Dropdown
        public void clickLanguageBtn() {
                try {
                        clickButton(languageBtn);
                        LoggerHelper.info("Language button clicked");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to click language button", e);
                }
        }

        // Logout
        public void clickLogout() {
                try {
                        clickButton(logoutBtn);
                        LoggerHelper.info("Logout button clicked");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to click logout button", e);
                }
        }

        // Sidebar Navigation
        public void clickTransactionsNav() {
                try {
                        clickButton(transactionsNav);
                        LoggerHelper.info("Navigated to Transactions page");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to navigate to Transactions", e);
                }
        }

        public void clickPaymentNav() {
                try {
                        clickButton(paymentNav);
                        LoggerHelper.info("Navigated to Payment page");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to navigate to Payment", e);
                }
        }

        public void clickDashboardNav() {
                try {
                        clickButton(dashboardNavActive);
                        LoggerHelper.info("Navigated to Dashboard page");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to navigate to Dashboard", e);
                }
        }

        public void toggleSidebar() {
                try {
                        clickButton(sidebarToggleBtn);
                        LoggerHelper.info("Sidebar toggled");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to toggle sidebar", e);
                }
        }

        // Verify Active Navigation
        public boolean isDashboardNavActive() {
                try {
                        boolean isActive = dashboardNavActive.getAttribute("aria-current").equals("page");
                        LoggerHelper.info("Dashboard navigation active status: " + isActive);
                        return isActive;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to verify dashboard nav active status", e);
                        return false;
                }
        }

        // Verify Powered By Taly
        public boolean isPoweredByTalyDisplayed() {
                try {
                        boolean isDisplayed = poweredByTalyText.isDisplayed();
                        LoggerHelper.info("Powered By Taly displayed: " + isDisplayed);
                        return isDisplayed;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to verify Powered By Taly", e);
                        return false;
                }
        }

        // Monthly Performance Section
        public boolean isMonthlyPerformanceSectionDisplayed() {
                try {
                        boolean isDisplayed = monthlyPerformanceTitle.isDisplayed();
                        LoggerHelper.info("Monthly Performance section displayed: " + isDisplayed);
                        return isDisplayed;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to verify Monthly Performance section", e);
                        return false;
                }
        }

        // Total Transaction Count Card
        public String getTotalTransactionCountTitle() {
                try {
                        String title = totalTransactionCountTitle.getText();
                        LoggerHelper.info("Total Transaction Count title: " + title);
                        return title;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to get Total Transaction Count title", e);
                        return null;
                }
        }

        public void selectAcceptanceRadioTransactionCount() {
                try {
                        clickButton(acceptanceRadioTransactionCount);
                        LoggerHelper.info("Acceptance radio selected for Transaction Count");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to select Acceptance radio for Transaction Count", e);
                }
        }

        public void selectBNPLRadioTransactionCount() {
                try {
                        clickButton(bnplRadioTransactionCount);
                        LoggerHelper.info("BNPL radio selected for Transaction Count");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to select BNPL radio for Transaction Count", e);
                }
        }

        public boolean isNoDataMessageDisplayedTransactionCount() {
                try {
                        boolean isDisplayed = noDataMessageTransactionCount.isDisplayed();
                        LoggerHelper.info("No data message displayed for Transaction Count: " + isDisplayed);
                        return isDisplayed;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to verify no data message for Transaction Count", e);
                        return false;
                }
        }

        // Total Volume Card
        public String getTotalVolumeTitle() {
                try {
                        String title = totalVolumeTitle.getText();
                        LoggerHelper.info("Total Volume title: " + title);
                        return title;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to get Total Volume title", e);
                        return null;
                }
        }

        public void selectAcceptanceRadioVolume() {
                try {
                        clickButton(acceptanceRadioVolume);
                        LoggerHelper.info("Acceptance radio selected for Volume");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to select Acceptance radio for Volume", e);
                }
        }

        public void selectBNPLRadioVolume() {
                try {
                        clickButton(bnplRadioVolume);
                        LoggerHelper.info("BNPL radio selected for Volume");
                } catch (Exception e) {
                        LoggerHelper.error("Failed to select BNPL radio for Volume", e);
                }
        }

        public boolean isNoDataMessageDisplayedVolume() {
                try {
                        boolean isDisplayed = noDataMessageVolume.isDisplayed();
                        LoggerHelper.info("No data message displayed for Volume: " + isDisplayed);
                        return isDisplayed;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to verify no data message for Volume", e);
                        return false;
                }
        }

        // Top Branches Card
        public String getTopBranchesTitle() {
                try {
                        String title = topBranchesTitle.getText();
                        LoggerHelper.info("Top Branches title: " + title);
                        return title;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to get Top Branches title", e);
                        return null;
                }
        }

        public boolean isNoDataMessageDisplayedTopBranches() {
                try {
                        boolean isDisplayed = noDataMessageTopBranches.isDisplayed();
                        LoggerHelper.info("No data message displayed for Top Branches: " + isDisplayed);
                        return isDisplayed;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to verify no data message for Top Branches", e);
                        return false;
                }
        }

        // Verify Acceptance Radio is Checked
        public boolean isAcceptanceRadioCheckedTransactionCount() {
                try {
                        boolean isChecked = acceptanceRadioTransactionCount.getAttribute("aria-checked").equals("true");
                        LoggerHelper.info("Acceptance radio checked status for Transaction Count: " + isChecked);
                        return isChecked;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to verify Acceptance radio status for Transaction Count", e);
                        return false;
                }
        }

        public boolean isAcceptanceRadioCheckedVolume() {
                try {
                        boolean isChecked = acceptanceRadioVolume.getAttribute("aria-checked").equals("true");
                        LoggerHelper.info("Acceptance radio checked status for Volume: " + isChecked);
                        return isChecked;
                } catch (Exception e) {
                        LoggerHelper.error("Failed to verify Acceptance radio status for Volume", e);
                        return false;
                }
        }
}