import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist(){
        String mNotficationText="Added 1 song into"; //TestPlaylist"
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("dark");
        clickViewAllButton();
        clickFirstSongResult();
        clickAddToButton();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(mNotficationText));

    }
}
