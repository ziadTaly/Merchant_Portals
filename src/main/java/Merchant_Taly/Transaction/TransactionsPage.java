package Merchant_Taly.Transaction;

import Merchant_Taly.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.LoggerHelper;

import java.util.List;

public class TransactionsPage extends PageBase {

    public TransactionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ==================== Header Elements ====================
    @FindBy(xpath = "//h2[normalize-space()='Dashboard']")
    WebElement pageHeaderTitle;

    @FindBy(xpath = "//button[@id='radix-«r5»']")
    WebElement themeToggleBtn;

    @FindBy(xpath = "//button[@id='radix-«r7»']")
    WebElement languageBtn;

    @FindBy(xpath = "//button[contains(@class,'hover:text-red-500')]//svg[contains(@class,'lucide-log-out')]")
    WebElement logoutBtn;

    // ==================== Sidebar Navigation ====================
    @FindBy(xpath = "//a[@href='/dashboard']")
    WebElement dashboardNav;

    @FindBy(xpath = "//a[@href='/dashboard/transactions' and @aria-current='page']")
    WebElement transactionsNavActive;

    @FindBy(xpath = "//a[@href='/dashboard/payment']")
    WebElement paymentNav;

    // ==================== Filters Section ====================
    @FindBy(xpath = "//h3[normalize-space()='Filters']")
    WebElement filtersTitle;

    // Date Range Picker
    @FindBy(xpath = "//button[@id='date']")
    WebElement dateRangePicker;

    @FindBy(xpath = "//span[normalize-space()='Pick Date Range']")
    WebElement dateRangePickerText;

    // Transaction Type Dropdown
    @FindBy(xpath = "//button[normalize-space()='Transactions Type']")
    WebElement transactionTypeDropdown;

    // Channel Type Dropdown
    @FindBy(xpath = "//button[normalize-space()='Select Channel Type']")
    WebElement channelTypeDropdown;

    // Transaction Scheme Dropdown
    @FindBy(xpath = "//button[normalize-space()='Select Transaction Scheme']")
    WebElement transactionSchemeDropdown;

    // TID Input
    @FindBy(xpath = "//input[@placeholder='TID']")
    WebElement tidInput;

    // Batch ID Input
    @FindBy(xpath = "//input[@placeholder='Batch ID']")
    WebElement batchIdInput;

    // Auth Code Input
    @FindBy(xpath = "//input[@placeholder='Auth Code']")
    WebElement authCodeInput;

    // Transaction Status Dropdown
    @FindBy(xpath = "//button[normalize-space()='Transactions Status']")
    WebElement transactionStatusDropdown;

    // Branch Dropdown
    @FindBy(xpath = "//button[normalize-space()='Select Branch']")
    WebElement branchDropdown;

    // Reset Button
    @FindBy(xpath = "//button[.//span[normalize-space()='Reset']]")
    WebElement resetBtn;

    // Apply Filters Button
    @FindBy(xpath = "//button[.//span[normalize-space()='Apply Filters']]")
    WebElement applyFiltersBtn;

    // ==================== Transactions Section ====================
    @FindBy(xpath = "//h3[normalize-space()='Transactions']")
    WebElement transactionsTitle;

    // Total Gross Amount
    @FindBy(xpath = "//p[contains(text(),'Total Gross Amount:')]")
    WebElement totalGrossAmount;

    // Export Button
    @FindBy(xpath = "//button[normalize-space()='Export as (xlsx)']")
    WebElement exportBtn;

    // ==================== Table Elements ====================
    // Table Header Checkbox
    @FindBy(xpath = "//thead//button[@role='checkbox' and @aria-label='Select all']")
    WebElement selectAllCheckbox;

    // Table Headers
    @FindBy(xpath = "//th[normalize-space()='Merchant Name']")
    WebElement merchantNameHeader;

    @FindBy(xpath = "//th[normalize-space()='MID']")
    WebElement midHeader;

    @FindBy(xpath = "//th[normalize-space()='TID']")
    WebElement tidHeader;

    @FindBy(xpath = "//th[normalize-space()='Mask PAN']")
    WebElement maskPanHeader;

