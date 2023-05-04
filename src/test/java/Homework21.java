import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {

        login("kcroker@testpro.io", "te$t$tudent");
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertTrue(doesPlaylistExist());

    }

}