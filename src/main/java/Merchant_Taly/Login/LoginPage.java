package Merchant_Taly.Login;

import Merchant_Taly.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DatabaseHelper;

public class LoginPage extends PageBase {

    private DatabaseHelper dbHelper;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        dbHelper = new DatabaseHelper(); // init helper
    }

    @FindBy(xpath = "//input[@id='Email']")
    WebElement UserName;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@id='Code']")
    WebElement otp_field;

    @FindBy(xpath = "//button[normalize-space()='Verify']")
    WebElement verifyBtn;

    public void login_cycle(String user, String pass) throws InterruptedException {
        send_Text(UserName, user);
        send_Text(password, pass);
        clickButton(loginBtn);

        System.out.println("⏳ Waiting for OTP to be generated...");
        Thread.sleep(15000); // Initial wait

        // Fetch OTP with retry logic (try 6 times, wait 3 seconds between attempts)
//        String otp = dbHelper.getLatestOTPWithRetry(user, 6, 3);

//        System.out.println("✅ OTP received: " + otp);
//        send_Text(otp_field, otp);
        clickButton(verifyBtn);
    }
}
