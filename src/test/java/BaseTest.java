import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public String url = "https://bbb.testpro.io/";

    public static WebDriver driver = null;
    public WebDriverWait wait = null;
    public Actions actions = null;

    public ThreadLocal<WebDriver> threadDriver;

    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();

    }

    @Parameters({"BaseUrl"})
    @BeforeMethod
    public void launchBrowser(String BaseUrl) throws MalformedURLException {

	        /*ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");

	        driver = new ChromeDriver(options);*/

        driver = pickBrowser(System.getProperty("browser"));

        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(BaseUrl);
        Assert.assertEquals(driver.getCurrentUrl(), BaseUrl);

    }

	    /*public void login(String email, String password) {
	        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
	        emailField.sendKeys(email);

	        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
	        passwordField.sendKeys(password);

	        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
	        submitButton.click();

	    }

	    public void doubleClickPlaylist() {

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
	        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
	        actions.doubleClick(playlistElement).perform();

	    }

	    public void enterNewPlaylistName() {

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
	        WebElement playlistInputField = driver.findElement(By.cssSelector("[name='name']"));
	        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
	        playlistInputField.sendKeys(newPlaylistName);
	        playlistInputField.sendKeys(Keys.ENTER);

	    }*/

	    /*public boolean doesPlaylistExist() {
	        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + playlistName + "']")));
	        return playlistElement.isDisplayed();
	    }*/

    @AfterMethod
    public void quitBrowser() {

        driver.quit();

    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException{

        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.148:4444/ui";

        switch(browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "Microsoft Edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);

        }
    }

    public WebDriver getDriver(){
        return threadDriver.get();
    }

    @AfterMethod
    public void tearDownBrowser(){
        getDriver().quit();
        threadDriver.remove();
    }

    public static WebDriver lambdaTest() throws MalformedURLException {

        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "kcroker7");
        ltOptions.put("accessKey", "U1nNbVqjliQcaRtJIGzStnev9Fafl2yYkj1mOMfZt0IBIvPotv");
        ltOptions.put("build", "lambdaBuildName");
        ltOptions.put("project", "lambdaProjectName");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

}