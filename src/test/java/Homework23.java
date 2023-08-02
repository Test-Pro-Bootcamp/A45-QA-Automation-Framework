import org.testng.Assert;
import org.testng.annotations.Test;
import pages.POM.HomePage;
import pages.POM.LoginPage;

public class Homework23 extends BaseTest{

    @Test
    public void renamePlaylist(){
        String playlistName = "The best of the best";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleCLickPlaylist();
        homePage.enterNewPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }
}
