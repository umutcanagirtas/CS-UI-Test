package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import static base.Constants.BASE_URL;


public class BaseClass {
    public static WebDriver driver;
    //define driver and base url
    protected final String baseUrl = "https://www.mizu.com/";

    @Parameters({"browser"})
    public void beforeMethod(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
        driver.navigate().to(BASE_URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public void afterMethod() {
        driver.quit();
    }
}