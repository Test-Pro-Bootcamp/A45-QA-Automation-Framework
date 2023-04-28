import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;

    public static String url = "";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        openLoginUrl();
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }
    public static void openLoginUrl() {driver.get(url);}

    public void inputEmail(){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@class.com");
    }
    public void inputPassword(){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
    }
    public void clickLogin() throws InterruptedException{
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
    }
    public void searchSong() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.sendKeys("Samurai");
        Thread.sleep(2000);
    }
    public void clickViewAllButton() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongInSearch() throws InterruptedException {
        WebElement firstSongInSearch = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr"));
        firstSongInSearch.click();
        Thread.sleep(2000);
    }
    public void addToInSearch() throws InterruptedException {
        WebElement addToInSearch = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]"));
        addToInSearch.click();
        Thread.sleep(2000);
    }
    public void chooseTestProPlaylistInSearch() {
        WebElement testProPlaylistInSearch = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[59]"));
        testProPlaylistInSearch.click();
       // Thread.sleep(2000);
    }
    public String getNotificationInSearch(){
        WebElement notificationInSearch = driver.findElement(By.cssSelector("div.success.show"));
        return notificationInSearch.getText();
    }
    public void clickAllSongs() throws InterruptedException {
        WebElement allSongsOption = driver.findElement(By.cssSelector("a[class='songs']"));
        allSongsOption.click();
        Thread.sleep(2000);
    }
    public void selectFirstSong() throws InterruptedException {
        WebElement firstSongInList = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
        firstSongInList.click();
        Thread.sleep(2000);
    }
    public void addToPlaylist() throws InterruptedException {
        WebElement addToPlaylistButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToPlaylistButton.click();
        Thread.sleep(3000);
    }
    public void chooseTestProPlaylistName() throws InterruptedException {
        WebElement playlistName = driver.findElement(By.xpath("//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[55]"));
        playlistName.click();
        Thread.sleep(3000);
    }
    public void findTestProPlaylistHome() throws InterruptedException {
        WebElement testProPlaylistHome = driver.findElement(By.cssSelector("a[href='#!/playlist/54169']"));
        testProPlaylistHome.click();
        Thread.sleep(2000);
    }
    public void goToTestProPlaylistElement(){
        WebElement testProPlaylistElement = driver.findElement(By.cssSelector("section[id='playlistWrapper']"));
    }
    public void clickFirstSongInTestProPlaylist() throws InterruptedException {
        WebElement firstSongInTestProPlaylist = driver.findElement(By.xpath("//*[@id='playlistWrapper']/div/div/div[1]/table/tr[1]"));
        firstSongInTestProPlaylist.click();
        Thread.sleep(2000);
    }
    public void clickPlayButton() throws InterruptedException{
        WebElement playButton = driver.findElement(By.cssSelector("span[class='play']>i[class='fa fa-play']"));
        playButton.click();
        Thread.sleep(2000);
    }
    public void clickNextSong() throws InterruptedException {
        WebElement nextSong = driver.findElement(By.cssSelector("i[class='next fa fa-step-forward control']"));
        nextSong.click();
        Thread.sleep(2000);
    }
    public void validateTheSoundBar() throws InterruptedException {
        WebElement theSoundBar = driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        Thread.sleep(3000);
    }
    public String getNotificationText(){
        WebElement notificationElement = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));  //"div.success.show"
        return notificationElement.getText();
    }
    public void deletePlaylistSvyeta() throws InterruptedException {
        WebElement playlistSvyeta = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(32) > a"));
        playlistSvyeta.click();
        Thread.sleep(2000);
    }
    public void redButtonDeletePlaylist() throws InterruptedException {
        WebElement redButtonDeletePlaylist = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        redButtonDeletePlaylist.click();
        Thread.sleep(3000);
    }
}
