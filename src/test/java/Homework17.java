import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
     public static void addSongToPlaylist() {

       String notifacationMessage = "Added 1 song into 'New name.'";

       navigateToPage();
       enterCredentials();

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys("Dark");
        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        WebElement fisrtTitle = driver.findElement(By.cssSelector(".search-results .song-item:nth-of-type(1) .title"));
        fisrtTitle.click();
        WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButton.click();
        WebElement playlistNewName = driver.findElement(By.cssSelector("#songResultsWrapper ul .playlist:nth-of-type(5)"));
        playlistNewName.click();
        WebElement notificationMessage = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(notificationMessage.isDisplayed());
    }

}
