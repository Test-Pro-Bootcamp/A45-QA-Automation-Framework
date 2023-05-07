package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
public HomePage(WebDriver givenDriver) {super(givenDriver);}
    By firstPlaylist = By.cssSelector("a[href='#!/playlist/55914']");
    By playlistEditButton = (By.xpath("//*[@id='playlists']/ul/li[3]/nav/ul/li[1]"));
    By playlistNameField =By.cssSelector("[name='name']");
    public void contextClick() {
       contextClick(firstPlaylist);
    }
    public void clickEditPlaylistButton(){
        findElement(playlistEditButton).click();
    }
    public void enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys("");
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys("SNKim");
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String playlistName) {
        By newPlaylist = By.xpath("//a[text()='SNKim']");
        return findElement(newPlaylist).isDisplayed();
    }
}

