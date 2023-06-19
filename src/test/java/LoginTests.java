import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test (dataProvider = "IncorrectData", dataProviderClass = BaseTest.class)
    public void loginInvalidEmailInvalidPasswordTest(String email, String incorrectPassword) throws InterruptedException {
        provideIncorrectEmail(email);
        provideIncorrectPassword(incorrectPassword);
        logInButton();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void ValidLogInCredentials() throws InterruptedException {
        provideEmail();
        providePassword();
        logInButton();
        assertAvatar();
    }
}
