import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationNavigationTest extends BaseTest {
    @Test
    public void registrationNavigation() {

        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();

        String registrationUrl = "https://bbb.testpro.io/registration.php";

        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

    }
}
