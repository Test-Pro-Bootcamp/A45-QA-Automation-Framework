import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist()  {
        String playlistName = "\"new.\"";

        provideEmail("amanda.martins@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement selectPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".side.side-nav #playlists li:nth-child(3)")));
        selectPlaylist.click();

        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".del.btn-delete-playlist")));
        deletePlaylist.click();

        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        Assert.assertEquals(notificationMessage.getText(), "Deleted playlist "+playlistName);
    }
}