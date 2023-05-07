package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    By firstPlaylist = By.xpath("//li[@class='playlist playlist'][1]");
    By playlistNameField = By.xpath("//input[@name='name']");
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");
    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
    public HomePage doubleClickFirstPlaylist(){
        doubleClick(firstPlaylist);
        return this;
    }
    public HomePage enterNewPlaylistName (String newPlaylistName){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(newPlaylistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }

    public boolean doesPlaylistExists(String newPlaylistName){
        By newPlaylist = By.xpath(String.format("//a[text()='%s']",newPlaylistName));
        return findElement(newPlaylist).isDisplayed();
    }

}
