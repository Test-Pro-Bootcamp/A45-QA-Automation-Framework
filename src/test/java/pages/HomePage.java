package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By firstPlaylist = By.cssSelector("#mainWrapper #sidebar #playlists li:nth-child(3)");
    private By editPlaylistButton = By.cssSelector(".menu.playlist-item-menu li:nth-child(1)");
    private By playlistField = By.cssSelector("input[data-testid='inline-playlist-name-input']");
    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
    public void rightClickFirstPlaylist () {
        contextClick(firstPlaylist);
    }
    public void clickEdit () {
        click(editPlaylistButton);
    }
    public void enterPlaylistName () {
        findElement(playlistField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playlistField).sendKeys("MyPlaylist");
        findElement(playlistField).sendKeys(Keys.ENTER);
    }
    public void assertPlaylistExist () {
        WebElement upDatedName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper #sidebar #playlists a.active")));
        Assert.assertEquals(upDatedName.getText(),"MyPlaylist");
    }
}
