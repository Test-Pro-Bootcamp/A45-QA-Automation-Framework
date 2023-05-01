import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @DataProvider(name="IncorrectLoginData")
    public static Object [][] getDataFromDataProviders(){

        return new Object[][]{
                {"invalid@mail.com", "invalidPass"},
                {"yuliia.tkachenko@testpro.io", ""},
                {"", ""}
        };
    }



    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPasswordTest(String username, String password){

        provideEmail(username);
        providePassword(password);
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://bbb.testpro.io/
    }

    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPasswordTest(){
        provideEmail("yuliia.tkachenko@testpro.i0");
        providePassword("te$t$tudent");
        clickSubmit();
        isAvatarDisplayed();
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public static void loginValidEmailEmptyPasswordTest() {
        provideEmail("yuliia.tkachenko@testpro.iog");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://bbb.testpro.io/
    }
    public static void isAvatarDisplayed() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
//        Assert.assertEquals(avatarIcon.isDisplayed(), true);
    }
}
