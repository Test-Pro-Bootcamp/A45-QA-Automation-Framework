import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.Playlists;

public class RenamePlaylist extends BaseTest{
    @Test
    public void renamePlaylist(){
        String playlistName = "Edited Playlist Name";

        LoginPage loginPage = new LoginPage(driver);
        Playlists playlists = new Playlists(driver);

        loginPage.login();
        playlists.doubleClickPlaylist();
        playlists.enterNewPlaylistName(playlistName);
        Assert.assertTrue(playlists.doesPlaylistExist(playlistName));
    }
}
