import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
public class Homework22 extends BaseTest {
    @Test
    public void renamePlaylist(){
        String playlistName = "Ike";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }
}