    @FindBy(xpath = "//th[normalize-space()='Service']")
    WebElement serviceHeader;

    @FindBy(xpath = "//th[normalize-space()='Gross Amount']")
    WebElement grossAmountHeader;

    @FindBy(xpath = "//th[normalize-space()='MDR']")
    WebElement mdrHeader;

    @FindBy(xpath = "//th[normalize-space()='Net Amount']")
    WebElement netAmountHeader;

    @FindBy(xpath = "//th[normalize-space()='Transactions Type']")
    WebElement transactionTypeHeader;

    @FindBy(xpath = "//th[normalize-space()='Transactions Scheme']")
    WebElement transactionSchemeHeader;

    @FindBy(xpath = "//th[normalize-space()='Transactions Status']")
    WebElement transactionStatusHeader;

    // Table Rows
    @FindBy(xpath = "//tbody/tr")
    List<WebElement> tableRows;

    // Row Checkboxes
    @FindBy(xpath = "//tbody//button[@role='checkbox']")
    List<WebElement> rowCheckboxes;

    // Merchant Names in Table
    @FindBy(xpath = "//tbody//td[2]//span")
    List<WebElement> merchantNames;

    // Transaction Types in Table
    @FindBy(xpath = "//tbody//td[10]//div[contains(@class,'bg-indigo-200') or contains(@class,'bg-red-200')]")
    List<WebElement> transactionTypes;

    // Transaction Statuses in Table
    @FindBy(xpath = "//tbody//td[12]//div[contains(@class,'bg-bankColor')]")
    List<WebElement> transactionStatuses;

    // Row Action Buttons (3-dot menu)
    @FindBy(xpath = "//tbody//button[.//svg[contains(@class,'lucide-ellipsis')]]")
    List<WebElement> rowActionButtons;

    // ==================== Pagination Elements ====================
    @FindBy(xpath = "//nav[@role='navigation' and @aria-label='pagination']")
    WebElement paginationNav;

    @FindBy(xpath = "//a[@aria-label='Go to previous page']")
    WebElement previousPageBtn;

    @FindBy(xpath = "//a[@aria-label='Go to next page']")
    WebElement nextPageBtn;

    @FindBy(xpath = "//a[@aria-current='page']")
    WebElement currentPageNumber;

    @FindBy(xpath = "//nav[@role='navigation']//a[not(@aria-label)]")
    List<WebElement> paginationNumbers;

    // ==================== Methods ====================

    // Verify Transactions Page Loaded
    public boolean isTransactionsPageLoaded() {
        try {
            wait.until(driver -> transactionsTitle.isDisplayed());
            LoggerHelper.info("Transactions page loaded successfully");
            return true;
        } catch (Exception e) {
            LoggerHelper.error("Transactions page failed to load", e);
            return false;
        }
    }

    // Verify Transactions Navigation is Active
    public boolean isTransactionsNavActive() {
        try {
            boolean isActive = transactionsNavActive.getAttribute("aria-current").equals("page");
            LoggerHelper.info("Transactions navigation active status: " + isActive);
            return isActive;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify transactions nav active status", e);
            return false;
        }
    }

    // ==================== Filter Section Methods ====================
    public String getFiltersTitle() {
        try {
            String title = filtersTitle.getText();
            LoggerHelper.info("Filters title: " + title);
            return title;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get filters title", e);
            return null;
        }
    }

    public void clickDateRangePicker() {
        try {
            clickButton(dateRangePicker);
            LoggerHelper.info("Date range picker clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click date range picker", e);
        }
    }

    public void clickTransactionTypeDropdown() {
        try {
            clickButton(transactionTypeDropdown);
            LoggerHelper.info("Transaction type dropdown clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click transaction type dropdown", e);
        }
    }

    public void clickChannelTypeDropdown() {
        try {
            clickButton(channelTypeDropdown);
            LoggerHelper.info("Channel type dropdown clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click channel type dropdown", e);
        }
    }

