import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseT {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = "";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
/*
    @DataProvider(name="IncorrectLoginData")
    public static Object[][] getDataFromDataProviders() {

        return new Object[][] {
                {"invalid@mail.com", "invalidPass"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }
  */
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        url = BaseURL;
        navigateToPage();
    }

    @AfterMethod//(enabled = false)
    public void closeBrowser() {
        driver.quit();
    }

    public static void navigateToPage() {
        driver.get(url);
    }

public static void provideEmail(String email) {
    WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
    emailField.click(); //not needed
    emailField.clear();
    emailField.sendKeys(email);
}
public void providePassword(String password){
    WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
    passwordField.click(); //not needed
    passwordField.clear();
    passwordField.sendKeys(password);
}

public void clickSubmit() {
    WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
    submit.click();
}
public void clickPlay(){
    WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
    WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

    playNextButton.click();
    playButton.click();
}
public boolean isSongPlaying(){
    WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
    return soundBar.isDisplayed();
}
}