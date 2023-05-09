package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PlaylistsPage extends BasePage {
    public PlaylistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By choosePlaylist = By.cssSelector("#playlists > ul > li:nth-child(3)");
    By addNewPlaylistName = By.cssSelector("[name='name']");

    public String isNameUpdated() {
        By ModifiedName = By.cssSelector("div.alertify-logs.top.right");
        return findElement(ModifiedName).getText();
    }

    public void doubleClickPlaylist() {
        doubleClick(choosePlaylist);
    }

    public void renamePlaylist(String newPlaylistName) {
        findElement(addNewPlaylistName).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        findElement(addNewPlaylistName).sendKeys(newPlaylistName);
        findElement(addNewPlaylistName).sendKeys(Keys.ENTER);
    }
}
