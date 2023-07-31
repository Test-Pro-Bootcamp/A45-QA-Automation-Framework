import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework24LoginTests extends BaseTest {

//add this to SmokeTestxml for hw24
    @Test (dataProvider = "IncorrectData", dataProviderClass = BaseTest.class)
    public void loginInvalidEmailInvalidPasswordTest(String email, String incorrectPassword) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        provideIncorrectEmail(email);

        loginPage.provideIncorrectPassword(incorrectPassword);
        //calling the object of the class (loginPage) not the class itself (LoginPage)
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void validLogInCredentials()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.assertAvatar());

        //homePage.assertAvatar();

    }
}
