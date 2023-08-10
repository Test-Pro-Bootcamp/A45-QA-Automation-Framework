import org.testng.annotations.Test;

public class PlaylistRename extends BaseTest{


    @Test
    public void renamePlaylist() {
        login();
        enterNewPlaylistName();
        validateRenamedPlaylist();

    }

}
