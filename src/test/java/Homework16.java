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
    public static void RegistrationLink() {
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);

        WebElement registrationLik = driver.findElement(By.cssSelector("a[type='submit']"));
        registrationLik.click();

        WebElement registrationButton = driver.findElement(By.cssSelector("input[type='submit']"));

        Assert.assertTrue(registrationButton.isDisplayed());

        driver.quit();
    }
}
