import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistsPage;

public class Homework25 extends BaseTest {
    String updatedMsg = "Updated playlist";

    @Test
    public void renamePlaylistTest() {
        // GIVEN
        LoginPage loginPage = new LoginPage(getThreadLocal());
        PlaylistsPage playlistsPage = new PlaylistsPage(getThreadLocal());

        // WHEN
        loginPage.provideEmail("demo@class.com").providePassword("te$t$tudent").clickSubmitBtn();
        playlistsPage.doubleClickPlaylist();
        playlistsPage.renamePlaylist("Renamed Playlist");

        //THEN
        Assert.assertTrue(playlistsPage.isNameUpdated().contains(updatedMsg));
    }
}