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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    static WebDriverWait wait;
    String url = "";
    public static WebDriver driver = null;
    public static Actions actions = null;
    String newPlaylistName = "Updated playlist";

    @BeforeSuite
    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
    }
    @DataProvider(name="InvalidLoginCredentials")
    public static Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"Invalid@mail.com","InvalidPassword"},
                {"demo@class.com",""},
                {"",""}
        };
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void openLoginUrl(String BaseURL) throws MalformedURLException {

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        driver = new FirefoxDriver();
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.manage().window().maximize();
        url = BaseURL;
        navigateToPage();
    }
    public void navigateToPage(){driver.get(url);}

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.10.10.26:4444";
        switch (browser) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            }
            case "MicrosoftEdge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
                eOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new EdgeDriver(eOptions);
            }
            case "grid-edge" -> {
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            }
            case "grid-firefox" -> {
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            case "grid-chrome" -> {
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(options);
            }
        }
    }
    public void openAllSongs(){
        WebElement clickOpenAllSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        clickOpenAllSongs.click();
    }
    public void playSong(){
        WebElement clickPlaySongBTN = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        clickPlaySongBTN.click();
    }
    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
    public void logIn(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("input[type='email']")))).click();
        emailField.clear();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']"))).click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))); //driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();
    }
    public void searchSong(String songTitleKeyword) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='search']"))).click();
        searchField.sendKeys(songTitleKeyword);
    }
    public void clickViewAllButton()  {
        WebElement viewAllSearchResults = driver.findElement(By.cssSelector("div.results h1 > button"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results h1 > button")));
        viewAllSearchResults.click();
    }
    public void selectFirstSongResult() {
        WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper div.song-list-wrap div.virtual-scroller.scroller div.item-container  table.items tr.song-item td.title"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper div.song-list-wrap div.virtual-scroller.scroller div.item-container  table.items tr.song-item td.title")));
        firstSongResult.click();
    }
    public void clickAddToBtn()  {
        WebElement addToBtn = driver.findElement(By.cssSelector("section#songResultsWrapper button.btn-add-to"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper button.btn-add-to")));
        addToBtn.click();
    }
    public void choosePlaylist()  {
        WebElement playListElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']// li[contains(text(),'TEST')]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']// li[contains(text(),'TEST')]")));
        playListElement.click();
    }
    public void getNotificationText() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(notificationElement.getText(), "Added 1 song into \"TEST.\"");
    }
    public void openPlaylist(){
        WebElement playList = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        playList.click();
    }
    public void clickDeletePlaylistBtn(){
        WebElement deleteBTN = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deleteBTN.click();
    }
    public String getDeletedPlaylistMSG(){
        WebElement deletionMSG = driver.findElement(By.cssSelector("div.success.show"));
        return deletionMSG.getText();
    }

    public void doubleClickPlaylist(){
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playListElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(){
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+newPlaylistName+"']")));
        return playListElement.isDisplayed();
    }
}