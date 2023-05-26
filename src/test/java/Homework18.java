import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playASong() throws InterruptedException {
        provideEmail("pdr.deepthi@gmail.com");
        providePassword("te$t$tudent1");
        clickSubmit();
        Thread.sleep(2000);
        clickPlay();
        Assert.assertTrue(isSongPlaying());


    }

}
