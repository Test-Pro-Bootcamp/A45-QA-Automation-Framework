import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String playlistName = "\"new.\"";

        provideEmail("amanda.martins@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        WebElement selectPlaylist = driver.findElement(By.cssSelector(".side.side-nav #playlists li:nth-child(3)"));
        selectPlaylist.click();
        Thread.sleep(2000);

        WebElement deletePlaylist = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(2000);

        WebElement notificationMessage = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertEquals(notificationMessage.getText(), "Deleted playlist "+playlistName);
        Thread.sleep(2000);
    }
}
