
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;
import pom.Registration;

import java.time.Duration;


public class RegistrationTests extends BaseTest {
    @Test
    public void registrationNavigation() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Registration registration = new Registration(driver);
        registration.registration();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
    //old code
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        String url = "https://qa.koel.app/";
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//
//        String registrationUrl = "https://qa.koel.app/registration";
//        WebElement registration = driver.findElement(By.cssSelector("a[id='hel']"));
//        registration.click();
//        Assert.assertEquals(driver.getCurrentUrl(),registrationUrl);
//        Thread.sleep(1000);
//        driver.quit();
//    }


