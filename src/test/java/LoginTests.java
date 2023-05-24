import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import java.time.Duration;
import pageFactory.HomePage;
import pageFactory.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {
    @Test
    public static void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("").providePassword("te$t$tudent").clickSubmitButton();

        Assert.assertTrue(loginPage.getBirdLogo());
    }

    @Test
    public static void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("demo@class.com").providePassword("te$t123").clickSubmitButton();

        Assert.assertTrue(loginPage.getBirdLogo());
    }

    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();

        Assert.assertTrue(homePage.getUserAvatar());
    }
}


