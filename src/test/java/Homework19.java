import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        //I will comment (instead of deleting) all the old code that I don't need after implementing Waits. This way the change is visible.

        //This will create a playlist to delete it later
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//i[@title='Create a new playlist']"))).click();
        //WebElement createNewPlaylistBtn = driver.findElement(By.xpath("//section[@id='playlists']//i[@title='Create a new playlist']"));
        //createNewPlaylistBtn.click();
        //Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@data-testid='playlist-context-menu-create-simple']"))).click();
        //WebElement newPlaylistOption = driver.findElement(By.xpath("//section[@id='playlists']//li[@data-testid='playlist-context-menu-create-simple']"));
        //newPlaylistOption.click();
        //Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//input[@name='name']"))).click();
        WebElement newPlaylistName = driver.findElement(By.xpath("//section[@id='playlists']//input[@name='name']"));
        //newPlaylistName.click();
        newPlaylistName.sendKeys("NewPLaylist" + Keys.ENTER);
        Thread.sleep(5000); //This Thread.sleep is needed for this test. In this 5 seconds one successful notification disappears so the other one can appear without interfering.

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[position()]"))).click();
        //WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[position()]"));
        //playlist.click();
        //Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']"))).click();
        //WebElement deletePlaylistBtn = driver.findElement(By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']"));
        //deletePlaylistBtn.click();
        //Thread.sleep(500);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        WebElement succesShowNotif = driver.findElement(By.xpath("//div[@class='success show']"));
        Assert.assertEquals(succesShowNotif.getText(), "Deleted playlist \"NewPLaylist.\"");

        //Test needs to be runned from the Terminal using Gradle clean test. This way Parameters setted in the TestNG.xml will work.
    }
}
