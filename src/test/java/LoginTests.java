import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("pdr.deepthi@gmail.com");
        loginPage.providePassword("te$t$tudent1");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
    }

    @Test
    public  void loginValidEmailEmptyPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("pdr.deepthi@gmail.com");
        loginPage.providePassword("");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.isRegistrationLinkDisplayed());

    }
    @Test
    public void loginInvalidEmailValidPasswordTest(){

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("demo.class@gmail.com");
        loginPage.providePassword("te$t$tudent1");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.isRegistrationLinkDisplayed());

    }
}
