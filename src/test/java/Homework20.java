import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void playFirstSongInAllSongsPlaylist() throws InterruptedException {

        validLoginCredentials();
        clickAllSongs();
        selectFirstSong();
        clickNextSong();
        clickPlayButton();
        validateTheSoundBar();
    }
}

