package POM;
import net.bytebuddy.asm.Advice;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
public class PlaylistPage extends BasePage {

    @FindBy (xpath = "//section[@id='playlists']//li[@class='playlist playlist']//a[position()]")
    private WebElement firstPlaylistFromList;
    @FindBy (xpath = "//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']")
    private WebElement deletePlaylistBtn;
    @FindBy (css = "#playlistWrapper tr.song-item td.artist")
    private WebElement firstSong;
    @FindBy (css = "#playlistWrapper tr.song-item.selected td.artist")
    private WebElement firstSongSelected;

    public PlaylistPage (WebDriver givenDriver) {super (givenDriver);}

    public PlaylistPage deleteEmptyPlaylist () {
        click(firstPlaylistFromList);
        click(deletePlaylistBtn);
        return this;
    }
    public PlaylistPage clickFirstSong () {
        click(firstSong);
        return this;
    }
    public PlaylistPage firstSongIsPresent () {
        Assert.assertTrue(firstSong.isDisplayed());
        return this;
    }
}
