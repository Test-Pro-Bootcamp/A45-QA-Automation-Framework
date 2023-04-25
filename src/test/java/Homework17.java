import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest  {

@Test
    public void addSongToPlaylist() throws InterruptedException {

    String newSongAddedNotificationInSearch = "Added 1 song into";
    openLoginUrl();
    inputEmail();
    inputPassword();
    clickLogin();
    searchSong();
    clickViewAllButton();
    selectFirstSongInSearch();
    addToInSearch();
    chooseTestProPlaylistInSearch();
    Assert.assertTrue(getNotificationInSearch().contains("Added 1 song into"));
}
}
