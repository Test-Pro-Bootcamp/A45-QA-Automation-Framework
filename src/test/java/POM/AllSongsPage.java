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
public class AllSongsPage extends BasePage {

    @FindBy (css = "#sidebar  .songs")
    private WebElement AllSongs;
    @FindBy (css = "#songsWrapper .song-item .title")
    private WebElement FirstSong;
    @FindBy (css = "#songsWrapper .btn-add-to")
    private WebElement AddToBtn;
    @FindBy (css = "#songsWrapper .add-to li.playlist")
    private WebElement FirstPlaylist;
    @FindBy(xpath = "//div[@class='success show']")
    private WebElement successShowNotification;

    public AllSongsPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    public AllSongsPage openAllSongsPage () {
        WebElement AllSongsTab = AllSongs;
        AllSongsTab.click();
        return this;
    }
    public AllSongsPage clickFirstSong () {
        WebElement firstSong = FirstSong;
        firstSong.click();
        return this;
    }
    public AllSongsPage clickAddToBtn () {
        WebElement addToBtn = AddToBtn;
        addToBtn.click();
        return this;
    }
    public AllSongsPage clickAddFirstPlaylist () {
        WebElement addToFirstPlaylist = FirstPlaylist;
        addToFirstPlaylist.click();
        return this;
    }
    public AllSongsPage successShowNotification () {
        Assert.assertTrue(successShowNotification.isDisplayed());
        return this;
    }

}
