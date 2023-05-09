import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    //String newPlaylistName = "kcroker new playlist";

    public String url = "https://bbb.testpro.io/";

    public WebDriver driver = null;
    public WebDriverWait wait = null;
    public Actions actions = null;

    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();

    }

    @Parameters({"BaseUrl"})
    @BeforeMethod
    public void launchBrowser(String BaseUrl) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(BaseUrl);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl);

    }

    /*public void login(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

    }

    public void doubleClickPlaylist() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(playlistElement).perform();

    }

    public void enterNewPlaylistName() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        WebElement playlistInputField = driver.findElement(By.cssSelector("[name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);

    }*/

    /*public boolean doesPlaylistExist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + playlistName + "']")));
        return playlistElement.isDisplayed();
    }*/

    @AfterMethod
    public void quitBrowser() {

        driver.quit();

    }

}