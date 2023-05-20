import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Homework20 extends BaseTest{

    @Test
    public void deletePlaylist() {

        provideEmail("rishkodaria@gmail.com");
        providePassword("2743782dasha!");
        clickSubmit();
        openPlaylistOne();
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletePlaylistMsg().contains(getDeletePlaylistMsg()));
    }
    public void openPlaylistOne() {
        WebElement onePlaylist = driver.findElement(By.cssSelector("#playlists ul li[class='playlist playlist']"));
        onePlaylist.click();
    }

    public void clickDeletePlaylistBtn() {
    WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
    deletePlaylist.click();
    }

    public String getDeletePlaylistMsg() {
    WebElement deleteMsg = driver.findElement(By.cssSelector("div.success.show"));
    return deleteMsg.getText();
    }
}