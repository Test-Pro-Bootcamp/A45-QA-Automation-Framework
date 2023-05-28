import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public static void deleteThePlaylist() throws InterruptedException {

        String deletedPlaylistMsg = "Deleted playlist";//replace with the del
        provideEmail("pdr.deepthi@gmail.com");
        providePassword("te$t$tudent1");
        clickSubmit();
        Thread.sleep(2000);
        openPlaylist();
        Thread.sleep(2000);
        clickDeletePlaylistBtn();
        Thread.sleep(2000);
        Assert.assertTrue(getdeletedPlaylistMsg().contains(deletedPlaylistMsg));

    }
}