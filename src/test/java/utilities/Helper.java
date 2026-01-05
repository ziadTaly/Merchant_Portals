package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    // Method to take a screenshot when a test case fails
    public static void takeScreenshot(WebDriver driver, String testCaseName) {
        // Generate timestamp for unique file names
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testCaseName + "_" + timestamp + ".png";

        // Define screenshots directory path
        String screenshotsDir = System.getProperty("user.dir") + "/screenshots";
        File directory = new File(screenshotsDir);

        // Check if directory exists, if not, create it
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Capture screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define full path for the screenshot
        String destPath = screenshotsDir + "/" + fileName;

        try {
            FileUtils.copyFile(srcFile, new File(destPath));
            System.out.println("✅ Screenshot saved at: " + destPath);
        } catch (IOException e) {
            System.out.println("❌ Failed to save screenshot: " + e.getMessage());
        }
    }
}
