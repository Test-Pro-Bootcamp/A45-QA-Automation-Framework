package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    String newPlaylistName = null;
    //locator
    By firstPlaylist = By.cssSelector("li.playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='name']");

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    public void doubleClickFirstPlaylist(){
        doubleClick(firstPlaylist);
    }

    public void enterNewPLaylistName(String newPlaylistName) {
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(newPlaylistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public boolean doesNewPlaylistexist(String newPlaylisrtName){
        By newPlaylist = By.xpath("//a[text()='kristina.matskaylo2']");
        return findElement(newPlaylist).isDisplayed();
    }
}
