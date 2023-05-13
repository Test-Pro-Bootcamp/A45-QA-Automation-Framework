import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.ProfilePage;

public class ProfileTests extends BaseTest {
    @Test
    public void changeProfileNameTest ()   {

        String randomName = ProfilePage.generateRandomName();

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.provideEmail("daria.pavlyuk@testpro.io")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();

        homePage.clickAvatarIcon();


        profilePage.provideCurrentPassword("te$t$tudent")
                   .provideProfileName(randomName)
                   .clickSaveButton();

        Assert.assertEquals(profilePage.getCurrentProfileName(), randomName);
    }
}
