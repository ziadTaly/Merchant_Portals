package Merchant_Taly;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageBase {
    protected  WebDriver driver;
    public  JavascriptExecutor jsa;
    public  Select select;
    public  Actions action;
    public  WebDriverWait wait;

    //Create constructor
    public PageBase (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        jsa = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }
    protected  void clickButton(WebElement button)
    {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
    protected  void clickButtondynamics(WebElement buttonDyn)
    {
        wait.until(ExpectedConditions.visibilityOf(buttonDyn)).click();
    }

    protected  void send_Text(WebElement textElement,String value)
    {
        wait.until(ExpectedConditions.visibilityOf(textElement));
        textElement.clear();
        textElement.sendKeys(value);
    }
    public void ScrollDown2500Pixel(){
        jsa.executeScript("scrollBy(0,4000)"); // دا كود بينزلني لاخر البيدج
    }
    public void ScrollToElement(WebElement element){
        jsa.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void selectFromDropdownByVisibleText(WebElement dropdown, String text) {
        select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
    public void Tab_to_Next_Failed(WebElement point_To_Tab){
        action.click(point_To_Tab).sendKeys(Keys.TAB).perform();
    }

}
