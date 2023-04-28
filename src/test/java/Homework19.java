import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.Keys;

public class Homework19 extends BaseTest{
    @Test
    @Parameters ({"BaseURL"})
    public static void deletePlaylist() throws InterruptedException {
        navigateToPage(url);
        provideEmail("asdASD@mail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        //This will create a playlist to delete it later
        WebElement createNewPlaylistBtn = driver.findElement(By.xpath("//section[@id='playlists']//i[@title='Create a new playlist']"));
        createNewPlaylistBtn.click();
        Thread.sleep(1000);

        WebElement newPlaylistOption = driver.findElement(By.xpath("//section[@id='playlists']//li[@data-testid='playlist-context-menu-create-simple']"));
        newPlaylistOption.click();
        Thread.sleep(1000);

        WebElement newPlaylistName = driver.findElement(By.xpath("//section[@id='playlists']//input[@name='name']"));
        newPlaylistName.click();
        newPlaylistName.sendKeys("NewPLaylist" + Keys.ENTER);
        Thread.sleep(5000);

        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[position()]"));
        playlist.click();
        Thread.sleep(1000);

        WebElement deletePlaylistBtn = driver.findElement(By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']"));
        deletePlaylistBtn.click();
        Thread.sleep(500);

        WebElement succesShowNotif = driver.findElement(By.xpath("//div[@class='success show']"));
        Assert.assertEquals(succesShowNotif.getText(), "Deleted playlist \"NewPLaylist.\"");
    }
}
