import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void ValidLogInCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.assertAvatar();
    }
    @Test (dataProvider = "IncorrectData", dataProviderClass = BaseTest.class)
    public void loginIncorrectData(String email, String incorrectPassword) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
        loginPage.providePassword(incorrectPassword);
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
