import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework23 extends BaseTest {

    @Test

    public void renamePlaylist() {

        String playlistName = "test playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        homePage.doubleClickChoosePlaylist()
                .enterNewPlaylistName(playlistName);

        Assert.assertEquals (homePage.getPlaylistName(), playlistName);
    }

}
