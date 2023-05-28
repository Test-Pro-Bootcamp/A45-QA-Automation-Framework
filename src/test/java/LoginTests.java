import POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    //@Parameters({"BaseURL"})
    public static void LoginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
    }
    @Test
    //@Parameters({"BaseURL"})
    public static void LoginWrongEmail() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("sdf@gmail.com").providePassword("te$t$tudent").clickSubmitBtn().submitBtnDisplayed();
    }
    @Test
    //@Parameters({"BaseURL"})
    public static void LoginWrongPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("asdASD@mail.com").providePassword("teststudent").clickSubmitBtn().submitBtnDisplayed();
    }
    @Test
    //@Parameters({"BaseURL"})
    public static void LoginEmptyEmailAndPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("").providePassword("").clickSubmitBtn().submitBtnDisplayed();
    }
}

