import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import org.testng.annotations.Test;

@Test
public class Homework16 extends BaseTest {

    public void registrationNavigation(){

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");

    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url = "https://bbb.testpro.io/";
    driver.get(url);

    WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
    registrationLink.click();

    String registrationUrl = "http://bbb.testpro.io/registration.php";
    Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

    driver.quit();

    }

}
