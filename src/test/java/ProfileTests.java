import POM.HomePage;
import POM.LoginPage;
import POM.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileNameTest () throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.provideEmail("pdr.deepthi@gmail.com");
        loginPage.providePassword("te$t$tudent1");
        loginPage.clickSubmit();

        homePage.clickAvatarIcon();

        String randomName = (profilePage.generateRandomName());

        profilePage.provideCurrentPassword("te$t$tudent");
        profilePage.provideProfileName(randomName);
        profilePage.clickSaveButton();


        Assert.assertEquals(profilePage.getCurrentProfileName(), randomName);
    }
}
