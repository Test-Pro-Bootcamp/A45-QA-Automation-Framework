import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

// Import necessary packages and classes for working with WebDriver,
// browser configurations, and executing automated tests using TestNG.

public class BaseTest {

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    // THREAD_LOCAL of type ThreadLocal<WebDriver>. ThreadLocal is a mechanism that allows
    // storing and retrieving unique variable values for each thread. In this case,
    // ThreadLocal<WebDriver> will be used to store an instance of WebDriver
    // associated with each thread during test execution.

    private WebDriver driver = null;
    // Here, a variable named driver of type WebDriver is declared and initialized with null.
    // By default, driver doesn't have a reference to a WebDriver instance.

    private int timeSeconds = 3;
    // This line declares a variable named timeSeconds of type int and initializes it with the value 3.
    // This variable represents the number of seconds used in the code to define time intervals, such as element waits or timeouts.

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }
    // This getThreadLocal() method returns the current instance of WebDriver associated with the current thread.

    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeSeconds));
        getThreadLocal().get(baseURL);
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());

    }
    // This setUpBrowser() method is marked with the @BeforeMethod annotation from TestNG and executes before each test method.
    // It sets up the browser, configures it, and opens the specified baseURL. It also prints information about the browser setup to the console.


public WebDriver lambdaTest() throws MalformedURLException {
    String username = "veena.sreenidish";
    String authkey = "g3sQAKbYYjxtDxg0s78jmj2UNlgZYYUc1rfSyoGa4CxWWlezHx";
    String hub = "@hub.lambdatest.com/wd/hub";
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("platform", "Windows 10");
    caps.setCapability("browserName", "Chrome");
    caps.setCapability("version", "110.0");
    caps.setCapability("resolution", "1024x768");
    caps.setCapability("build", "TestNG With Java");
    caps.setCapability("name", this.getClass().getName());
    caps.setCapability("plugin", "git-testng");
    return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
}

    // This lambdaTest() method returns an instance of WebDriver for remote testing using the LambdaTest service.


    // Below code is lambdaTest() method using Automation Capabilities Generator with Chrome Browser Version "114.0"

//    public WebDriver lambdaTest() throws MalformedURLException {
//        String hubURL = "https://hub.lambdatest.com/wd/hub";
//        String username = "veena.sreenidish";
//        String accessToken = "g3sQAKbYYjxtDxg0s78jmj2UNlgZYYUc1rfSyoGa4CxWWlezHx";
//
//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setPlatformName("Windows 10");
//        browserOptions.setBrowserVersion("114.0");
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", username);
//        ltOptions.put("accessKey", accessToken);
//        ltOptions.put("project", "Untitled");
//        ltOptions.put("selenium_version", "4.0.0");
//        ltOptions.put("w3c", true);
//        browserOptions.setCapability("LT:Options", ltOptions);
//        return new RemoteWebDriver(new URL(hubURL), browserOptions);
//    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.2.127.17:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
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

    // This pickBrowser() method selects and returns an instance of WebDriver depending on the passed browser parameter.

    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
    // The tearDown() method is executed after each test method (@AfterMethod),
    // and its purpose is to close the WebDriver and remove its instance from ThreadLocal.
}