import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
    static Actions action = null;
    String newPlaylistName = "Myesha";

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
        action = new Actions(driver);
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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
    }
    //when
//    public static void searchSong(String songTitle){
//        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='search']"))).sendKeys(songTitle);
//        //searchBar.sendKeys(songTitle);
//    }
//
//    public static void clickViewAll(){
//        WebElement searchResults = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='view-all-songs-btn']"))).click();
////    }
//
//    public static void selectSong(){
//        WebElement chooseSong = driver.findElement(By.cssSelector("section#songResultsWrapper div.item-container tr.song-item td.title"));
//       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper div.item-container tr.song-item td.title"))).click();
//    }
//
//    public static void clickAddTo(){
//        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
//       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to"))).click();
//    }

    public static void choosePlaylist(){
        WebElement playlist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3)"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3)"))).click();
    }

 //   public static void deleteButton() {
//        WebElement deletePlaylist = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist"))).click();
//        // deletePlaylist.click();
//    }
//    public static void choosePlaylistToDelete() {
//        WebElement playlistToDelete = driver.findElement(By.cssSelector("[href = '#!/playlist/54189']"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href = '#!/playlist/54189']"))).click();
//        //playlistToDelete.click();
//    }

    public static void editPlaylist() {
        WebElement chooseEdit = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3)"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3)")));
        action.doubleClick(chooseEdit).perform();
    }
    public void enterNewName() {
       WebElement playlistInput = driver.findElement(By.cssSelector("[name='name']"));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
       playlistInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
       playlistInput.sendKeys(newPlaylistName);
       playlistInput.sendKeys(Keys.ENTER);

    }



//    public String confirmDelete()
//        WebElement deleteConfirmation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
//        return deleteConfirmation.getText();
//    }
}
