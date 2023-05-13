import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BaseTest {
    static WebDriver driver;
    static String url;
    static WebDriverWait wait;
    Actions actions;
    static ThreadLocal <WebDriver> threadDriver;

    //public static WebDriver driver = null;
    //public  ThreadLocal<WebDriver> threadDriver;
    //public static WebDriverWait wait = null;
    //public static Actions actions = null;
    //public static String url = "";

    @BeforeSuite
    static void setupClass() {

        //WebDriverManager.chromedriver().setup();
//        WebDriverManager .safaridriver() .setup() ;
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
        url = BaseURL;

       // public  WebDriver getDriver() {
          //  return threadDriver.get();
        //      Added ChromeOptions argument below to fix websocket error
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //driver = new ChromeDriver(options);
        //driver = new SafariDriver();
        threadDriver = new ThreadLocal<>() ;
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //lets add code to maximize browser window
        //driver.manage().window().maximize();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5) );
        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        url = BaseURL;
        getDriver().get(url);
        navigateToPage();
    }



//public WebDriver pickBrowser (String browser) throws MalformedURLException {
    //DesiredCapabilities capabilities = new DesiredCapabilities() ;
    //String gridURL = "http://192.168.1.67:1234";


    @AfterMethod//(enabled = false)
    public void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();//added this line to remove the current thread values

    }

    public  WebDriver getDriver(){
       return threadDriver.get();//we use this
//        return driver;
    }
    public void tearDownBrowser(){
        getDriver().quit();
        //return driver;
        threadDriver.remove();

    }
    public static  WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String myGridUrl = "http://192.168.1.178:4444/";

        switch (browser) {
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver= new SafariDriver();

            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(myGridUrl).toURL(), capabilities);

            case "grid-chrome":
            capabilities.setCapability("browserName", "chrome");
            return driver = new RemoteWebDriver(URI.create(myGridUrl).toURL(), capabilities);

            case"lambda":
             return lambdaTest();

             default:
                WebDriverManager .chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }
    //pavlyuk.daria81
            //fyipWm6hV2KISCPnsQTtgjN7VEyA8QKCkDPAhVP8LI31j5VY8I
    public static WebDriver  lambdaTest() throws MalformedURLException {
        String username="pavlyuk.daria81";
        String accessToken = "fyipWm6hV2KISCPnsQTtgjN7VEyA8QKCkDPAhVP8LI31j5VY8I";
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "pavlyuk.daria81");
        ltOptions.put("accessKey", "fyipWm6hV2KISCPnsQTtgjN7VEyA8QKCkDPAhVP8LI31j5VY8I");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
    public static void navigateToPage() {
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }

    public static void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void clickAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }

    // hover
    public void hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        // move to element
        actions.moveToElement(play).perform();
    }

    // context click
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs")));
        driver.findElement(By.cssSelector("li a.songs")).click();
    }

    public void contextClickFirstSong(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        // context click
        actions.contextClick(firstSong).perform();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        // double click
        WebElement playlist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(playlist).perform();
    }
        }
