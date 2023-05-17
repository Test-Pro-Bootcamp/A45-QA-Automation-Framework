import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public static String url = "";

    @DataProvider(name = "IncorrectLoginData")
    public static Object [][] getDataFromDataProviders() {

        return new Object[][] {
                {"invalid@mail.com", "invalidPass"},
                {"anton.prymak@testpro.io", ""},
                {"", ""}
        };
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        driver = new ChromeDriver(options); // Assigning the driver instance to the static driver variable
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
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
        emailField.click();
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

    protected String getNotificationText() {
        WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
        return notification.getText();
    }

    protected String removePlaylist(Integer ordNum) {

        WebElement certainPlaylist = driver.findElement(By.xpath(String.format("//li[@class='playlist playlist'][%d]/a",
                                                                                ordNum)));
        String plName = certainPlaylist.getText();
        certainPlaylist.getText();
        certainPlaylist.click();
        WebElement delButton = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        delButton.click();
        try {
            WebElement okBtn = driver.findElement(By.xpath( "//button[@class='ok']"));
            okBtn.click();
        }
        catch (NoSuchElementException e){
        }
        return plName;
    }

    protected void createPlaylist(String playlistName) throws InterruptedException {
        WebElement plusButton = driver.findElement(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']"));
        plusButton.click();

        WebElement newPlaylist = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        newPlaylist.click();

        WebElement toSave = driver.findElement(By.xpath("//input[@name='name']"));
        toSave.sendKeys(playlistName);
        toSave.submit();
    }
}
