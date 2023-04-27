import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        WebElement playlistHW17 = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3)"));
        playlistHW17.click();

        WebElement deletePlaylist = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deletePlaylist.click();

        WebElement okButton = driver.findElement(By.cssSelector("button.ok"));
        okButton.click();
        Thread.sleep(2000);

        WebElement successMessage = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(successMessage.getText() ,"Deleted playlist \"HW17.\"");
    }
}
