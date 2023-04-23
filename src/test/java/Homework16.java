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
    public void loginInvalidEmailValidPasswordTest() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        // Steps
        WebElement registration = driver.findElement(By.cssSelector("//a[@id=\"hel\"]"));
       registration.click();

        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://bbb.testpro.io/

        // Post-condition
        driver.quit();
    }
}
