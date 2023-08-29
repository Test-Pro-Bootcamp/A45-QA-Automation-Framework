import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework25PageFactoryLoginTests extends BaseTest {
    @Test
    public void validLogInCredentials()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.assertAvatar());

        //homePage.assertAvatar();

    }
    @Test (dataProvider = "IncorrectData", dataProviderClass = BaseTest.class)
    public void loginInvalidEmailInvalidPasswordTest(String email, String incorrectPassword) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideIncorrectPassword(incorrectPassword);
        //calling the object of the class (loginPage) not the class itself (LoginPage)
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.assertNotLoggedIn());
       // Assert.assertEquals(driver.getCurrentUrl(), url);

    }

}
