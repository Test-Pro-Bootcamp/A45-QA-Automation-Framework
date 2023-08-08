import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void ValidLogInCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.assertAvatar();
    }

    @Test (dataProvider = "IncorrectData", dataProviderClass = BaseTest.class)
    public void loginInvalidEmailInvalidPasswordTest(String email, String incorrectPassword) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail();
        loginPage.providePassword();
//        loginPage.provideIncorrectEmail(email);
//        loginPage.provideIncorrectPassword(incorrectPassword);
//        loginPage.clickSubmit();
//        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
