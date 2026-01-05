package Merchant_Taly_Test;

import Data.JsonDataReader;
import Merchant_Taly.Login.LoginPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void StartDriver( @Optional("Edge") String browserName) throws IOException, ParseException, InterruptedException// اوبشن دي عشان فايل اكس م ال ياخد من اكس ام فايل
    {
        if (driver == null) {  // ✅ يفتح مرة واحدة بس طول الـ suite
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
            } else if (browserName.equalsIgnoreCase(("InternetExplorer"))) {
                driver = new InternetExplorerDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.navigate().to("write here the URL");   // Use if working Dev
            driver.navigate().to("https://10.20.73.2:8090/auth/login");//use if working SandBox Environment

            Login_merchant_portal();
        }
        }

    public void Login_merchant_portal() throws IOException, ParseException, InterruptedException {
        LoginPage loginObject = new LoginPage(driver);
        String email = JsonDataReader.jsonData("login_Merchant_Portal","userName");
        String password = JsonDataReader.jsonData("login_Merchant_Portal","password");
        loginObject.login_cycle(email,password);
    }

    //TODO: Take ScreenShot If Failed Test
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        if (result.getStatus() == ITestResult.FAILURE) {
            Helper.takeScreenshot(driver, result.getName()); // Capture screenshot on failure
            Thread.sleep(2000);
            driver.quit();
        }

    }
    @AfterSuite
    public void BrowserDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}


//TODO: Quit Browser
//    @AfterSuite
//    public void StopDriver(){
//        driver.quit();
//    }