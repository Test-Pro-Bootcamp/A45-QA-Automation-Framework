import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    String updatedMsg = "Updated playlist";

    @Test
    public void renamePlaylistTest() {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        doubleClickPlaylist();
        renamePlaylist("Renamed Playlist");
        Assert.assertTrue(isNameUpdated().contains(updatedMsg));
    }

    public String isNameUpdated() {
        WebElement ModifiedName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.alertify-logs.top.right")));
        return ModifiedName.getText();
    }

    public void renamePlaylist(String newPlaylistName) {
        WebElement addNewPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        addNewPlaylistName.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        addNewPlaylistName.sendKeys(newPlaylistName);
        addNewPlaylistName.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist() {
        WebElement choosePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3)")));
        actions.doubleClick(choosePlaylist).perform();
    }
}