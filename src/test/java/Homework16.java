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
    public void registrationNavigationTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins1=*");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.linkText("Registration"));
        registrationLink.click();

        String expectedUrl = "https://bbb.testpro.io/registration";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        driver.quit();
    }
}
