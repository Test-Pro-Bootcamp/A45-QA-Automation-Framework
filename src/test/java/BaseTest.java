import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "https://testpro.io/";
    public static WebDriverWait wait;
    public static Actions actions;
    public static ThreadLocal<WebDriver> threadDriver;

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void navigateToPage (String BaseURL) throws MalformedURLException {
        threadDriver= new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        url = BaseURL;
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser () {
        //driver.quit();
        getDriver().quit();
        threadDriver.remove();
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }
    public static WebDriver lambdaTest() throws MalformedURLException {
    String hubURL = "https://hub.lambdatest.com/wd/hub";
    String token = "YUdvx9SSnkNMFMsXnPd4jurJCHv1twuHv41jidHIKWREnZv0pO";
    String username = "romeo.furnic";

    EdgeOptions browserOptions = new EdgeOptions();
    browserOptions.setPlatformName("Windows 10");
    browserOptions.setBrowserVersion("111.0");
    HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    ltOptions.put("username", username);
    ltOptions.put("accessKey", token);
    ltOptions.put("project", "Untitled");
    ltOptions.put("w3c", true);
    ltOptions.put("plugin", "java-testNG");
    browserOptions.setCapability("LT:Options", ltOptions);

    return new RemoteWebDriver(new URL(hubURL), browserOptions);
}

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL= "http://10.0.0.103:4444";

    switch (browser) {
        case "firefox" :
            WebDriverManager.firefoxdriver().setup();
            return driver = new FirefoxDriver();

        case "MicrosoftEdge" :
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--remote-allow-origins=*");
            return driver = new EdgeDriver(edgeOptions);

        case "grid-firefox":
            caps.setCapability("browserName","firefox");
            return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

        case "grid-MicrosoftEdge":
            caps.setCapability("browserName","MicrosoftEdge");
            return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

        case "grid-chrome":
            caps.setCapability("browserName","chrome");
            return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

        case "cloud":
            return lambdaTest();

        default:
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            return driver = new ChromeDriver(options);
    }
    }
}