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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
   public static WebDriver driver = null;
   String url = null;
    public static ChromeOptions optionC;
    static WebDriverWait wait;
    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    private static Actions actions;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


//    @BeforeSuite
  //  static void setupClass() {
     //  WebDriverManager.chromedriver().setup();
    //    WebDriverManager.firefoxdriver().setup();
   // }

    @BeforeMethod
    @Parameters({"baseURL"})

    static void setupBrowser(String baseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //   optionC = new ChromeOptions();
     //   optionC.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
    //    driver = new ChromeDriver(optionC);
     //   driver = new FirefoxDriver();
     //   driver = pickBrowser(System.getProperty("browser"));
     //  wait = new WebDriverWait(driver, Duration.ofSeconds(4));
     //  actions = new Actions(driver);
      // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      // driver.manage().window().minimize();

       driver.get(baseURL);

    }


    @AfterMethod
    public static void tearDownBrowser() {
        threadDriver.get().close();
        threadDriver.remove();
    }
    public static WebDriver pickBrowser(String browser)throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.181:4444";

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-edge":
                caps.setCapability("browser","edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browser","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browser","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();
                optionC = new ChromeOptions();
                optionC.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
                return driver = new ChromeDriver(optionC);

        }
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

    public static void searchSong(String songTitle){
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='search']"))).sendKeys(songTitle);
        //searchBar.sendKeys(songTitle);
    }

    public static void clickViewAll(){
        WebElement searchResults = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='view-all-songs-btn']"))).click();
    }

    public static void selectSong(){
        WebElement chooseSong = driver.findElement(By.cssSelector("section#songResultsWrapper div.item-container tr.song-item td.title"));
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper div.item-container tr.song-item td.title"))).click();
    }

    public static void clickAddTo(){
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to"))).click();
    }

    public static void choosePlaylist(){
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"))).click();
    }

    public static void deleteButton() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist"))).click();
        // deletePlaylist.click();
    }
    public static void choosePlaylistToDelete() {
        WebElement playlistToDelete = driver.findElement(By.cssSelector("[href = '#!/playlist/54189']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href = '#!/playlist/54189']"))).click();
        //playlistToDelete.click();
    }

    public static void getUserAvatar(){
        WebElement userAvatar = driver.findElement(By.cssSelector("#userBadge > a.view-profile > img"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userBadge > a.view-profile > img")));
    }


    public String confirmDelete() {
        WebElement deleteConfirmation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return deleteConfirmation.getText();
    }
}
