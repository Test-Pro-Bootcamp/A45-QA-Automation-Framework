import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.InterruptedException;
import java.time.Duration;

public class BaseTest {
  WebDriver driver;
    @BeforeSuite
     static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
     public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void quitBrowser(){

        driver.quit();
    }

    public void navigateToPage() {
        driver.get("https://bbb.testpro.io");
    }
    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void enterPassword(String password) {
        WebElement passwordField  = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() throws InterruptedException{
        WebElement loginButton  = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();
        Thread.sleep(2000);


    }






}

