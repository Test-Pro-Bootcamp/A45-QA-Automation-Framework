import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {

        String playlistName = "Tony2";

        provideEmail("anton.prymak@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        String deletedPlaylist = removePlaylist(1);
        String notificationText = getNotificationText();
        Assert.assertEquals(notificationText,
                String.format("Deleted playlist \"%s.\"", deletedPlaylist));
    }

}
