import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.time.Duration;


//        3. Create a test case, registrationNavigation() using @Test annotation.
////        4. Using Selenium, navigate to "https://bbb.testpro.io/".
//        5. Click the Registration link.
//
//        6. Verify that you are redirected to Registration page using Assert method.

public class Homework16 extends BaseTest {

    //  Create a test case, registrationNavigation() using @Test annotation.
    @Test
    public static void registrationNavigation(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Using Selenium, navigate to "https://bbb.testpro.io/"
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click(); // Click the Registration link

       // Verify that the page redirected to Registration page using Assert method
        String registrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(),registrationUrl);

        driver.quit();


    }

}
