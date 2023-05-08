import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPasswordTest(String username, String password){
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        //WHEN - THEN
        loginPage.login();
    }

    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPasswordTest(){
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //WHEN
        loginPage.login();
        //THEN
        homePage.getUserAvatar();
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public static void loginValidEmailEmptyPasswordTest() {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        //WHEN
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("");
        loginPage.clickSubmit();
        //THEN
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://bbb.testpro.io/
    }
    public static void isAvatarDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.getUserAvatar();
    }

    //Page Object Model example
    @Test
    public void LoginValidEmailPasswordTest () {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //WHEN
        loginPage.login();
        //THEN
        homePage.getUserAvatar();

    }
}
