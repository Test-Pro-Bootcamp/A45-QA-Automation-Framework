import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework23LoginTests extends BaseTest {


    @Test (dataProvider = "IncorrectData", dataProviderClass = BaseTest.class)
    public void loginInvalidEmailInvalidPasswordTest(String email, String incorrectPassword) throws InterruptedException {
        provideIncorrectEmail(email);
        provideIncorrectPassword(incorrectPassword);
        logInButton();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void ValidLogInCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.assertAvatar();

    }
}
