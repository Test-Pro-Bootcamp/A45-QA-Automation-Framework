import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

public class Homework25 extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest()   {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("svyeta@test.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
    }
    @Test
    public void LoginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("svyeta@test.com");
        loginPage.providePassword("");
        loginPage.clickSubmitButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
