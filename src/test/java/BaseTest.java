import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    static WebDriver driver;

    static String url = "https://bbb.testpro.io";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    static void setUpBrowser(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications","--remote-allow-origins=*","--incognito","--start-maximized");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(url);

    WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();//not needed
        emailField.clear();
        emailField.sendKeys("andrei.bryliakov@testpro.io");

    WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();//not needed
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent1");

    WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
    @AfterMethod
    static void shutDown(){
    driver.quit();
    }
}