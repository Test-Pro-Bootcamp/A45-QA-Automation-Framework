import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class LoginTests extends BaseTest {

     @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPasswordTest(String username, String password) {
         LoginPage loginPage = new LoginPage(driver);
         loginPage.provideEmail(username);
         loginPage.providePassword(password);
         loginPage.clickSubmitBtn();
         Assert.assertEquals(driver.getCurrentUrl(), url); // https://bbb.testpro.io/
     }


         @Test(enabled = true, priority = 1, description = "Login with valid email and valid password")
         public void loginValidEmailPasswordTest () {
             LoginPage loginPage = new LoginPage(driver);
             HomePage homePage = new HomePage(driver);
             loginPage.provideEmail("daria.pavlyuk@testpro.io").providePassword("te$t$tudent").clickSubmitBtn();
             Assert.assertTrue(homePage.isAvatarDisplayed());

         }
         @Test(enabled = true, priority = 3, description = "Login with valid email and empty password")
         public void loginValidEmailEmptyPasswordTest () {
             //LoginPage loginPage = new LoginPage(getDriver());

             //loginPage.provideEmail("daria.pavlyuk@testpro.io");
             //loginPage.providePassword("");


         }
     }

