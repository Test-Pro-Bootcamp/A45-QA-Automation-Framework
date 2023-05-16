
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


@Test
public class Homework23 extends BaseTest {

    public void renamePlaylist() {
        //GIVEN
        String playlistName = "Homework23A";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //WHEN
        loginPage.login();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        //THEN
        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }
}


