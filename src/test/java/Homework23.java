import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistsPage;

public class Homework23 extends BaseTest {
    String updatedMsg = "Updated playlist";

    @Test
    public void renamePlaylistTest() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistsPage playlistsPage = new PlaylistsPage(driver);

        loginPage.provideEmail("demo@class.com").providePassword("te$t$tudent").clickSubmit();
        playlistsPage.doubleClickPlaylist();
        playlistsPage.renamePlaylist("Renamed Playlist");
        Assert.assertTrue(playlistsPage.isNameUpdated().contains(updatedMsg));
    }
}