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

public class BaseTest {
    public static WebDriver driver = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setupBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    public static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    public static void enterCredentials() {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();//not needed
        emailField.clear();
        emailField.sendKeys("burkovads@mail.ru");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();//not needed
        passwordField.clear();
        passwordField.sendKeys("Julka@0721");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
    public static void searchSong (String songTtile) {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys(songTtile);
    }
    public static void clickViewAllButton() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);
    }

    public static void clickFirstSong() throws InterruptedException {
        WebElement firstTitle = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstTitle.click();
        Thread.sleep(2000);
    }
    public static void addToPlaylist() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButton.click();
        WebElement playlistNewName = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section[@class='existing-playlists']/ul/li[5]"));
        playlistNewName.click();
        Thread.sleep(2000);
    }
    public String getNotificationMessage() {
        WebElement notificationMessage = driver.findElement(By.cssSelector(".success"));
        return(notificationMessage.getText());
    }
}