import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseHomeTest {

    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io";

    @BeforeSuite
    static void setUpClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins--");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
    }

    public void searchSongl(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div/searchform input[type='search']"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(2000);
    }

    public static void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div,results section.songs h1 button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);
    }

    public static void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector("sectionsongResultswrapper tr.song-item td.title"));
        firstSongResult.click();
        Thread.sleep(2000);
    }

    public void clickAddBtnl() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(2000);
        /*public void additionalPlayList()    {
                //we created a playlist named "test pro playlist";
                WebElement  playElement=driver.findElement(By.cssSelector("//section[id='songResultswrapper']//li[contains(text(),'Test pro playlist')]"));
                playElement.click();
                Thread.sleep(2000);
            }*/
        /*public  String getNotificationText() {
                WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
                return notificationElement.getText(),

            }*/


    }


}