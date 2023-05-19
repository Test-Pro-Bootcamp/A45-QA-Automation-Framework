package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //web elements Page factory
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(css = "#mainWrapper #sidebar #playlists li:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(css = ".menu.playlist-item-menu li:nth-child(1)")
    private WebElement editPlaylistButton;
    @FindBy(css = "input[data-testid='inline-playlist-name-input']")
    private WebElement playlistField;

    //methods fluent interface
//    public WebElement getUserAvatar () {
//       return findElement(userAvatarIcon);
//    }

    public HomePage rightClickFirstPlaylist () {
        contextClick(firstPlaylist);
        return this;
    }
    public HomePage clickEdit () {
        click(editPlaylistButton);
        return this;
    }
    public HomePage enterPlaylistName () {
        playlistField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistField.sendKeys("MyPlaylist");
        playlistField.sendKeys(Keys.ENTER);
        return this;
    }
//    public void assertPlaylistExist () {
//        WebElement upDatedName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper #sidebar #playlists a.active")));
//        Assert.assertEquals(upDatedName.getText(),"MyPlaylist");
//    }
}
