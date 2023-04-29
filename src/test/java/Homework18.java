import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    //add new xml file - build with graddle or just xml
    @Test()
    public void playSong() {
        provideEmail("demo@class.com"); // add data provider
        providePassword("te$t$tudent"); // check tips in pptx #19
        clickSubmit();
        isAvatarDisplayed();
        playNextSong();
        Assert.assertTrue(isSongPlaying());
    }

}
