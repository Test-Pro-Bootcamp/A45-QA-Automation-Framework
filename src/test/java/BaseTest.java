import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "";
    public static WebDriverWait wait = null;
    public static Actions actions = null;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']"))).click();
     //emailField.click();
     emailField.clear();
     emailField.sendKeys(email);
    }
    public static void providePassword (String password) {

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']"))).click();
        //passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit (){
        WebElement clickSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

        //clickSubmit.click();
    }

}


