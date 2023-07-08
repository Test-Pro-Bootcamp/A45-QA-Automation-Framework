import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Test (dataProvider = "IncorrectData", dataProviderClass = BaseTest.class)
    public void loginInvalidEmailInvalidPasswordTest(String email, String incorrectPassword) throws InterruptedException {
        provideIncorrectEmail(email);
        provideIncorrectPassword(incorrectPassword);
        logInButton();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void ValidLogInCredentials() throws InterruptedException {
        loginPage.login();
        homePage.assertAvatar();

    }
}
