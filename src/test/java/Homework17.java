import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String mPlayList = "TestPlaylist";
        String mNotficationText="Added 1 song into \"" + mPlayList +"."+ "\"";
        navigateToPage();
        provideEmail("latha.baliga@testpro.io");
        providePassword("1te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        searchSong("dark");
        Thread.sleep(2000);

        clickViewAllButton();
        Thread.sleep(2000);

        clickFirstSongResult();
        Thread.sleep(2000);

        clickAddToButton();
        Thread.sleep(2000);

        choosePlaylist();
        Thread.sleep(2000);

      Assert.assertEquals(getNotificationText(),mNotficationText);

    }
}