    public void clickTransactionSchemeDropdown() {
        try {
            clickButton(transactionSchemeDropdown);
            LoggerHelper.info("Transaction scheme dropdown clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click transaction scheme dropdown", e);
        }
    }

    public void enterTID(String tid) {
        try {
            send_Text(tidInput, tid);
            LoggerHelper.info("TID entered: " + tid);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter TID", e);
        }
    }

    public void enterBatchID(String batchId) {
        try {
            send_Text(batchIdInput, batchId);
            LoggerHelper.info("Batch ID entered: " + batchId);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter Batch ID", e);
        }
    }

    public void enterAuthCode(String authCode) {
        try {
            send_Text(authCodeInput, authCode);
            LoggerHelper.info("Auth Code entered: " + authCode);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter Auth Code", e);
        }
    }

    public void clickTransactionStatusDropdown() {
        try {
            clickButton(transactionStatusDropdown);
            LoggerHelper.info("Transaction status dropdown clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click transaction status dropdown", e);
        }
    }

    public void clickBranchDropdown() {
        try {
            clickButton(branchDropdown);
            LoggerHelper.info("Branch dropdown clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click branch dropdown", e);
        }
    }

    public void clickResetBtn() {
        try {
            clickButton(resetBtn);
            LoggerHelper.info("Reset button clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click reset button", e);
        }
    }

    public void clickApplyFiltersBtn() {
        try {
            clickButton(applyFiltersBtn);
            LoggerHelper.info("Apply filters button clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click apply filters button", e);
        }
    }

    public boolean isResetBtnDisplayed() {
        try {
            boolean isDisplayed = resetBtn.isDisplayed();
            LoggerHelper.info("Reset button displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify reset button", e);
            return false;
        }
    }

    public boolean isApplyFiltersBtnDisplayed() {
        try {
            boolean isDisplayed = applyFiltersBtn.isDisplayed();
            LoggerHelper.info("Apply filters button displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify apply filters button", e);
            return false;
        }
    }

    // ==================== Transactions Section Methods ====================
    public String getTransactionsTitle() {
        try {
            String title = transactionsTitle.getText();
            LoggerHelper.info("Transactions title: " + title);
            return title;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get transactions title", e);
            return null;
        }
    }

    public String getTotalGrossAmount() {
        try {
            String amount = totalGrossAmount.getText();
            LoggerHelper.info("Total gross amount: " + amount);
            return amount;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get total gross amount", e);
            return null;
        }
    }

    public void clickExportBtn() {
        try {
            clickButton(exportBtn);
            LoggerHelper.info("Export button clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click export button", e);
        }
    }

    public boolean isExportBtnDisplayed() {
        try {
            boolean isDisplayed = exportBtn.isDisplayed();
            LoggerHelper.info("Export button displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify export button", e);
            return false;
        }
    }

    // ==================== Table Methods ====================
    public void clickSelectAllCheckbox() {
        try {
            clickButton(selectAllCheckbox);
            LoggerHelper.info("Select all checkbox clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click select all checkbox", e);
        }
    }

    public boolean isSelectAllCheckboxDisplayed() {
        try {
            boolean isDisplayed = selectAllCheckbox.isDisplayed();
            LoggerHelper.info("Select all checkbox displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify select all checkbox", e);
            return false;
        }
    }

    public int getTableRowCount() {
        try {
            int count = tableRows.size();
            LoggerHelper.info("Table row count: " + count);
            return count;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get table row count", e);
            return 0;
        }
    }

    public void clickRowCheckbox(int rowIndex) {
        try {
            if (rowIndex < rowCheckboxes.size()) {
                clickButton(rowCheckboxes.get(rowIndex));
                LoggerHelper.info("Row checkbox clicked at index: " + rowIndex);
            }
        } catch (Exception e) {
            LoggerHelper.error("Failed to click row checkbox at index: " + rowIndex, e);
        }
    }

    public String getMerchantNameAtRow(int rowIndex) {
        try {
            if (rowIndex < merchantNames.size()) {
                String name = merchantNames.get(rowIndex).getText();
                LoggerHelper.info("Merchant name at row " + rowIndex + ": " + name);
                return name;
            }
            return null;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get merchant name at row: " + rowIndex, e);
            return null;
        }
    }

