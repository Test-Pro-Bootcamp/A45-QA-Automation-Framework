import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest {
    @Test
     public void addSongToPlaylist() throws InterruptedException {

       String notifacationMessageText = "Added 1 song into";

       navigateToPage();
       enterCredentials();
       searchSong("ketsa");
       clickViewAllButton();
       clickFirstSong();
       addToPlaylist();
       Assert.assertTrue(getNotificationMessage().contains(notifacationMessageText));
    }

}
