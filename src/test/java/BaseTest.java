import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static ChromeOptions optionC;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Test
    @Parameters({"baseURL"})
    static void setupBrowser("baseURL"){
        optionC = new ChromeOptions();
        optionC.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        driver = new ChromeDriver(optionC);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
