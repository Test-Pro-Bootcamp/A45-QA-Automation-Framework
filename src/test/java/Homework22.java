import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {

    @Test
    public void renamePlaylist() {
        String playlistName = "Test Pro Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }
}


