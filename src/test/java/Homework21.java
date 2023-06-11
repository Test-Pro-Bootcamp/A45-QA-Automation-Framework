import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() {
        provideEmail("anton.prymak@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        doubleClickChoosePlaylist();
        enterNewPlaylistName();
        Assert.assertTrue(showSuccess());
    }
}
