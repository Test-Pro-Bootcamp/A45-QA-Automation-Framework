import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public static void loginEmptyEmailPasswordTest() {
        // GIVEN
        LoginPage loginPage = new LoginPage(getThreadLocal());

        // WHEN
        loginPage.provideEmail("");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void loginWrongPasswordTest() {
        // GIVEN
        LoginPage loginPage = new LoginPage(getThreadLocal());

        // WHEN
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t123");
        loginPage.clickSubmitBtn();

        // THEN
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void loginEmptyPasswordTest() {
        // GIVEN
        LoginPage loginPage = new LoginPage(getThreadLocal());

        // WHEN
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("");
        loginPage.clickSubmitBtn();

        // THEN
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void loginWrongEmailTest() {
        // GIVEN
        LoginPage loginPage = new LoginPage(getThreadLocal());

        // WHEN
        loginPage.provideEmail("demo.class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        // THEN
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public void loginSucceedTest() {
        // GIVEN
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        // WHEN
        loginPage.provideLoginSucceed();

        // THEN
        Assert.assertTrue(homePage.getUserAvatar());
    }
}