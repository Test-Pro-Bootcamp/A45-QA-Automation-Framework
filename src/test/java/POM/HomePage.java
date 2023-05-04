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
public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");
    By successShowNotification = By.xpath("//div[@class='success show']");
    By firstPlaylist = By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[position()]");
    By setPlaylistName = By.xpath("//section[@id='playlists']//input[@name='name']");
    By createNewPlaylistBtn = By.xpath("//section[@id='playlists']//i[@title='Create a new playlist']");
    By newSimplePlaylist = By.xpath("//section[@id='playlists']//li[@data-testid='playlist-context-menu-create-simple']");



    public HomePage (WebDriver givenDriver) {
        super (givenDriver);
    }

    public WebElement getUserAvatar () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

    public void createNewPlaylist () {
        click(createNewPlaylistBtn);
        click(newSimplePlaylist);
        click(setPlaylistName);
        findElement(setPlaylistName).sendKeys("AutomatedNewPlaylist" + Keys.ENTER);
    }

    public void successShowNotificationDisplayed () {
        findElement(successShowNotification);
        WebElement successNotification = driver.findElement(successShowNotification);
        Assert.assertTrue(successNotification.isDisplayed());
    }

    public void doubleClickPlaylist () {
        doubleClick(firstPlaylist);
    }
    public void enterNewPlaylistName (String playlistName) {

        findElement(setPlaylistName).click();
        findElement(setPlaylistName).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        findElement(setPlaylistName).sendKeys(playlistName);
        findElement(setPlaylistName).sendKeys(Keys.ENTER);
    }
}
