import POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    @Parameters({"BaseURL"})
    public static void LoginEmptyEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();
    }
}
