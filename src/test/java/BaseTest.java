import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    static WebDriverWait wait;
    public static WebDriver driver = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public static String url = "";

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void launchBrowser(String BaseURL) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");

        driver = new ChromeDriver(options); // Assigning the driver instance to the static driver variable
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //explicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait
        url = BaseURL;
        driver.get(url);
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public static void navigateToPage() {
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']"))).click();
        //emailField.click(); // not needed, the last part of previous line works for it
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public void selectPlayList() {
        WebElement selectPlayList = driver.findElement(By.xpath("//li[@class = 'playlist playlist']"));
        selectPlayList.click();
    }

    public void deletePlaylistButton() {
        WebElement deletePlaylistButton = driver.findElement(By.xpath("//button[@class ='del btn-delete-playlist']"));
        deletePlaylistButton.click();
    }
}
