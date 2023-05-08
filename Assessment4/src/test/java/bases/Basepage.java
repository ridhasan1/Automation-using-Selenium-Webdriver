package bases;

import Utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class Basepage {
    public WebDriver driver = new ChromeDriver();

    public static String loginurl = "https://www.saucedemo.com/";


    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        //homePage = new HomePage(driver);
    }

    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils utils = new Utils();
                utils.takeScreenshot(driver);
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }
    }


    @AfterTest
    public void quitBrowser() {
        driver.quit();
    }

}