import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BaseTest {
    public static WebDriver driver = null;
    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = "";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @DataProvider(name="IncorrectLoginData")
    public static Object[][] getDataFromDataProviders() {

        return new Object[][] {
                {"invalid@mail.com", "invalidPass"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        //      Added ChromeOptions argument below to fix websocket error
        //threadDriver = new ThreadLocal<>();
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        //threadDriver.set(driver);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        url = BaseURL;
        navigateToPage();
    }
    @AfterMethod//(enabled = false)
    public void closeBrowser() {
       getDriver().quit();
        threadDriver.remove();
    }

    public static WebDriver getDriver(){
       //return driver;
       return threadDriver.get();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "192.168.1.168:4444";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        switch (browser){
            case "chrome":
                return driver = new ChromeDriver(options);
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "grid-Edge":
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-Chrome":
                caps.setCapability("browserName","Chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver(options);
        }
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String userName = "andrei.bryliakov";
        String accessToken = "MLm6XdKZYwamVaCDr9J7NPf9DZ46P4ta1JDjnqdAOYeXgMJR6q";
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", accessToken);
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    public static void navigateToPage() {
        getDriver().get(url);
    }

    public static void provideEmail(String email) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail(email);
    }
    public static void providePassword(String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.providePassword(password);
    }
    public static void clickSubmit() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickSubmit();
    }
    public static void clickSaveButton() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickSaveButton();
    }
    public static void provideProfileName(String randomName) {
        ProfilePreferencesPage profilePreferencesPage = new ProfilePreferencesPage(getDriver());
        profilePreferencesPage.provideProfileName(randomName);
    }
    public static void provideCurrentPassword(String password) {
        ProfilePreferencesPage profilePreferencesPage = new ProfilePreferencesPage(getDriver());
        profilePreferencesPage.provideCurrentPassword(password);
    }
    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    public static void clickAvatarIcon() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAvatarIcon();
    }
    // hover
    public void hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        // move to element
        actions.moveToElement(play).perform();
    }
    public void clickPlayButton(){
      HomePage homePage = new HomePage(driver);
      homePage.clickPlayButton();
    }
    // context click
    public void chooseAllSongsList() {
        BasePage basePage = new BasePage(driver);
        basePage.chooseAllSongsList();
    }
    public void contextClickFirstSong(){
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        allSongsPage.contextClickFirstSong();
    }
    public void displayAllSongs() {
        chooseAllSongsList();
    //add assertion
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item")));
        List<WebElement> songsList = driver.findElements(By.cssSelector(".all-songs tr.song-item"));
        Assert.assertEquals(songsList.size(), 63);
    }
    // double click
    public void doubleClickChoosePlaylist() {
        HomePage homePage = new HomePage(getDriver());
        homePage.doubleClickFirstPlaylist();
    }
}