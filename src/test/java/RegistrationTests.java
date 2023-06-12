import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
public class RegistrationTests extends BaseTest {
    @Test
    public void navigationToRegistrationPage() {
        String registrationUrl = "https://qa.koel.app/registration.php";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickRegistrationSign();
        Assert.assertEquals(getDriver().getCurrentUrl(), registrationUrl);
    }
}
