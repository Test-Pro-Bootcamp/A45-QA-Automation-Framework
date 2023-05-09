import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static ChromeOptions optionC;
    static WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    static void setupBrowser(String baseURL) {
        optionC = new ChromeOptions();
        optionC.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        driver = new ChromeDriver(optionC);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().minimize();
        driver.get(baseURL);
    }

    @AfterMethod
    public static void tearDownBrowser() {
        driver.quit();
    }

    public static void logIn(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }
    //when
    public static void searchSong(String songTitle){
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='search']")));
    searchBar.sendKeys(songTitle);
    }

    public static void clickViewAll(){
        WebElement searchResults = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#searchExcerptsWrapper > div > div > section.songs > h1 > button")));
        searchResults.click();
    }

    public static void selectSong(){
        WebElement chooseSong = driver.findElement(By.cssSelector("section#songResultsWrapper div.item-container tr.song-item td.title"));
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper div.item-container tr.song-item td.title")));
       chooseSong.click();
    }

    public static void clickAddTo(){
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to")));
       addToBtn.click();
    }

    public static void choosePlaylist(){
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]")));
        playlist.click();
    }

    public static void choosePlaylistToDelete() {
        WebElement playlistToDelete = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3)"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3)")));
        playlistToDelete.click();
    }

    public static void deleteButton() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist")));
        deletePlaylist.click();
    }
    public void clickOK() {
        WebElement okButton = driver.findElement(By.cssSelector("body > div.alertify > div > div > nav > button.ok"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.alertify > div > div > nav > button.ok")));
       okButton.click();
   }
    public String confirmDelete() {
        WebElement deleteConfirmation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
       return deleteConfirmation.getText();
    }
}

