import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest  {

@Test
    public void addSongToPlaylist() throws InterruptedException {

    String newSongAddedNotificationText = "Added 1 song into";
    openLoginUrl();
    inputEmail();
    inputPassword();
    clickLogin();
    searchSong();
    clickAllSongs();
    selectFirstSong();
    addToPlaylist();
    chooseTestProPlaylistName();
    Assert.assertTrue(getNotificationText().contains("Added 1 song into"));
}
}
