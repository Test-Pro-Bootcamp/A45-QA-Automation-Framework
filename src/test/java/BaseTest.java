import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    static WebDriverWait wait;
    public static WebDriver driver = null;
    public Actions actions = null;
    public static String url = "";
    public static ThreadLocal<WebDriver> threadDriver;
    @BeforeSuite
    static void setupClass() {

       // WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);

        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);

        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        getDriver().get(url);
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("113.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "svetakim0265");
        ltOptions.put("accessKey", "vTSKu7O842k6CgJnf3JbT2ITJrybcyWt3L0fog94HkcoTa8SzA");
        ltOptions.put("project", "Test Project");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
    @AfterMethod
    public void closeBrowser(){
        //RemoteWebDriver getDriver = null;
        getDriver().quit();
        threadDriver.remove();
    }
    public WebDriver getDriver() {
        return  threadDriver.get();
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.4:4444"; //we insert our grid url here
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary("C:/Users/kim_s/AppData/Local/Mozilla Firefox/firefox.exe");
                return driver = new FirefoxDriver(firefoxOptions);

            case "MicrosoftEdge": // gradle clean test -Dbrowser=MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);

            case "grid-MicrosoftEdge": // gradle clean test -Dbrowser=grid-MicrosoftEdge
                capabilities.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);

            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }

    public void validLoginCredentials(){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']"))).click();
        emailField.clear();
        emailField.sendKeys("svyeta@test.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']"))).click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
        //loginButton.click();
    }
    public void doubleClickSong(){
        WebElement toDoubleClickSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]")));
        actions.doubleClick(toDoubleClickSong).perform();
    }
    
    public void inputEmail(){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']"))).click();
        emailField.clear();
        emailField.sendKeys("svyeta@test.com");
    }
    public void inputPassword(){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']"))).click();
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
    }
    public void clickLogin() throws InterruptedException{
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "input[type='button[data-test='view-all-songs-btn']']"))).click();
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
        WebElement allSongsOption = driver.findElement(By.xpath("//*[@id='sidebar']/section[1]/ul/li[3]/a"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sidebar']/section[1]/ul/li[3]/a"))).click();
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
    }
    public void findTestProPlaylistHome() throws InterruptedException {
        WebElement testProPlaylistHome = driver.findElement(By.cssSelector("a[href='#!/playlist/54169']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/playlist/54169']"))).click();
    }
    public void clickFirstSongInTestProPlaylist() throws InterruptedException {
        WebElement firstSongInTestProPlaylist = driver.findElement(By.xpath(
                "//*[@id='playlistWrapper']/div/div/div[1]/table/tr[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[@id='playlistWrapper']/div/div/div[1]/table/tr[1]"))).click();
    }
    public void clickPlayButton() throws InterruptedException{
        WebElement playButton = driver.findElement(By.cssSelector("span[title='Play or resume']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "span[title='Play or resume']"))).click();
    }
    public void clickNextSong() throws InterruptedException {
        WebElement nextSong = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/i[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainFooter']/div[1]/i[2]"))).click();
    }
    public void validateTheSoundBar() throws InterruptedException {
        WebElement theSoundBar = driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='sound-bar-play']")));
    }
    public String getNotificationText(){
        WebElement notificationElement = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));
        //"div.success.show"
        return notificationElement.getText();
    }
    public void clickPlaylistSvyeta() throws InterruptedException {
        WebElement playlistSvyeta = driver.findElement(By.cssSelector("a[href='#!/playlist/54983']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/playlist/54983']"))).click();
    }
    public void clickRedBtnDeletePlaylist() throws InterruptedException {
        WebElement redBtnDeletePlaylist = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='del btn-delete-playlist']"))).click();
    }
    public void clickNewPlaylistIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("i[title='Create a new playlist']"))).click();
    }
    public void newPlaylistOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("#playlists > nav > ul > li:nth-child(1)"))).click();
    }
    public void enterNewPlaylistName(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
               ("section#playlists>form>input[required='required']")));
       WebElement addNewPlaylistName = driver.findElement(By.cssSelector
               ("section#playlists>form>input[required='required']"));
        addNewPlaylistName.sendKeys("Svyeta");
        addNewPlaylistName.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/ul/li[3]/a")));
        WebElement clickPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        actions.doubleClick(clickPlaylist).perform();
    }
}