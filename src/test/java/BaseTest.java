import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import java.time.Duration;

public class BaseTest {
   public static WebDriver driver;
   public  static String url;
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
    }
    @AfterTest
    public static void closeWeb(){
        driver.quit();
    }
    public static void openLogInPage() {
        url = "https://bbb.testpro.io";
        driver.get(url);
    }
    public static void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        //emailField.click(); // no need
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void submitLogIn() throws InterruptedException {
        WebElement buttonLogInSubmit = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonLogInSubmit.click();
        Thread.sleep(2000);
    }
}
