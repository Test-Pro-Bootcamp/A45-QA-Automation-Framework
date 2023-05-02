import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework17Test extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotificationText = "Added 1 song into";
        launchBrowser();
        goToPage();
        inputEmail("cherjagne85@gmail.com");
        inputPassword("Teststudent@123");
        clickSubmit();
        searchSongTitle("BossStatus");
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        addToPlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));


    }
}