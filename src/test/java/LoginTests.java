import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class LoginTests extends BaseTest {

  //  @Test// (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with invalid email and valid password")
//    public void loginInvalidEmailValidPasswordTest(String username, String password){
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.provideEmail(username);
//        loginPage.providePassword(password);
//         loginPage.clickSubmitBtn();
//        Assert.assertEquals(driver.getCurrentUrl(), url); // https://bbb.testpro.io/
//    //
//
    @Test ( description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("")
                 .providePassword("te$t$tudent")
                 .clickSubmitBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(), url); // https://bbb.testpro.io/
        Thread.sleep(10000);
        //
    }

    //@Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    //public void loginValidEmailPasswordTest(){
        //provideEmail("demo@class.com");
        //providePassword("te$t$tudent");
        //clickSubmit();
        //isAvatarDisplayed();
        //LoginPage loginPage = new LoginPage(driver);
        //HomePage homePage = new HomePage(driver);
        //loginPage.provideEmail("demo@class.com").providePassword("te$t$tudent").clickSubmit();
        //Assert.assertEquals(homePage.getUserAvatar().isDisplayed());

    //}

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public void loginValidEmailEmptyPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("daria.pavlyuk@testpro.io");
        loginPage.providePassword("");
        loginPage.clickSubmitBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://bbb.testpro.io/
        Thread.sleep(10000);
    }

    //Page Object Model example
    @Test
    public void LoginValidEmailPasswordTest () throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("daria.pavlyuk@testpro.io")
                .providePassword("te$t$tudent")
                 .clickSubmitBtn();

        Assert.assertTrue(homePage.isAvatarDisplayed());
        Thread.sleep(10000);
    }
}
