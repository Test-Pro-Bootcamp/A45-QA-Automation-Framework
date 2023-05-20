package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {

        super(givenDriver);
    }

    By firstPlaylist = By.cssSelector("#playlists ul li[class='playlist playlist']");
    By playlistNameField = By.cssSelector("[name='name']");

    public void doubleClickPlaylist(){
        doubleClick(firstPlaylist);
    }
    public void enterNewPlaylistName(String playlistName) {
    findElement(playlistNameField).sendKeys(playlistName);
    findElement(playlistNameField).sendKeys(Keys.CONTROL, "a",Keys.BACK_SPACE);
    findElement(playlistNameField).sendKeys(playlistName);
    findElement(playlistNameField).sendKeys(Keys.ENTER);
}
    public boolean doesPlaylistExist() {
        By newPlaylist = By.cssSelector("#playlists ul li[class='playlist playlist']");
        return findElement(newPlaylist).isDisplayed();
    }

    By userAvatarIcon = By.cssSelector("img.avatar");
    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
}
