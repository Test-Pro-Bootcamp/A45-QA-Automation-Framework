import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


import java.time.Duration;

public class RegistrationTests extends BaseTest{
    @Test
    public void navigationToRegistrationPage(){
        String registrationUrl = "https://qa.koel.app/registration.php";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickRegistrationSign();
        //assert that page for registration is open
        Assert.assertEquals(getDriver().getCurrentUrl(),registrationUrl);




//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//
//        WebElement registrationLink = driver.findElement(By.cssSelector("#hel"));
//        registrationLink.click();
//
//        String registrationUrl = "https://bbb.testpro.io/registration.php";
//        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
//
//        driver.quit();

    }
}
