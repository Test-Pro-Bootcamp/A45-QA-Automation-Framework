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
import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;
    public static ThreadLocal <WebDriver> threadDriver;

    public static String url = "";
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    @BeforeSuite

    static void setupClass() {


        // WebDriverManager.chromedriver().setup();
         //WebDriverManager.firefoxdriver().setup();
    }
 @BeforeMethod
 @Parameters ({"BaseUrl"})
     public void launchBrowser(String BaseUrl) throws MalformedURLException {

       // ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseUrl;
        getDriver().get(url);
        navigateToPage();



 }
     public void navigateToPage(){
        getDriver().get(url);
    }
@AfterMethod
    public void tearDownBrowser (){
        getDriver().quit();
        threadDriver.remove();
}
    public void closeBrowser() { getDriver().quit(); }

    public static WebDriver pickBrowser (String browser) throws MalformedURLException {
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
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);


        }
    }

    public WebDriver getDriver (){
        return threadDriver.get();
    }
    public static void provideEmail (String email){

     WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']"))).click();
     //emailField.click();
     emailField.clear();
     emailField.sendKeys(email);
    }
    public static void providePassword (String password) {

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']"))).click();
        //passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit (){
        WebElement clickSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

        //clickSubmit.click();
    }

}


