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
public class HomePage extends BasePage {

    @FindBy (css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(xpath = "//div[@class='success show']")
    private WebElement successShowNotification;
    @FindBy(xpath = "//section[@id='playlists']//li[@class='playlist playlist']//a[position()]")
    private WebElement firstPlaylist;
    @FindBy(xpath = "//section[@id='playlists']//input[@name='name']")
    private WebElement setPlaylistName;
    @FindBy(xpath = "//section[@id='playlists']//i[@title='Create a new playlist']")
    private WebElement createNewPlaylistBtn;
    @FindBy(xpath = "//section[@id='playlists']//li[@data-testid='playlist-context-menu-create-simple']")
    private WebElement newSimplePlaylist;


    public HomePage (WebDriver givenDriver) {
        super (givenDriver);
    }

    public HomePage isAvatarDisplayed () {
        findElement(userAvatarIcon);
        Assert.assertTrue(userAvatarIcon.isDisplayed());
        return this;
    }

    public HomePage createNewPlaylist () {
        click(createNewPlaylistBtn);
        click(newSimplePlaylist);
        click(setPlaylistName);
        setPlaylistName.sendKeys("AutomatedNewPlaylist" + Keys.ENTER);
        return this;
    }

    public HomePage successShowNotificationDisplayed () {
        //findElement(successShowNotification);
        findElement (successShowNotification);
        WebElement successNotification = (successShowNotification);
        Assert.assertTrue(successNotification.isDisplayed());
        return this;
    }

    public HomePage doubleClickPlaylist () {
        doubleClick(firstPlaylist); return this;
    }
    public HomePage enterNewPlaylistName (String playlistName) {
        setPlaylistName.click();
        setPlaylistName.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        setPlaylistName.sendKeys(playlistName);
        setPlaylistName.sendKeys(Keys.ENTER);
        return this;
    }
}
