import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
   public static WebDriver driver;
   public  static String url;
   public static WebDriverWait wait;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeTest
    public static void setUpBrowser() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // How should look code in BeforeTest and BeforeMethod?
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
      /*  ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/

        url = BaseURL;
        driver.get(BaseURL);
        wait = new WebDriverWait(driver,Duration.ofSeconds(4));
    }

    @AfterTest
    public static void closeWeb(){
        driver.quit();
    }
   // public static void openLogInPage() {
        //url = "https://bbb.testpro.io";
       // driver.get(url);
   // }
    public static void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        //emailField.click(); // no need
        // emailField.clear(); Why we don't need to clean field here?
        emailField.sendKeys(email);
    }

    public static void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
       // passwordField.clear(); Why we don't need to clean field here?
        passwordField.sendKeys(password);
    }
    public static void submitLogIn() {
        WebElement buttonLogInSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        buttonLogInSubmit.click();
    }


}
