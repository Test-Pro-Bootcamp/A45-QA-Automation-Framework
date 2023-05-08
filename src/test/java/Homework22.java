import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

@Test
public class Homework22 extends BaseTest {

    public void renamePlaylist() {
        //GIVEN
        String playlistName = "Homework22A";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //WHEN
        loginPage.login();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        //THEN
        Assert.assertTrue(homePage.playlistExists(playlistName));
    }
}