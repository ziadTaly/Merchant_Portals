package Merchant_Taly_Test.Login_TC;

import Data.JsonDataReader;
import Merchant_Taly.Login.LoginPage;
import Merchant_Taly_Test.TestBase;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginPageTest_TC0 extends TestBase {
    LoginPage loginObject;


    @Test
        public void CanLoginSuccessfully() throws IOException, ParseException, InterruptedException {
            loginObject = new LoginPage(driver);
            String email = JsonDataReader.jsonData("login_Merchant_Portal","userName");
            String password = JsonDataReader.jsonData("login_Merchant_Portal","password");
            loginObject.login_cycle(email, password);
        }
}