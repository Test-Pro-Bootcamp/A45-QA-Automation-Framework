import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedNotificationText = "Deleted playlist \"kristina.matskaylo.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("kristina.matskaylo@testpro.io")
                .providePassword("11111111*a")
                .clickSubmitBtn();
        homePage.navigateToPlaylist()
                .clickRedBtnPlaylist();
        Assert.assertTrue(homePage.actualNotificationText().contains(expectedNotificationText));
    }
}