    public void clickRowActionButton(int rowIndex) {
        try {
            if (rowIndex < rowActionButtons.size()) {
                clickButton(rowActionButtons.get(rowIndex));
                LoggerHelper.info("Row action button clicked at index: " + rowIndex);
            }
        } catch (Exception e) {
            LoggerHelper.error("Failed to click row action button at index: " + rowIndex, e);
        }
    }

    public boolean areAllTableHeadersDisplayed() {
        try {
            boolean allDisplayed = merchantNameHeader.isDisplayed() &&
                    midHeader.isDisplayed() &&
                    tidHeader.isDisplayed() &&
                    maskPanHeader.isDisplayed() &&
                    serviceHeader.isDisplayed() &&
                    grossAmountHeader.isDisplayed() &&
                    mdrHeader.isDisplayed() &&
                    netAmountHeader.isDisplayed() &&
                    transactionTypeHeader.isDisplayed() &&
                    transactionSchemeHeader.isDisplayed() &&
                    transactionStatusHeader.isDisplayed();
            LoggerHelper.info("All table headers displayed: " + allDisplayed);
            return allDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify table headers", e);
            return false;
        }
    }

    // ==================== Pagination Methods ====================
    public void clickNextPage() {
        try {
            clickButton(nextPageBtn);
            LoggerHelper.info("Next page button clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click next page button", e);
        }
    }

    public void clickPreviousPage() {
        try {
            clickButton(previousPageBtn);
            LoggerHelper.info("Previous page button clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click previous page button", e);
        }
    }

    public String getCurrentPageNumber() {
        try {
            String pageNum = currentPageNumber.getText();
            LoggerHelper.info("Current page number: " + pageNum);
            return pageNum;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get current page number", e);
            return null;
        }
    }

    public boolean isPaginationDisplayed() {
        try {
            boolean isDisplayed = paginationNav.isDisplayed();
            LoggerHelper.info("Pagination displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify pagination", e);
            return false;
        }
    }

    public void clickPageNumber(int pageNumber) {
        try {
            for (WebElement page : paginationNumbers) {
                if (page.getText().equals(String.valueOf(pageNumber))) {
                    clickButton(page);
                    LoggerHelper.info("Clicked page number: " + pageNumber);
                    break;
                }
            }
        } catch (Exception e) {
            LoggerHelper.error("Failed to click page number: " + pageNumber, e);
        }
    }

    // ==================== Navigation Methods ====================
    public void clickDashboardNav() {
        try {
            clickButton(dashboardNav);
            LoggerHelper.info("Navigated to Dashboard");
        } catch (Exception e) {
            LoggerHelper.error("Failed to navigate to Dashboard", e);
        }
    }

    public void clickPaymentNav() {
        try {
            clickButton(paymentNav);
            LoggerHelper.info("Navigated to Payment");
        } catch (Exception e) {
            LoggerHelper.error("Failed to navigate to Payment", e);
        }
    }

    // ==================== Verification Methods ====================
    public boolean isTotalGrossAmountDisplayed() {
        try {
            boolean isDisplayed = totalGrossAmount.isDisplayed();
            LoggerHelper.info("Total gross amount displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify total gross amount", e);
            return false;
        }
    }

    public boolean areAllFiltersDisplayed() {
        try {
            boolean allDisplayed = dateRangePicker.isDisplayed() &&
                    transactionTypeDropdown.isDisplayed() &&
                    channelTypeDropdown.isDisplayed() &&
                    transactionSchemeDropdown.isDisplayed() &&
                    tidInput.isDisplayed() &&
                    batchIdInput.isDisplayed() &&
                    authCodeInput.isDisplayed() &&
                    transactionStatusDropdown.isDisplayed() &&
                    branchDropdown.isDisplayed();
            LoggerHelper.info("All filters displayed: " + allDisplayed);
            return allDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify all filters", e);
            return false;
        }
    }
}