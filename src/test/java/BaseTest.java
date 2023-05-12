import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "";

    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }

 @BeforeMethod
 @Parameters ({"BaseUrl"})
     public void launchBrowser(String BaseUrl) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseUrl;
        driver.get(url);
        navigateToPage();



 }
     public void navigateToPage(){
        driver.get(url);
    }
@AfterMethod
    public void closeBrowser() { driver.quit(); }


    public static void provideEmail (String email){

     WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
     emailField.click();
     emailField.clear();
     emailField.sendKeys(email);
    }
    public static void providePassword (String password) {

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit (){
        WebElement clickSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        clickSubmit.click();
    }

}


