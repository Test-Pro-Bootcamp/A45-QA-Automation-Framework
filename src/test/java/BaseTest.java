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
import java.util.UUID;

public class BaseTest {

    public static WebDriver driver;

    public static String url = "";

    static WebDriverWait wait;

    static By emailField = By.cssSelector("input[type='email']");
    static By passwordField = By.cssSelector("input[type='password']");
    static By submitButton = By.cssSelector("button[type='submit']");



    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @DataProvider(name="IncorrectLoginData")
    public static Object[][] getDataFromDataProviders() {

        return new Object[][] {
                {"invalid@mail.com", "invalidPass"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);//navigateToPage();
       //provideEmail("andrei.bryliakov@testpro.io");
       //providePassword("te$t$tudent1");
       //clickSubmit();

    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public static void navigateToPage() {
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailElement.sendKeys("andrei.bryliakov@testpro.io");
        /*WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();//not needed
        emailField.clear();
        emailField.sendKeys(email);*/
    }

    public static void providePassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordElement.sendKeys("te$t$tudent1");
       /* WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();//not needed
        passwordField.clear();
        passwordField.sendKeys(password);*/
    }

    public static void clickSubmit() {
        WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
       // WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButtonElement.click();
    }
    static By saveButton = By.cssSelector("button.btn-submit");

    public static void clickSaveButton() {
        WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        //WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButtonElement.click();
    }
    static By profileName = By.cssSelector("[name='name']");

    public static void provideProfileName(String randomName) {
        WebElement profileNameElement = wait.until(ExpectedConditions.elementToBeClickable(profileName));
        //WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileNameElement.clear();
        profileNameElement.sendKeys(randomName);
    }
    static By currentPassword = By.cssSelector("[name='current_password']");

    public static void provideCurrentPassword(String password) {
        WebElement currentPasswordElement = wait.until(ExpectedConditions.elementToBeClickable(currentPassword));
        //WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPasswordElement.clear();
        currentPasswordElement.sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    static By avatarIcon = By.cssSelector("span.name");

    public static void clickAvatarIcon() {
        WebElement avatarIconElement = wait.until(ExpectedConditions.elementToBeClickable(avatarIcon));
        //WebElement avatarIcon = driver.findElement(By.cssSelector("span.name"));
        avatarIconElement.click();
    }
}