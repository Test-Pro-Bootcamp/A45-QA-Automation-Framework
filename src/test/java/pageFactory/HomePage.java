package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage extends BasePage{

    private @FindBy(css = "a[href='#!/playlist/55914']")
    WebElement firstPlaylist;

    private @FindBy(xpath = "//*[@id='playlists']/ul/li[3]/nav/ul/li[1]")
    WebElement playlistEditButton;

    private @FindBy(css = "[name='name']")
    WebElement playlistNameField;
    public HomePage(WebDriver givenDriver) {super(givenDriver);}
    public HomePage doubleClickFirstPlaylist() {
        doubleClick(firstPlaylist);
        return this;
    }
    public HomePage clickEditPlaylistButton(){
        findElement(playlistEditButton).click();
        return this;
    }
    public HomePage enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys("");
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys("SNKim");
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }
    public String retrievePlaylistName() {
        return findElement(firstPlaylist).getText();
    }
}


