import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {
    static WebDriverWait wait;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }
    
    public void inputEmail(){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']"))).click();
        emailField.clear();
        emailField.sendKeys("demo@class.com");
    }
    public void inputPassword(){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']"))).click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
    }
    public void clickLogin() throws InterruptedException{
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']"))).click();
        //loginButton.click();

    }
    public void searchSong() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='search']"))).click();
        //searchField.click();
        searchField.sendKeys("Samurai");

    }
    public void clickViewAllButton() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']"))).click();
        //viewAllButton.click();
    }
    public void selectFirstSongInSearch() throws InterruptedException {
        WebElement firstSongInSearch = driver.findElement(By.cssSelector
                ("#songResultsWrapper > div > div > div.item-container > table > tr"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "#songResultsWrapper > div > div > div.item-container > table > tr"))).click();
        //firstSongInSearch.click();
    }
    public void addToInSearch() throws InterruptedException {
        WebElement addToInSearch = driver.findElement(By.xpath(
                "//*[@id='songResultsWrapper']/header/div[3]/span/button[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[@id='songResultsWrapper']/header/div[3]/span/button[2]"))).click();
        //addToInSearch.click();
    }
    public void chooseTestProPlaylistInSearch() {
        WebElement testProPlaylistInSearch = driver.findElement(By.xpath(
                "//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[59]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[59]"))).click();
        //testProPlaylistInSearch.click();
    }
    public String getNotificationInSearch(){
        WebElement notificationInSearch = driver.findElement(By.cssSelector("div.success.show"));
        return notificationInSearch.getText();
    }
    public void clickAllSongs() throws InterruptedException {
        WebElement allSongsOption = driver.findElement(By.cssSelector("a[class='songs']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='songs']"))).click();
        //allSongsOption.click();
    }
    public void selectFirstSong() throws InterruptedException {
        WebElement firstSongInList = driver.findElement(By.xpath(
                "//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]"))).click();
        //firstSongInList.click();
    }
    public void addToPlaylist() throws InterruptedException {
        WebElement addToPlaylistButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn-add-to']"))).click();
        //addToPlaylistButton.click();
    }
    public void chooseTestProPlaylistName() throws InterruptedException {
        WebElement playlistName = driver.findElement(By.xpath(
                "//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[55]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[55]"))).click();
        //playlistName.click(};
    }
    public void findTestProPlaylistHome() throws InterruptedException {
        WebElement testProPlaylistHome = driver.findElement(By.cssSelector("a[href='#!/playlist/54169']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/playlist/54169']"))).click();
        //testProPlaylistHome.click();
    }
    public void goToTestProPlaylistElement(){
        WebElement testProPlaylistElement = driver.findElement(By.cssSelector("section[id='playlistWrapper']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section[id='playlistWrapper']"))).click();

    }
    public void clickFirstSongInTestProPlaylist() throws InterruptedException {
        WebElement firstSongInTestProPlaylist = driver.findElement(By.xpath(
                "//*[@id='playlistWrapper']/div/div/div[1]/table/tr[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[@id='playlistWrapper']/div/div/div[1]/table/tr[1]"))).click();
        //firstSongInTestProPlaylist.click();
    }
    public void clickPlayButton() throws InterruptedException{
        WebElement playButton = driver.findElement(By.cssSelector("span[class='play']>i[class='fa fa-play']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "span[class='play']>i[class='fa fa-play']"))).click();
        //playButton.click();
    }
    public void clickNextSong() throws InterruptedException {
        WebElement nextSong = driver.findElement(By.cssSelector("i[class='next fa fa-step-forward control']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "i[class='next fa fa-step-forward control']"))).click();
        //nextSong.click();
    }
    public void validateTheSoundBar() throws InterruptedException {
        WebElement theSoundBar = driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='sound-bar-play']")));
        Thread.sleep(3000);
    }
    public String getNotificationText(){
        WebElement notificationElement = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));
        //"div.success.show"
        return notificationElement.getText();
    }
    public void clickPlaylistSvyeta() throws InterruptedException {
        WebElement playlistSvyeta = driver.findElement(By.cssSelector("a[href='#!/playlist/54983']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/playlist/54983']"))).click();
        //playlistSvyeta.click();
        //Thread.sleep(2000);
    }
    public void clickRedBtnDeletePlaylist() throws InterruptedException {
        WebElement redBtnDeletePlaylist = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='del btn-delete-playlist']"))).click();
        //Thread.sleep(2000);
    }
}