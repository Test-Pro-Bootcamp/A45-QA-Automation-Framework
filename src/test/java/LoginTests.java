import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPasswordTest(String username, String password) {

        provideEmail(username);
        providePassword(password);
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); // https://bbb.testpro.io/
    }
    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public static void loginValidEmailEmptyPasswordTest() {
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://bbb.testpro.io/
    }
    public static void isAvatarDisplayed() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    //Page Object Model example
    @Test
    public void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}