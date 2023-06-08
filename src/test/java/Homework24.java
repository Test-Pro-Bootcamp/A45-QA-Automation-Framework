import PageFactory.HomePage;
import PageFactory.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework24 extends BaseTest{
    @Test
    public void renamePlaylist() {

        String playlistName = "test playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        homePage.doubleClickPlaylist()
                .enterNewPlaylistName(playlistName);

        Assert.assertEquals(homePage.getPlaylistName(), playlistName);


    }
}
