package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistsPage extends BasePage {
    public PlaylistsPage(WebDriver givenDriver) {super(givenDriver);}

    //Page Factory using @FindBy annotation
    @FindBy(css = "#playlists > ul > li:nth-child(3)")
    private WebElement choosePlaylist;

    @FindBy(css = "[name='name']")
    private WebElement addNewPlaylistName;

    @FindBy(css = "div.alertify-logs.top.right")
    private WebElement modifiedName;

    public String isNameUpdated() {
        return modifiedName.getText();
    }

    public PlaylistsPage renamePlaylist(String newPlaylistName) {
        addNewPlaylistName.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        addNewPlaylistName.sendKeys(newPlaylistName);
        addNewPlaylistName.sendKeys(Keys.ENTER);
        return this;
    }

    public PlaylistsPage doubleClickPlaylist() {
        actions.doubleClick(choosePlaylist).perform();
        return this;
    }
}