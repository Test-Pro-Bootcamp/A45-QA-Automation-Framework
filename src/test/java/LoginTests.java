import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("kcroker@testpro.io")
                .providePassword("te$t$tudent")
                .clickSubmit();

        Assert.assertTrue(homePage.isAvatarDisplayed());

    }
}