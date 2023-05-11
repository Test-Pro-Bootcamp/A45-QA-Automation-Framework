import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPasswordTest(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://bbb.testpro.io/
    }

    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPasswordTest(){
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        isAvatarDisplayed();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public static void loginValidEmailEmptyPasswordTest() {
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://bbb.testpro.io/
    }

    //Page Object Model example
    @Test
    public void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
}
