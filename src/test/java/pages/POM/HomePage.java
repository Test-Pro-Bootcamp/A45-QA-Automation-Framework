package pages.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class HomePage extends BasePage {
    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePage (WebDriver givenDriver){
        super(givenDriver);
    }

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }
    By firstPlaylist = By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[position()]");
    By playlistNameField = By.xpath("//input[@name='name']");

    public void doubleCLickPlaylist() {
        doubleClick(firstPlaylist);
    }
    public void enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist (String playlistName) {
        By newPlaylist = By.xpath("//a[text()='"+playlistName+"']");
        return findElement(newPlaylist).isDisplayed();
    }
}
