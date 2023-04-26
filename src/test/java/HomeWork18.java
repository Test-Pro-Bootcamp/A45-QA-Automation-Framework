import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {
    @Test
     public void playSong() throws InterruptedException {

       navigateToPage();
       enterCredentials();
       clickPlayNextSongButton();
       clickPlaySongButton();
       idDisplayedSoundBars();
    }

}
