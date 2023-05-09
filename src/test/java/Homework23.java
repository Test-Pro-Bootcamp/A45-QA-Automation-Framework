import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {

    @Test
    public void renamePlaylist() {

        String playlistName = "kcroker playlist homework22";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(playlistName);

    }

}