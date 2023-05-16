import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static java.sql.DriverManager.getDriver;

public class Homework25 extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest() throws MalformedURLException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

          loginPage.provideValidLogin();

        Assert.assertTrue(homePage.getUserAvatar());
    }
    @Test
    public void LoginEmptyPasswordTest() throws MalformedURLException {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("svyeta@test.com");
        loginPage.providePassword("");
        loginPage.clickSubmitButton();

        Assert.assertTrue(loginPage.getBirdLogo());
    }
}
