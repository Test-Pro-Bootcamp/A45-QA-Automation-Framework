import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class homework25 extends BaseTest {
    @Test
    public void renamePlaylist() {

        String playlistName = "kcroker playlist homework24";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();

        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(playlistName);
        homePage.isAvatarDisplayed();

    }

}