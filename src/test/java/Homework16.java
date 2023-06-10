
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework16 extends BaseTest {
    @Test

    public void registrationNavigation() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        String registrationUrl = "https://qa.koel.app/registration.php";
        WebElement registration = driver.findElement(By.cssSelector("a[id='hel']"));
        registration.click();
        Assert.assertEquals(driver.getCurrentUrl(),registrationUrl);
        Thread.sleep(1000);
        driver.quit();
    }
}


