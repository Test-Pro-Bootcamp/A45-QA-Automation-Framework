import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
       String deletedPlaylistMsg = "Deleted Playlist";

        provideEmail();
        providePassword();
        logInButton();

        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//li[5]]"));
        playlist.click();
        WebElement deletePlaylist = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePlaylist.click();
        Thread.sleep(2000);
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }
        public String getDeletedPlaylistMsg(){
        WebElement deletePlaylistMsg = driver.findElement(By.xpath("//div[@class='success show']"));
        return deletePlaylistMsg.getText();

    }
}
