import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;

public class Homework19 extends BaseTest {

    public static void clickPlaylist() {
        WebElement clickPlaylist = driver.findElement(By.xpath ("//*[@id=\"playlists\"]/ul/li/a[contains(text(), \"My List\")]"));
        clickPlaylist.click();
    }

    public static void createPlaylist() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i[title='Create a new playlist']")));
        WebElement createPlaylist = driver.findElement(By.cssSelector ("i[title='Create a new playlist']"));
        createPlaylist.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        WebElement newPlaylist = driver.findElement(By.cssSelector ("li[data-testid='playlist-context-menu-create-simple']"));
        newPlaylist.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement newPlaylistInput = driver.findElement(By.cssSelector ("form[class='create'] input[type='text']"));
        newPlaylistInput.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        newPlaylistInput.sendKeys("My List");
        newPlaylistInput.sendKeys(Keys.RETURN);
    }

    public static void clickRedButton() {
        WebElement clickRedButton = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        clickRedButton.click();
    }

    @Test
    public void deletePlaylist() throws InterruptedException {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='home active']")));
        createPlaylist();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id='playlists']//*[contains(text(), 'My List')]")));
        clickPlaylist();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
        clickRedButton();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Deleted playlist')]")));
        WebElement deletePlaylistNotif = driver.findElement(By.xpath("//*[contains(text(),'Deleted playlist')]"));

        Assert.assertEquals(deletePlaylistNotif.getText(), "Deleted playlist \"My List.\"");
    }
}
