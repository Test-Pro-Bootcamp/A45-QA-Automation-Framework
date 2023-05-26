import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork16 extends BaseTest{
    @Test
    public void testRegistrationNavigation(){

        // Pre-condition
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        //Steps
        WebElement registration = driver.findElement(By.cssSelector("a#hel"));
        registration.click();

        WebElement registrationPage = driver.findElement(By.cssSelector("div>h2"));

        Assert.assertTrue(registrationPage.isDisplayed());
//        Assert.assertEquals(registrationPage.isDisplayed(), true);

        driver.quit();



    }
}
