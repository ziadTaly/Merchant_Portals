package Merchant_Taly.services;

import Merchant_Taly.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.LoggerHelper;

import java.util.List;

public class PaymentPage extends PageBase {

    public PaymentPage(WebDriver driver) {
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

    @FindBy(xpath = "//a[@href='/dashboard/transactions']")
    WebElement transactionsNav;

    @FindBy(xpath = "//a[@href='/dashboard/payment' and @aria-current='page']")
    WebElement paymentNavActive;

    // ==================== Payment Type Tabs ====================
    @FindBy(xpath = "//button[normalize-space()='Single Payment']")
    WebElement singlePaymentTab;

    @FindBy(xpath = "//button[normalize-space()='Bulk Payment']")
    WebElement bulkPaymentTab;

    // ==================== Payment Form Elements ====================
    @FindBy(xpath = "//h3[normalize-space()='Enter Payment Information']")
    WebElement formTitle;

    // Mobile Number Field
    @FindBy(xpath = "//input[@name='mobileNumber']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//label[contains(text(),'Mobile Number')]")
    WebElement mobileNumberLabel;

    // Amount Field
    @FindBy(xpath = "//input[@name='amount']")
    WebElement amountInput;

    @FindBy(xpath = "//label[contains(text(),'Amount')]")
    WebElement amountLabel;

    // Fee Field
    @FindBy(xpath = "//input[@name='fee']")
    WebElement feeInput;

    @FindBy(xpath = "//label[contains(text(),'Fee (%)')]")
    WebElement feeLabel;

    // Discount Field
    @FindBy(xpath = "//input[@name='discount']")
    WebElement discountInput;

    @FindBy(xpath = "//label[contains(text(),'Discount (%)')]")
    WebElement discountLabel;

    // Order Number Field
    @FindBy(xpath = "//input[@name='orderNumber']")
    WebElement orderNumberInput;

    @FindBy(xpath = "//label[contains(text(),'Order Number')]")
    WebElement orderNumberLabel;

    // Description Field
    @FindBy(xpath = "//input[@name='description']")
    WebElement descriptionInput;

    @FindBy(xpath = "//label[contains(text(),'Description')]")
    WebElement descriptionLabel;

    // Customer Name Field
    @FindBy(xpath = "//input[@name='customerName']")
    WebElement customerNameInput;

    @FindBy(xpath = "//label[contains(text(),'Customer Name')]")
    WebElement customerNameLabel;

    // Item Name Field
    @FindBy(xpath = "//input[@name='itemName']")
    WebElement itemNameInput;

    @FindBy(xpath = "//label[contains(text(),'Item name')]")
    WebElement itemNameLabel;

    // Session Timeout Field
    @FindBy(xpath = "//input[@name='sessionTimeout']")
    WebElement sessionTimeoutInput;

    @FindBy(xpath = "//label[contains(text(),'Session Timeout (in hours)')]")
    WebElement sessionTimeoutLabel;

    // Merchant Website Field
    @FindBy(xpath = "//input[@name='merchantUrl']")
    WebElement merchantUrlInput;

    @FindBy(xpath = "//label[contains(text(),'Merchant Website')]")
    WebElement merchantUrlLabel;

    // Submit Button
    @FindBy(xpath = "//button[@type='submit']//span[normalize-space()='Submit']")
    WebElement submitBtn;

    // ==================== Payment History Section ====================
    @FindBy(xpath = "//h3[normalize-space()='Single Payment History']")
    WebElement paymentHistoryTitle;

    // Table Header Checkbox
    @FindBy(xpath = "//thead//button[@role='checkbox' and @aria-label='Select all']")
    WebElement selectAllCheckbox;

    // Table Headers
    @FindBy(xpath = "//th[normalize-space()='MSISDN']")
    WebElement msisdnHeader;

    @FindBy(xpath = "//th[normalize-space()='Amount']")
    WebElement amountHeader;

    @FindBy(xpath = "//th[normalize-space()='Status']")
    WebElement statusHeader;

    @FindBy(xpath = "//th[normalize-space()='Customer Name']")
    WebElement customerNameHeader;

    @FindBy(xpath = "//th[normalize-space()='Description']")
    WebElement descriptionHeader;

    @FindBy(xpath = "//th[normalize-space()='Order Number']")
    WebElement orderNumberHeader;

    @FindBy(xpath = "//th[normalize-space()='Process At']")
    WebElement processAtHeader;

    // Table Rows
    @FindBy(xpath = "//tbody/tr")
    List<WebElement> tableRows;

    // Row Checkboxes
    @FindBy(xpath = "//tbody//button[@role='checkbox']")
    List<WebElement> rowCheckboxes;

    // MSISDN in Table
    @FindBy(xpath = "//tbody//tr/td[2]")
    List<WebElement> msisdnValues;

    // Amount in Table
    @FindBy(xpath = "//tbody//tr/td[3]")
    List<WebElement> amountValues;

    // Status in Table
    @FindBy(xpath = "//tbody//tr/td[4]")
    List<WebElement> statusValues;

    // Customer Names in Table
    @FindBy(xpath = "//tbody//tr/td[5]")
    List<WebElement> customerNameValues;

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

    // Verify Payment Page Loaded
    public boolean isPaymentPageLoaded() {
        try {
            wait.until(driver -> formTitle.isDisplayed());
            LoggerHelper.info("Payment page loaded successfully");
            return true;
        } catch (Exception e) {
            LoggerHelper.error("Payment page failed to load", e);
            return false;
        }
    }

    // Verify Payment Navigation is Active
    public boolean isPaymentNavActive() {
        try {
            boolean isActive = paymentNavActive.getAttribute("aria-current").equals("page");
            LoggerHelper.info("Payment navigation active status: " + isActive);
            return isActive;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify payment nav active status", e);
            return false;
        }
    }

    // ==================== Tab Methods ====================
    public void clickSinglePaymentTab() {
        try {
            clickButton(singlePaymentTab);
            LoggerHelper.info("Single Payment tab clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click Single Payment tab", e);
        }
    }

    public void clickBulkPaymentTab() {
        try {
            clickButton(bulkPaymentTab);
            LoggerHelper.info("Bulk Payment tab clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click Bulk Payment tab", e);
        }
    }

    public boolean isSinglePaymentTabActive() {
        try {
            String classes = singlePaymentTab.getAttribute("class");
            boolean isActive = classes.contains("bg-mainColor");
            LoggerHelper.info("Single Payment tab active: " + isActive);
            return isActive;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify Single Payment tab status", e);
            return false;
        }
    }

    // ==================== Form Methods ====================
    public String getFormTitle() {
        try {
            String title = formTitle.getText();
            LoggerHelper.info("Form title: " + title);
            return title;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get form title", e);
            return null;
        }
    }

    public void enterMobileNumber(String mobileNumber) {
        try {
            send_Text(mobileNumberInput, mobileNumber);
            LoggerHelper.info("Mobile number entered: " + mobileNumber);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter mobile number", e);
        }
    }

    public void enterAmount(String amount) {
        try {
            send_Text(amountInput, amount);
            LoggerHelper.info("Amount entered: " + amount);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter amount", e);
        }
    }

    public void enterFee(String fee) {
        try {
            send_Text(feeInput, fee);
            LoggerHelper.info("Fee entered: " + fee);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter fee", e);
        }
    }

    public void enterDiscount(String discount) {
        try {
            send_Text(discountInput, discount);
            LoggerHelper.info("Discount entered: " + discount);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter discount", e);
        }
    }

    public void enterOrderNumber(String orderNumber) {
        try {
            send_Text(orderNumberInput, orderNumber);
            LoggerHelper.info("Order number entered: " + orderNumber);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter order number", e);
        }
    }

    public void enterDescription(String description) {
        try {
            send_Text(descriptionInput, description);
            LoggerHelper.info("Description entered: " + description);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter description", e);
        }
    }

    public void enterCustomerName(String customerName) {
        try {
            send_Text(customerNameInput, customerName);
            LoggerHelper.info("Customer name entered: " + customerName);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter customer name", e);
        }
    }

    public void enterItemName(String itemName) {
        try {
            send_Text(itemNameInput, itemName);
            LoggerHelper.info("Item name entered: " + itemName);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter item name", e);
        }
    }

    public void enterSessionTimeout(String sessionTimeout) {
        try {
            send_Text(sessionTimeoutInput, sessionTimeout);
            LoggerHelper.info("Session timeout entered: " + sessionTimeout);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter session timeout", e);
        }
    }

    public void enterMerchantUrl(String merchantUrl) {
        try {
            send_Text(merchantUrlInput, merchantUrl);
            LoggerHelper.info("Merchant URL entered: " + merchantUrl);
        } catch (Exception e) {
            LoggerHelper.error("Failed to enter merchant URL", e);
        }
    }

    public void clickSubmitBtn() {
        try {
            clickButton(submitBtn);
            LoggerHelper.info("Submit button clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click submit button", e);
        }
    }

    // Fill Complete Payment Form
    public void fillPaymentForm(String mobileNumber, String amount, String fee, String discount,
                                String orderNumber, String description, String customerName,
                                String itemName, String sessionTimeout, String merchantUrl) {
        try {
            enterMobileNumber(mobileNumber);
            enterAmount(amount);
            enterFee(fee);
            enterDiscount(discount);
            enterOrderNumber(orderNumber);
            enterDescription(description);
            enterCustomerName(customerName);
            enterItemName(itemName);
            enterSessionTimeout(sessionTimeout);
            enterMerchantUrl(merchantUrl);
            LoggerHelper.info("Payment form filled successfully");
        } catch (Exception e) {
            LoggerHelper.error("Failed to fill payment form", e);
        }
    }

    // ==================== Validation Methods ====================
    public boolean areAllFormFieldsDisplayed() {
        try {
            boolean allDisplayed = mobileNumberInput.isDisplayed() &&
                    amountInput.isDisplayed() &&
                    feeInput.isDisplayed() &&
                    discountInput.isDisplayed() &&
                    orderNumberInput.isDisplayed() &&
                    descriptionInput.isDisplayed() &&
                    customerNameInput.isDisplayed() &&
                    itemNameInput.isDisplayed() &&
                    sessionTimeoutInput.isDisplayed() &&
                    merchantUrlInput.isDisplayed();
            LoggerHelper.info("All form fields displayed: " + allDisplayed);
            return allDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify form fields", e);
            return false;
        }
    }

    public boolean isSubmitBtnDisplayed() {
        try {
            boolean isDisplayed = submitBtn.isDisplayed();
            LoggerHelper.info("Submit button displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify submit button", e);
            return false;
        }
    }

    // ==================== Payment History Methods ====================
    public String getPaymentHistoryTitle() {
        try {
            String title = paymentHistoryTitle.getText();
            LoggerHelper.info("Payment history title: " + title);
            return title;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get payment history title", e);
            return null;
        }
    }

    public boolean areAllTableHeadersDisplayed() {
        try {
            boolean allDisplayed = msisdnHeader.isDisplayed() &&
                    amountHeader.isDisplayed() &&
                    statusHeader.isDisplayed() &&
                    customerNameHeader.isDisplayed() &&
                    descriptionHeader.isDisplayed() &&
                    orderNumberHeader.isDisplayed() &&
                    processAtHeader.isDisplayed();
            LoggerHelper.info("All table headers displayed: " + allDisplayed);
            return allDisplayed;
        } catch (Exception e) {
            LoggerHelper.error("Failed to verify table headers", e);
            return false;
        }
    }

    public void clickSelectAllCheckbox() {
        try {
            clickButton(selectAllCheckbox);
            LoggerHelper.info("Select all checkbox clicked");
        } catch (Exception e) {
            LoggerHelper.error("Failed to click select all checkbox", e);
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

    public String getMSISDNAtRow(int rowIndex) {
        try {
            if (rowIndex < msisdnValues.size()) {
                String msisdn = msisdnValues.get(rowIndex).getText();
                LoggerHelper.info("MSISDN at row " + rowIndex + ": " + msisdn);
                return msisdn;
            }
            return null;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get MSISDN at row: " + rowIndex, e);
            return null;
        }
    }

    public String getAmountAtRow(int rowIndex) {
        try {
            if (rowIndex < amountValues.size()) {
                String amount = amountValues.get(rowIndex).getText();
                LoggerHelper.info("Amount at row " + rowIndex + ": " + amount);
                return amount;
            }
            return null;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get amount at row: " + rowIndex, e);
            return null;
        }
    }

    public String getStatusAtRow(int rowIndex) {
        try {
            if (rowIndex < statusValues.size()) {
                String status = statusValues.get(rowIndex).getText();
                LoggerHelper.info("Status at row " + rowIndex + ": " + status);
                return status;
            }
            return null;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get status at row: " + rowIndex, e);
            return null;
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

    public void clickTransactionsNav() {
        try {
            clickButton(transactionsNav);
            LoggerHelper.info("Navigated to Transactions");
        } catch (Exception e) {
            LoggerHelper.error("Failed to navigate to Transactions", e);
        }
    }

    // ==================== Field Attribute Methods ====================
    public String getMobileNumberPlaceholder() {
        try {
            String placeholder = mobileNumberInput.getAttribute("placeholder");
            LoggerHelper.info("Mobile number placeholder: " + placeholder);
            return placeholder;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get mobile number placeholder", e);
            return null;
        }
    }

    public String getMaxLengthMobileNumber() {
        try {
            String maxLength = mobileNumberInput.getAttribute("maxlength");
            LoggerHelper.info("Mobile number max length: " + maxLength);
            return maxLength;
        } catch (Exception e) {
            LoggerHelper.error("Failed to get mobile number max length", e);
            return null;
        }
    }
}