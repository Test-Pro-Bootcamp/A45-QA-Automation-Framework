import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseT {

    @Test
    public void PlayASongTest() throws InterruptedException {
        //GIVEN - Log in to Koel website
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        //WHEN - Click the next song button and click play
        clickPlay();
        Thread.sleep(2000);

        //THEN -validate that a song is playing by verifying if the pause button is displayed
        Assert.assertTrue(isSongPlaying());
    }
}