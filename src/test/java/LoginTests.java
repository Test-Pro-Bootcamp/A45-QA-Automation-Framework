import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("11111111*a")
                .clickSubmitBtn();

        Assert.assertTrue(homePage.isUserAvatarDisplayed());
    }
    @Test
    public void loginValidEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.isClickSubmitBtnDisplayed());
    }
    @Test
    public void loginEmptyEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("")
                .providePassword("")
                .clickSubmitBtn();

        Assert.assertTrue(loginPage.isClickSubmitBtnDisplayed());
    }
}
