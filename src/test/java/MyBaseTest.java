import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class MyBaseTest {

    public static WebDriver driver=null;
    public static String url = "https://bbb.testpro.io/";
    @BeforeSuite
          static void setUpClass(){ WebDriverManager.chromedriver().setup();}
    @BeforeMethod
    static void launchBrowser() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser() {
driver.quit();
    }
public static void navigateToPage(){
        driver.get(url);

    }
}




