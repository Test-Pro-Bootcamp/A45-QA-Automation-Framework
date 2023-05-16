import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
@Test
public class Homework24 extends BaseTest {

    public void renamePlaylist24() {
        //GIVEN
        String playlistName = "Homework24A";
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
