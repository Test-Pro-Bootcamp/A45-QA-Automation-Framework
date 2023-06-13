import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {
    public WebDriver driver = null;
    public static ThreadLocal<WebDriver> threadDriver;

    public String url = "";
    public WebDriverWait wait = null;
    public Actions actions = null;

 @BeforeMethod
 @Parameters ({"BaseUrl"})
     public void navigateToPage(String BaseUrl) throws MalformedURLException {

        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseUrl;
        getDriver().get(url);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        url = BaseUrl;
        getDriver().get(url);
 }

@AfterMethod
    public void tearDownBrowser (){
        getDriver().quit();
        threadDriver.remove();
}
public static WebDriver getDriver (){ return threadDriver.get();}


    public WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.42:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();

            case "grid-firefox":
                caps.setCapability("browserName","firefox" );
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-edge":
                caps.setCapability("browserName","edge" );
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome" );
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "Lambda":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }
    public WebDriver lambdaTest() throws MalformedURLException {
     String userName ="pavel.furnic";
     String accessToken = "ZON6n7JqP2ubbrbvoP4QC2nOnfKAU6fsoqPkWfeS7jD6navi4W";
     String hubUrl ="https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", accessToken);
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubUrl),browserOptions);

    }

    public void provideEmail (String email){

     WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']"))).click();
     emailField.click();
     emailField.clear();
     emailField.sendKeys(email);
    }
    public void providePassword (String password) {

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']"))).click();
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit (){
        WebElement clickSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

        clickSubmit.click();
    }
}


