import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework20 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        String deletedPlaylistMsg = "Deleted playlist";

        provideEmail();
        providePassword();
        logInButton();

        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[5]")));
                //driver.findElement(By.xpath("//section[@id='playlists']//li[5]"));
        playlist.click();
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='del btn-delete-playlist']")));
              //  driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePlaylist.click();
       // Thread.sleep(2000);
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }
    public String getDeletedPlaylistMsg(){
        WebElement deletePlaylistMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
              //  driver.findElement(By.xpath("//div[@class='success show']"));
        return deletePlaylistMsg.getText();

    }
}

