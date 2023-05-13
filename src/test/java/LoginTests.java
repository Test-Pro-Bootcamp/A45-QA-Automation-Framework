import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import pageFactory.HomePage;
import pageFactory.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public static void LoginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
//      Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();
    }
}
